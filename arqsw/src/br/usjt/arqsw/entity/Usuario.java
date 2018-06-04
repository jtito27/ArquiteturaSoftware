package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * 
 * @author João Victor
 * @RA 201516689
 */

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message="O campo usuï¿½rio nï¿½o pode estar vazio.")
	@NotEmpty(message="O campo usuï¿½rio nï¿½o pode estar vazio.")
	@Column(name = "USERNAME")
	private String username;

	@NotNull(message="O campo senha nï¿½o pode estar vazio.")
	@NotEmpty(message="O campo senha nï¿½o pode estar vazio.")
	@Column(name = "PASSWORD")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
