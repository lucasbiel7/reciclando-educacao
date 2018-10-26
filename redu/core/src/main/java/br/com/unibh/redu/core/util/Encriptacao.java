package br.com.unibh.redu.core.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Logger;

public class Encriptacao {

	private Encriptacao() {
		super();
	}

	private static Encriptacao encriptacao;

	public static Encriptacao getInstance() {
		if (encriptacao == null) {
			encriptacao = new Encriptacao();
		}
		return encriptacao;
	}

	public String criptar(String senha) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] senhaHash = messageDigest.digest(senha.getBytes(StandardCharsets.UTF_8));
			return Base64.getEncoder().encodeToString(senhaHash);
		} catch (NoSuchAlgorithmException e) {
			Logger.getLogger(Encriptacao.class.getName()).severe(e.getMessage());
		}
		return senha;
	}
}
