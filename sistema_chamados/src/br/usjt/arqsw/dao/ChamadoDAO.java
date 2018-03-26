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
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author João Victor
 * @RA 201516689
 */
@Repository
public class ChamadoDAO {
	private Connection conn;
	@PersistenceContext
	EntityManager controlador;
	
	public int inserirChamado(Chamado chamado) throws IOException
	{
		controlador.persist(chamado);
		return chamado.getNumero();
	}
	
	public List<Chamado> listarChamados(Fila fila) throws IOException {
		fila = controlador.find(Fila.class, fila.getId());
		String sql = "select * from Chamado where fila = :fila";
		
		Query query = controlador.createQuery(sql);
		query.setParameter("Fila", fila);
		
		
		List<Chamado> lista = query.getResultList();
		return lista;
	}
	
	public List<Chamado> listarChamadosAbertos(Fila fila)
	{
		fila = controlador.find(Fila.class, fila.getId());
		String sql = "select * from Chamado where fila = :fila and status = :status";
		Query query = controlador.createQuery(sql);
		query.setParameter("Fila", fila);
		query.setParameter("Status", Chamado.ABERTO);
		
		List<Chamado> resultado = query.getResultList();
		return resultado;
	}
	
	public void fecharChamado(List<Integer> lista)
	{
		for(int id:lista)
		{
			Chamado chamado = controlador.find(Chamado.class, id);
			chamado.setDataFechamento(new java.util.Date());
			chamado.setStatus(chamado.FECHADO);
			controlador.merge(chamado);
		}
	}
	@Autowired
	public ChamadoDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	

}
