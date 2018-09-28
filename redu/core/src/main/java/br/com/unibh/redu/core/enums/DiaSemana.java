package br.com.unibh.redu.core.enums;

/**
 * Enumerador para mapear os dias da semana
 * 
 * @author Lucas Gabriel
 *
 */
public enum DiaSemana {
	DOMINGO("Domingo"), SEGUNDA("Segunda"), TERCA("Terça"), QUARTA("Quarta"), QUINTA("Quinta"), SEXTA("Sexta"),
	SABADO("Sabado");

	private final String descricao;

	private DiaSemana(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
