package br.com.microservice.cliente.api.model;

public enum TipoPessoaEnum {
	PF("Pessoa Fisica"),PJ("Pessoa Juridica");
	
	private String description;
	
	TipoPessoaEnum(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
