package com.matera.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.matera.dao.AlunoDAO;
import com.matera.model.Aluno;

/**
 * Aluno Service
 * @author Thiago Hernandes de Souza
 * @since 16-10-2017
 * */

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlunoService {
	
	@GET
	@Path("/todos")	
	public List<Aluno> todosAlunos(){
		return new AlunoDAO().todosAlunos();
	}

	@GET
	@Path("/{cpf}/notas")
	public List<Aluno> notasAluno(@PathParam("cpf") long cpf){
		return new AlunoDAO().notasAluno(cpf);
	}
	
}
