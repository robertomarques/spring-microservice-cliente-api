package br.com.microservice.cliente.api.test.controller;

import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import br.com.microservice.cliente.api.controller.ClienteController;
import br.com.microservice.cliente.api.repository.ClienteRepository;

@Profile("test")
@Configuration
@ComponentScan(value= {"br.com.microservice.cliente.api.validator","br.com.microservice.cliente.api.security"})
public class AppTestConfig {

	@Bean
	@Primary
	public ClienteRepository clienteRepository()  {
		return Mockito.mock(ClienteRepository.class);
	}
	
	
	@Bean
	@Primary
	public ClienteController clienteController()  {
		return new ClienteController(clienteRepository());
	} 
	
}
