package br.usjt.arqsw.entity;

import javax.persistence.Entity;
/**
 * 
 * @author João Victor
 * @RA 201516689
 * @Year 2018
 */
@Entity
public class Login {
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
