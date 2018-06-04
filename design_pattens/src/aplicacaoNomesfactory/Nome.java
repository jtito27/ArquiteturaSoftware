package nomesfactory;
/**
 * 
 * @author João Victor
 * @RA 201516689
 */

public class Nome {
	private String nome;
	private String sobrenome;

	public Nome(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public String toString() {
		return nome + " " + sobrenome;
	}
}
