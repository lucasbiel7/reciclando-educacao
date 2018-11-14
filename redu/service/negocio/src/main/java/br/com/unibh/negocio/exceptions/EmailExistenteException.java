package br.com.unibh.negocio.exceptions;

public class EmailExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4317734648083517515L;

	public EmailExistenteException(String msg) {
		super(msg);
	}

}
