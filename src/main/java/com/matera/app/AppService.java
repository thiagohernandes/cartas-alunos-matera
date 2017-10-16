package com.matera.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.matera.services.AlunoService;

/**
 * APP-API
 * Classe principal dos servi�os REST
 * @author Thiago Hernandes de Souza
 * @since 16-10-2017
 * */
@ApplicationPath("/api")
public class AppService extends Application{
	private Set<Object> singletons = new HashSet<Object>();

	/**
	 * M�todos App Singleton
	 * @author Thiago Hernandes de Souza
	 * @since 16-10-2017
	 * */
	public AppService() {
		singletons.add(new AlunoService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}