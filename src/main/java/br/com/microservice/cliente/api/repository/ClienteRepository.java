package br.com.microservice.cliente.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.microservice.cliente.api.model.Cliente;


public interface ClienteRepository extends MongoRepository<Cliente, String> {

	public Cliente findByEmailAndSenha(String email, String senha);
	
	public Cliente findByEmail(String email);
}
