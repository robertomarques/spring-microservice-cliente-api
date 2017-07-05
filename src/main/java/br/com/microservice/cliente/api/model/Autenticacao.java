package br.com.microservice.cliente.api.model;

public class Autenticacao {

	private Boolean autenticado;

	public Autenticacao(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public Boolean getAutenticado() {
		return autenticado;
	}

	public void setAutenticado(Boolean autenticado) {
		this.autenticado = autenticado;
	}
	
}
