package br.com.unibh.rest.config;

import java.io.UnsupportedEncodingException;

public abstract class SecurityConstant {

	/**
	 * Tempo de expiração do token JWT
	 */
	public static final int TIME_EXPIRATION = 10;
	public static byte[] KEY;

	static {
		try {
			KEY = "redu-web".getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {

		}
	}
}
