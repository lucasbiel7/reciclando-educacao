package br.com.unibh.redu.core.util;

public class InfoDados {
	/**
	 * Constante para nome da escola
	 */
	public static final String NOME_ESCOLA = "NO_ENTIDADE";
	/**
	 * Constante para saber o tipo da dependencia enumerado para validar a resposta
	 * 
	 */
	public static final String TIPO_ESCOLA = "TP_DEPENDENCIA";
	/**
	 * Constante para saber se tem laboratorio de informatica
	 * 
	 */
	public static final String LABORATORIO_INFORMATICA = "IN_LABORATORIO_INFORMATICA";
	/**
	 * Constante para saber se tem laboratorio de ciencias
	 * 
	 */
	public static final String LABORATORIO_CIENCIAS = "IN_LABORATORIO_CIENCIAS";
	/**
	 * Quantidade de computadores para uso dos aluno
	 */
	public static final String COMPUTADOR_ALUNO = "NU_COMP_ALUNO";
	/**
	 * Contante para saber se a escola possui internet
	 */
	public static final String INTERNET = "IN_INTERNET";

	/**
	 * Quantidade de retroprojetores
	 * 
	 */
	public static final String RETROPROJETORES = "NU_EQUIP_RETROPROJETOR";
	/**
	 * Quantidade de dispositivos multimidia
	 */
	public static final String MULTIMIDIA = "NU_EQUIP_MULTIMIDIA";

	public enum TipoEscola {
		// 1 - Federal 2 - Estadual 3 - Municipal 4 - Privada
		FEDERAL, ESTADUAL, MUNICIPAL, PRIVADA;

		public String getValue() {
			return String.valueOf(ordinal() + 1);
		}
	}

	public enum RespostaTernaria {
		NAO, SIM;

		public String getValue() {
			return String.valueOf(ordinal());
		}
	}
}
