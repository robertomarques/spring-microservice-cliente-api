package br.com.microservice.cliente.api.test.controller;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.microservice.cliente.api.controller.ClienteController;
import br.com.microservice.cliente.api.model.Cliente;
import br.com.microservice.cliente.api.model.DadosPF;
import br.com.microservice.cliente.api.model.Login;
import br.com.microservice.cliente.api.model.Resultado;
import br.com.microservice.cliente.api.model.TipoPessoaEnum;
import br.com.microservice.cliente.api.repository.ClienteRepository;
import br.com.microservice.cliente.api.security.GeracaoHashException;
import br.com.microservice.cliente.api.security.GeradorHash;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class ClienteControllerTest {
	
	@Autowired
	private ClienteController clienteController;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private GeradorHash geradorHash;

	@Test
	public void testIncluirRetornaStatusCreated() {
		ResponseEntity<Resultado> response = clienteController.incluir(getCliente());
		Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	private Cliente getCliente() {
		Cliente cliente = new Cliente();
		cliente.setCep("0000000000");
		cliente.setDadosPF(new DadosPF());
		cliente.setDataNascimento(new Date());
		cliente.setDdd("11");
		cliente.setEmail("teste@teste");
		cliente.setSenha("123456");
		cliente.setTelefone("123456789");
		cliente.setTipoPessoa(TipoPessoaEnum.PF);
		return cliente;
	}

	@Test
	public void testIncluirEChamadaClienteRepository() {
		Cliente cliente = getCliente();
		clienteController.incluir(cliente);
		Mockito.verify(clienteRepository).save(cliente);
	}
	
	
	@Test
	public void testAutenticarEChamadaClienteRepository() throws GeracaoHashException {
		Login login = new Login();
		login.setEmail("teste@teste");
		login.setSenha("123456");
		clienteController.autenticar(login);
		Mockito.verify(clienteRepository).findByEmailAndSenha(login.getEmail(), geradorHash.gerar(login.getSenha()));
	}
	
}
