package br.com.microservice.cliente.api.test.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.microservice.cliente.api.exception.TipoPessoaPFComDadosPJException;
import br.com.microservice.cliente.api.exception.TipoPessoaPFSemDadosPFException;
import br.com.microservice.cliente.api.exception.TipoPessoaPJComDadosPFException;
import br.com.microservice.cliente.api.exception.TipoPessoaPJSemDadosPJException;
import br.com.microservice.cliente.api.model.Cliente;
import br.com.microservice.cliente.api.model.DadosPF;
import br.com.microservice.cliente.api.model.DadosPJ;
import br.com.microservice.cliente.api.model.TipoPessoaEnum;
import br.com.microservice.cliente.api.test.controller.AppTestConfig;
import br.com.microservice.cliente.api.validator.ClienteTipoPessoaValidator;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class TipoPessoaValidatorTest {
	
	@Autowired
	private ClienteTipoPessoaValidator validator;

	@Test(expected=TipoPessoaPFSemDadosPFException.class)
	public void testTipoPessoaPFSemDadosPF() throws TipoPessoaPFSemDadosPFException, TipoPessoaPFComDadosPJException, TipoPessoaPJSemDadosPJException, TipoPessoaPJComDadosPFException {
		Cliente cliente = new Cliente();
		cliente.setTipoPessoa(TipoPessoaEnum.PF);
		validator.validate(cliente);
	}
	
	@Test(expected=TipoPessoaPJSemDadosPJException.class)
	public void testTipoPessoaPFSemDadosPJ() throws TipoPessoaPFSemDadosPFException, TipoPessoaPFComDadosPJException, TipoPessoaPJSemDadosPJException, TipoPessoaPJComDadosPFException {
		Cliente cliente = new Cliente();
		cliente.setTipoPessoa(TipoPessoaEnum.PJ);
		validator.validate(cliente);
	}
	
	@Test(expected=TipoPessoaPFComDadosPJException.class)
	public void testTipoPessoaPFComDadosPJ() throws TipoPessoaPFSemDadosPFException, TipoPessoaPFComDadosPJException, TipoPessoaPJSemDadosPJException, TipoPessoaPJComDadosPFException {
		Cliente cliente = new Cliente();
		cliente.setTipoPessoa(TipoPessoaEnum.PF);
		cliente.setDadosPJ(new DadosPJ());
		cliente.setDadosPF(new DadosPF());
		validator.validate(cliente);
	}
	
	@Test(expected=TipoPessoaPJComDadosPFException.class)
	public void testTipoPessoaPJComDadosPF() throws TipoPessoaPFSemDadosPFException, TipoPessoaPFComDadosPJException, TipoPessoaPJSemDadosPJException, TipoPessoaPJComDadosPFException {
		Cliente cliente = new Cliente();
		cliente.setTipoPessoa(TipoPessoaEnum.PJ);
		cliente.setDadosPJ(new DadosPJ());
		cliente.setDadosPF(new DadosPF());
		validator.validate(cliente);
	}
}
