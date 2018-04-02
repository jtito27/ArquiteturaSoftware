package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;


/**
 * 
 * @author João Victor
 * @RA 201516689
 * @Year 2018
 */

@Repository
public class FilaDAO {
	private Connection conn;
	
	@PersistenceContext
	EntityManager manager;
	
	
	public Fila carregar(int id) throws IOException{
		return manager.find(Fila.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Fila> listarFilas() throws IOException{
		return manager.createQuery("select f from Fila f").getResultList();
	}


}
