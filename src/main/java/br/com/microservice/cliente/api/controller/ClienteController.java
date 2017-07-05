package br.com.microservice.cliente.api.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.cliente.api.exception.TipoPessoaPFComDadosPJException;
import br.com.microservice.cliente.api.exception.TipoPessoaPFSemDadosPFException;
import br.com.microservice.cliente.api.exception.TipoPessoaPJComDadosPFException;
import br.com.microservice.cliente.api.exception.TipoPessoaPJSemDadosPJException;
import br.com.microservice.cliente.api.model.Autenticacao;
import br.com.microservice.cliente.api.model.Cliente;
import br.com.microservice.cliente.api.model.Login;
import br.com.microservice.cliente.api.model.Resultado;
import br.com.microservice.cliente.api.repository.ClienteRepository;
import br.com.microservice.cliente.api.security.GeracaoHashException;
import br.com.microservice.cliente.api.security.GeradorHash;
import br.com.microservice.cliente.api.validator.ClienteTipoPessoaValidator;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	

	public ClienteController() {
		super();
	}

	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private GeradorHash geradorHash;
	
	@Autowired
	private ClienteTipoPessoaValidator validator;
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Resultado> incluir(@RequestBody @Valid Cliente cliente) {
		
		try {
			validator.validate(cliente);
			cliente.setSenha(geradorHash.gerar(cliente.getSenha()));
		} catch(TipoPessoaPFComDadosPJException | TipoPessoaPFSemDadosPFException | TipoPessoaPJComDadosPFException |TipoPessoaPJSemDadosPJException e) {
			logger.error("ERROR", e);
			return new ResponseEntity<>(new Resultado(e.getMessage()),HttpStatus.BAD_REQUEST);
		}
		catch (GeracaoHashException e) {
			logger.error("ERROR", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		if(clienteExistente!=null) {
			return new ResponseEntity<>(new Resultado("Cliente ja cadastrado com esse e-mail"),HttpStatus.BAD_REQUEST);
		}
		
		clienteRepository.save(cliente);
		return new ResponseEntity<>(new Resultado("Criado"),HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST,value = "/autenticar")
	public ResponseEntity<Autenticacao> autenticar(@RequestBody @Valid Login login) {
		Cliente cliente;
		try {
			cliente = clienteRepository.findByEmailAndSenha(login.getEmail(), geradorHash.gerar(login.getSenha()));
		} catch (GeracaoHashException e) {
			logger.error("ERROR", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new Autenticacao(cliente!=null),HttpStatus.OK);
	}
}
