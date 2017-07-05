package br.com.microservice.cliente.api.model;

import java.io.Serializable;

public class Resultado  implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Resultado(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
