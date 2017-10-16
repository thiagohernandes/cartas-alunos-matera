package com.matera.model;

/**
 * Domain Nota/Disciplina
 * @author Thiago Hernandes de Souza
 * @since 16-10-2017
 * */
public class NotaDisciplina {
	
	private int id;
	private Disciplina disciplina;
	private double nota;
	
	public NotaDisciplina() {}
	
	public NotaDisciplina(int id, Disciplina disciplina, double nota) {
		this.id = id;
		this.disciplina = disciplina;
		this.nota = nota;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
