package com.matera.model;

/**
 * Domain Disciplina
 * @author Thiago Hernandes de Souza
 * @since 16-10-2017
 * */
public class Disciplina {
	
	private int id;
	private String nome;
	
	public Disciplina() {}
	
	public Disciplina(int id, String nome) {
		this.id = id;
		this.nome = nome;
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

}
