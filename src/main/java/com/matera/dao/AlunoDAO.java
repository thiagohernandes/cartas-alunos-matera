package com.matera.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.matera.model.Aluno;
import com.matera.model.Disciplina;
import com.matera.model.NotaDisciplina;
import com.matera.util.Utils;

/**
 * Aluno DAO
 * @author Thiago Hernandes de Souza
 * @since 16-10-2017
 * */
public class AlunoDAO {
	
	private  List<Aluno> listAlunos = new ArrayList<Aluno>();
	
	/**
	 * Método construtor - dados mock
	 * */
	public AlunoDAO() {
		gerarDadosMock();
	}
	
	/**
	 * Add aluno
	 * */
	public void addAluno(Aluno aluno) {
		aluno.setId(listAlunos.size()+1);
		listAlunos.add(aluno);
	}
	
	/**
	 * Update aluno
	 * */
	public void updateAluno(Aluno aluno) {	
		int idx = 0;
		for(Aluno alunoItem : listAlunos) {
			if(alunoItem.getId() == aluno.getId()) {
				alunoItem = aluno;
				listAlunos.set(idx,alunoItem);
				break;
			}
			idx++;
		}		
	}
	
	/**
	 * Delete aluno
	 * */
	public void removeAluno(Aluno aluno) {	
		int idx = 0;
		for(Aluno alunoItem : listAlunos) {
			if(alunoItem.getId() == aluno.getId()) {
				listAlunos.remove(idx);
				break;
			}
			idx++;
		}		
	}
	
	/**
	 * Método de retorno de todos alunos
	 * */
	public List<Aluno> todosAlunos(){
		return listAlunos;
	}
	
	/**
	 * Método de retorno de notas e disciplinas de um determinado aluno
	 * */
	public List<Aluno> notasAluno(long cpf){
		List<Aluno> filtered = listAlunos.stream()
										 .filter(aluno -> aluno.getCpf() == cpf)
										 .collect(Collectors.toList());
		return filtered;
	}
	
	/**
	 * Método de retorno de alunos com notas abaixo da média
	 * */
	public List<Aluno> notasAlunoEmail(){
		List<Aluno> filtered = listAlunos.stream().filter(aluno -> aluno.getNotas()
																	    .stream()
																	    .anyMatch(notaDisciplina->notaDisciplina.getNota() < 7))
				   .collect(Collectors.toList());
		return filtered;
	}
	
	/**
	 * Método de envio de e-mails com o retorno dos envios processados
	 * */
	public int enviarEmails(){
		List<Aluno> filtered = listAlunos.stream().filter(aluno -> aluno.getNotas()
																	    .stream().anyMatch(notaDisciplina->notaDisciplina.getNota() < 7))
				   														.collect(Collectors.toList());
		Utils util = new Utils();
		return util.processEmail(filtered);
	}
	
	/**
	 * Método mock
	 * */
	protected void gerarDadosMock() {
		// Disciplinas
		Disciplina disciplina1 = new Disciplina(1,"Matemática");
		Disciplina disciplina2 = new Disciplina(2,"Física");
		Disciplina disciplina3 = new Disciplina(3,"Inglês");
		
		// Notas/Disciplinas
		// Aluno 1
		List<NotaDisciplina> notasDisciplinasAluno1 = new ArrayList<>();
		NotaDisciplina notaDisciplina1A = new NotaDisciplina(1,disciplina1,6.5);
		NotaDisciplina notaDisciplina1B = new NotaDisciplina(2,disciplina2,7);
		NotaDisciplina notaDisciplina1C = new NotaDisciplina(3,disciplina3,8);
		notasDisciplinasAluno1.add(notaDisciplina1A);
		notasDisciplinasAluno1.add(notaDisciplina1B);
		notasDisciplinasAluno1.add(notaDisciplina1C);		
		Aluno aluno1 = new Aluno(1,"João",123456789,"Rua x, no. 123",15775000,notasDisciplinasAluno1,"hernandes_sp@yahoo.com.br");
		listAlunos.add(aluno1);
		
		// Aluno 2
		List<NotaDisciplina> notasDisciplinasAluno2 = new ArrayList<>();
		NotaDisciplina notaDisciplina2A = new NotaDisciplina(4,disciplina1,8.5);
		NotaDisciplina notaDisciplina2B = new NotaDisciplina(5,disciplina2,9);
		NotaDisciplina notaDisciplina2C = new NotaDisciplina(6,disciplina3,10);
		notasDisciplinasAluno2.add(notaDisciplina2A);
		notasDisciplinasAluno2.add(notaDisciplina2B);
		notasDisciplinasAluno2.add(notaDisciplina2C);		
		Aluno aluno2 = new Aluno(2,"Franscisco",987456321,"Rua z, no. 456",17922000,notasDisciplinasAluno2,"franscisco@hotmail.com");
		listAlunos.add(aluno2);
		// Aluno 3
		List<NotaDisciplina> notasDisciplinasAluno3 = new ArrayList<>();
		NotaDisciplina notaDisciplina3A = new NotaDisciplina(7,disciplina1,9.5);
		NotaDisciplina notaDisciplina3B = new NotaDisciplina(8,disciplina2,9.5);
		NotaDisciplina notaDisciplina3C = new NotaDisciplina(9,disciplina3,10);
		notasDisciplinasAluno3.add(notaDisciplina3A);
		notasDisciplinasAluno3.add(notaDisciplina3B);
		notasDisciplinasAluno3.add(notaDisciplina3C);		
		Aluno aluno3 = new Aluno(3,"Vanessa",1478963211,"Rua z, no. 456",14337000,notasDisciplinasAluno3,"vanessa@terra.com.br");
		listAlunos.add(aluno3);
	}
}
