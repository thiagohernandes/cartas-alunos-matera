package com.matera.model;

import java.util.List;

/**
 * Domain Aluno
 * @author Thiago Hernandes de Souza
 * @since 16-10-2017
 * */
public class Aluno {
	
	private int id;
	private String nome;
	private long cpf;
	private String endereco;
	private long cep;
	private List<NotaDisciplina> notas;
	private String email;
	
	public Aluno(){}
	
	public Aluno(int id, String nome, long cpf, String endereco, long cep, List<NotaDisciplina> notas, String email) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cep = cep;		
		this.notas = notas;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public long getCep() {
		return cep;
	}
	public void setCep(long cep) {
		this.cep = cep;
	}

	public List<NotaDisciplina> getNotas() {
		return notas;
	}

	public void setNotas(List<NotaDisciplina> notas) {
		this.notas = notas;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
