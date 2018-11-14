package br.com.unibh.rest.config;

import java.io.UnsupportedEncodingException;

public abstract class SecurityConstant {

	public static byte[] KEY;

	static {
		try {
			KEY = "redu-web".getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {

		}
	}
}
