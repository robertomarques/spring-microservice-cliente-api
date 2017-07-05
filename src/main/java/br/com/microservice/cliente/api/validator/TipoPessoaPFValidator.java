package br.com.microservice.cliente.api.validator;

import org.springframework.stereotype.Component;

import br.com.microservice.cliente.api.exception.TipoPessoaPFComDadosPJException;
import br.com.microservice.cliente.api.exception.TipoPessoaPFSemDadosPFException;
import br.com.microservice.cliente.api.model.Cliente;

@Component
public class TipoPessoaPFValidator {

	public void validate(Cliente cliente) throws TipoPessoaPFSemDadosPFException, TipoPessoaPFComDadosPJException {
		if(cliente.getDadosPF()==null) {
			throw new TipoPessoaPFSemDadosPFException("Dados PF obrigatorio");
		}
		if(cliente.getDadosPJ()!=null) {
			throw new TipoPessoaPFComDadosPJException("Pessoa fisica nao pode conter dados PF");
		}
	}

	
}
