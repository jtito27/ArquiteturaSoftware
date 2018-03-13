package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

public class ChamadoDAO {
	public ArrayList<Chamado> listarChamados(Fila id) throws IOException {
		String query = "select id_chamado, descricao, status from chamado where id_fila = id";
		ArrayList<Chamado> lista = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();){
			
			while(rs.next()) {
				Chamado chamado = new Chamado();
				chamado.setId_chamado(rs.getInt("id_chamado"));
				chamado.setDescricao(rs.getString("descricao"));
				chamado.setStatus(rs.getString("status"));
				lista.add(chamado);
			}
			
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}

}


