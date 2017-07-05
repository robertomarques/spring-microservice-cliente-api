package br.com.microservice.cliente.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private TipoPessoaEnum tipoPessoa;
	private DadosPF dadosPF;
	private DadosPJ dadosPJ;
	@NotNull
	@Email
	@Id
	private String email;
	@NotNull
	@NotBlank
	private String senha;
	@NotNull
	@NotBlank
	private String ddd;
	@NotNull
	@NotBlank
	private String telefone;
	@NotNull
	@NotBlank
	private String cep;
	@NotNull
	private Date dataNascimento;
	
	private Date dataInclusao = new Date();
	
	public TipoPessoaEnum getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public DadosPF getDadosPF() {
		return dadosPF;
	}
	public void setDadosPF(DadosPF dadosPF) {
		this.dadosPF = dadosPF;
	}
	public DadosPJ getDadosPJ() {
		return dadosPJ;
	}
	public void setDadosPJ(DadosPJ dadosPJ) {
		this.dadosPJ = dadosPJ;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
	
}
