package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author João Victor
 * @RA 201516689
 */
@Repository
public class FilaDAO {
	private Connection conn;
	@PersistenceContext
	EntityManager controlador;

	@Autowired
	public FilaDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<Fila> listarFilas() throws IOException {
		return  controlador.createQuery("select id_fila, nm_fila from fila").getResultList();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public Fila carregar(int id) throws IOException {
		return controlador.find(Fila.class, id);
	}

}
