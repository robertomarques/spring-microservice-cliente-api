package br.com.microservice.cliente.api.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.microservice.cliente.api.exception.TipoPessoaPFComDadosPJException;
import br.com.microservice.cliente.api.exception.TipoPessoaPFSemDadosPFException;
import br.com.microservice.cliente.api.exception.TipoPessoaPJComDadosPFException;
import br.com.microservice.cliente.api.exception.TipoPessoaPJSemDadosPJException;
import br.com.microservice.cliente.api.model.Cliente;
import br.com.microservice.cliente.api.model.TipoPessoaEnum;

@Component
public class ClienteTipoPessoaValidator {
	@Autowired
	TipoPessoaPFValidator tipoPessoaPFValidator;
	@Autowired
	TipoPessoaPJValidator tipoPessoaPJValidator;
	
	public void validate(Cliente cliente) throws TipoPessoaPFSemDadosPFException, TipoPessoaPFComDadosPJException, TipoPessoaPJSemDadosPJException, TipoPessoaPJComDadosPFException {
		if(TipoPessoaEnum.PF.equals(cliente.getTipoPessoa())) {
			tipoPessoaPFValidator.validate(cliente);
		} else {
			tipoPessoaPJValidator.validate(cliente);
		}
	}
}
