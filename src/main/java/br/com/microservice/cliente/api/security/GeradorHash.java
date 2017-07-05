package br.com.microservice.cliente.api.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GeradorHash {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public String gerar(String text) throws GeracaoHashException {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
	
			md.update(text.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException  | NoSuchAlgorithmException e) {
			logger.error("ERRO AO GERAR HASH",e);
			throw new GeracaoHashException(e);
		} 
		byte[] digest = md.digest();
		
		return new String(digest);
	}
}
