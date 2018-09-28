package br.com.unibh.redu.core.enums;

/**
 * Enumerador para medir tamanho da empresa
 * 
 * @author aluno
 *
 */
public enum Tamanho {

	PEQUENO("Pequeno"), MEDIO("Médio"), GRANDE("Grande");

	private final String descricao;

	private Tamanho(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
