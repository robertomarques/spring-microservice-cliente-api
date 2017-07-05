package br.com.microservice.cliente.api.validator;

import org.springframework.stereotype.Component;

import br.com.microservice.cliente.api.exception.TipoPessoaPJComDadosPFException;
import br.com.microservice.cliente.api.exception.TipoPessoaPJSemDadosPJException;
import br.com.microservice.cliente.api.model.Cliente;

@Component
public class TipoPessoaPJValidator {

	public void validate(Cliente cliente) throws TipoPessoaPJSemDadosPJException, TipoPessoaPJComDadosPFException {		
		if(cliente.getDadosPJ()==null) {
			throw new TipoPessoaPJSemDadosPJException("Dados PJ obrigatorio");
		}
		if(cliente.getDadosPF()!=null) {
			throw new TipoPessoaPJComDadosPFException("Pessoa Juridica nao pode conter dados PF");
		}
 	}

}
