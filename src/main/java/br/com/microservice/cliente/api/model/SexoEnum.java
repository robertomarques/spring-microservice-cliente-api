package br.com.microservice.cliente.api.model;

public enum SexoEnum {
  F("FEMININO"), M("MASCULINO");
	
	private String description;

	SexoEnum(String description) {
		this.description = description;
		
	}
	public String getDescription() {
		return description;
	}
	
	
}
