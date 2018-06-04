package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Chamado;

public class ChamadoDAO {
	
	public int criar(Chamado chamado) {
		String sqlInsert = "INSERT INTO cliente(nome, fone, email) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, chamado.getId_chamado());
			stm.setString(2, chamado.getDescricao());
			stm.setString(3, chamado.getStatus());
			stm.setDate(4, chamado.getDt_abertura());
			stm.setDate(5, chamado.getDt_fechamento());
			stm.setInt(6, chamado.getId_fila());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					chamado.setId_chamado(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chamado.getId_chamado();
	}
	
	public void atualizar(Chamado chamado) {
		String sqlUpdate = "UPDATE cliente SET nome=?, fone=?, email=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, chamado.getId_chamado());
			stm.setString(2, chamado.getDescricao());
			stm.setString(3, chamado.getStatus());
			stm.setDate(4, chamado.getDt_abertura());
			stm.setDate(5, chamado.getDt_fechamento());
			stm.setInt(6, chamado.getId_fila());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Chamado carregar(int id) {
		Chamado chamado = new Chamado();
		chamado.setId_chamado(id);
		String sqlSelect = "SELECT nome, fone, email FROM cliente WHERE cliente.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, chamado.getId_chamado());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					chamado.setId_chamado(rs.getInt("id_chamado"));
					chamado.setDescricao(rs.getString("descricao"));
					chamado.setStatus(rs.getString("status"));
					chamado.setDt_abertura(rs.getDate("dt_abertura"));
					chamado.setDt_fechamento(rs.getDate("dt_fechamento"));
					chamado.setId_fila(rs.getInt("id_fila"));
				} else {
					chamado.setId_chamado(-1);
					chamado.setDescricao(null);
					chamado.setStatus(null);
					chamado.setDt_abertura(null);
					chamado.setDt_fechamento(null);
					chamado.setId_fila(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return chamado;
	}
	public ArrayList<Chamado> listarChamado() {
		Chamado chamado;
		ArrayList<Chamado> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, fone, email FROM cliente";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					chamado = new Chamado();
					chamado.setId_chamado(rs.getInt("id_chamado"));
					chamado.setDescricao(rs.getString("descricao"));
					chamado.setStatus(rs.getString("status"));
					chamado.setDt_abertura(rs.getDate("dt_abertura"));
					chamado.setDt_fechamento(rs.getDate("dt_fechamento"));
					chamado.setId_fila(rs.getInt("id_fila"));
					lista.add(chamado);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
}
