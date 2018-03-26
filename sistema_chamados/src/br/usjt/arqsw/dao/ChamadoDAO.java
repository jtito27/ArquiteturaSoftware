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

	@Autowired
	public ChamadoDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	public int inserirChamado(Chamado chamado) throws IOException {
		controlador.persist(chamado);
		return chamado.getNumero();
	}

	public List<Chamado> listarChamados(Fila fila) throws IOException {

		fila = controlador.find(Fila.class, fila.getId());
		
		String sql = "select * from Chamado where fila = :fila";
		
		Query query = controlador.createQuery(sql);
		query.setParameter("fila", fila);

		List<Chamado> resultado = query.getResultList();
		return resultado;
	}
	public List<Chamado> listarChamadosAbertos(Fila fila) throws IOException{
		fila = controlador.find(Fila.class, fila.getId());
		
		String jpql = "select * from Chamado where fila = :fila and status = :status";
		
		Query query = controlador.createQuery(jpql);
		query.setParameter("fila", fila);
		query.setParameter("status", Chamado.ABERTO);

		List<Chamado> result = query.getResultList();
		return result;
	}
	public void fecharChamados(ArrayList<Integer> lista) throws IOException{
		for(int id:lista){
			Chamado chamado = controlador.find(Chamado.class, id);
			chamado.setDataFechamento(new java.util.Date());
			chamado.setStatus(Chamado.FECHADO);
			controlador.merge(chamado);
		}
}

}
