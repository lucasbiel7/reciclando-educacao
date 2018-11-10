package br.com.unibh.ejb.services;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import br.com.unibh.dao.EscolaDAO;
import br.com.unibh.negocio.service.EscolaService;
import br.com.unibh.redu.core.entities.Escola;
import br.com.unibh.redu.core.util.InfoDados;
import br.com.unibh.redu.core.util.StringUtil;

/**
 * 
 * @author lucas
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EscolaBean implements EscolaService {

	/**
	 * Arquivo armazenado localmente por causa da quantidade de dados
	 * 
	 * InfoDados senso 2015
	 * 
	 * @since 2015
	 */
	public static final String ARQUIVO = "C:/Users/lucas/Documents/Faculdade/PI/3periodo/micro_censo_escolar_2015/2015/DADOS/ESCOLAS/ESCOLAS.CSV";

	private static final Logger LOGGER = Logger.getLogger(EscolaBean.class.getName());
	@Resource
	private UserTransaction userTransaction;

	@Inject
	private EscolaDAO escolaDAO;

	@Override
	public void carregarEscolas() {
		Path path = Paths.get(ARQUIVO);
		try {
			List<String> linhas = Files.readAllLines(path, Charset.defaultCharset());
			if (!linhas.isEmpty()) {
				List<String> cabecalho = Arrays.asList(linhas.get(0).split(";"));
				LOGGER.log(Level.INFO, cabecalho.toString());
				int posicaoNomeEscola = cabecalho.indexOf(InfoDados.NOME_ESCOLA);
				int posicaoTipoEscola = cabecalho.indexOf(InfoDados.TIPO_ESCOLA);
				int posicaoLaboratorioInformatica = cabecalho.indexOf(InfoDados.LABORATORIO_INFORMATICA);
				int posicaoLaboratorioCiencia = cabecalho.indexOf(InfoDados.LABORATORIO_CIENCIAS);
				int posicaoComputadorParaAluno = cabecalho.indexOf(InfoDados.COMPUTADOR_ALUNO);
				int posicaoRetroprojetores = cabecalho.indexOf(InfoDados.RETROPROJETORES);
				int posicaoInternet = cabecalho.indexOf(InfoDados.INTERNET);
				int posicaoMultimidia = cabecalho.indexOf(InfoDados.MULTIMIDIA);

				for (String string : linhas.subList(1, linhas.size())) {
					List<String> campos = Arrays.asList(string.split(";"));
					if (campos.get(posicaoTipoEscola).equals(InfoDados.TipoEscola.MUNICIPAL.getValue())) {

						Escola escola = new Escola();
						escola.setEmail("Desconhecido");
						escola.setNome(campos.get(posicaoNomeEscola));
						escola.setNomeEscola(campos.get(posicaoNomeEscola));
						try {
							long pontuacao = 0;
							/**
							 * Caso tenha laboratorio de informatica infra+10 pontos
							 */
							if (InfoDados.RespostaTernaria.SIM.getValue()
									.equals(campos.get(posicaoLaboratorioInformatica))) {
								pontuacao += 10;
							}
							/**
							 * Caso tenha laboratorio de ciencias infra+10 pontos
							 */
							if (InfoDados.RespostaTernaria.SIM.getValue()
									.equals(campos.get(posicaoLaboratorioCiencia))) {
								pontuacao += 10;
							}
							/**
							 * Caso tenha internet infra+10 pontos
							 */
							if (InfoDados.RespostaTernaria.SIM.getValue().equals(campos.get(posicaoInternet))) {
								pontuacao += 10;
							}
							String valorCompAluno = campos.get(posicaoComputadorParaAluno);
							/**
							 * Caso tenha computador para aluno 3 pontos por computador
							 */
							if (!StringUtil.isEmpty(valorCompAluno)) {
								try {
									pontuacao += Integer.parseInt(valorCompAluno) * 3;
								} catch (NumberFormatException e) {
									LOGGER.log(Level.WARNING, "Não foi possível ler a quantidade de computadores para "
											+ escola.getNomeEscola());
								}
							}
							/**
							 * Quantidade de retroprojetores +8 para cada um na escola
							 * 
							 */
							String valorRetroprojetores = campos.get(posicaoRetroprojetores);
							if (!StringUtil.isEmpty(valorRetroprojetores)) {
								try {
									pontuacao += Integer.parseInt(valorRetroprojetores) * 8;
								} catch (NumberFormatException e) {
									LOGGER.log(Level.WARNING,
											"Não foi possível ler a quantidade de retroprojetores para "
													+ escola.getNomeEscola());
								}
							}
							/**
							 * Equipamentos para aulas com multimidia +5 pontos para cada
							 */
							String valorMultimidia = campos.get(posicaoMultimidia);
							if (!StringUtil.isEmpty(valorMultimidia)) {
								try {
									pontuacao += Integer.parseInt(valorMultimidia) * 5;
								} catch (NumberFormatException e) {
									LOGGER.log(Level.WARNING,
											"Não foi possível ler a quantidade de retroprojetores para "
													+ escola.getNomeEscola());
								}
							}
							escola.setPontuacaoEstrutura(pontuacao);
							try {
								userTransaction.begin();
								escolaDAO.salvar(escola);
								userTransaction.commit();
							} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException
									| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
								try {
									userTransaction.rollback();
								} catch (IllegalStateException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SecurityException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SystemException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}

						} catch (IndexOutOfBoundsException e) {
							LOGGER.severe(escola.getNome() + " não foi possível calcular pontuacao");
						}
					}
				}
			}
			LOGGER.log(Level.INFO, "Finalizando a importação das escolas");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
