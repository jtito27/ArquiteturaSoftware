package br.usjt.arqsw.dao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;
/**
 * 
 * @author João Victor
 * @RA 201516689
 */
@Repository
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;
	/**
	 * Mï¿½todo que obtem um usuï¿½rio pelo username
	 * @param userName
	 * @return Usuario
	 * @throws IOException
	 */
	public Usuario obterPorUsuario(String userName) throws IOException {
		return (Usuario) manager.createQuery("select u from Usuario u Where u.username = ?").setParameter(1, userName).getSingleResult();
	}
}
