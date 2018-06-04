package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Login;

@Repository
public class LoginDAO {
	private Connection conn;

	@Autowired
	public LoginDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = ((Statement) dataSource).getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}

	public boolean validaLogin(Login login) throws IOException {
		if (login.getUserName() == null) {
			throw new IllegalArgumentException("Usuario não deve ser nulo");
		}
		String query = "select * from usuarios where username= ? and password= ?";

		try (PreparedStatement pst = conn.prepareStatement(query);) {
			pst.setString(1, login.getUserName());
			pst.setString(2, login.getPassword());
			try (ResultSet rs = pst.executeQuery();) {

				boolean encontrado = rs.next();
				rs.close();
				pst.close();

				return encontrado;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

	}

}
