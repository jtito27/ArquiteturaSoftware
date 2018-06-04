package nomesfactory;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author João Victor
 * @RA 201516689
 */

public abstract class AplicacaoNomes {
	private Set<Nome> nomes = new HashSet<Nome>();

	public void adicionarNome(String nome) {
		Nome novoNome = construirNome(nome);
		nomes.add(novoNome);
	}

	public abstract Nome construirNome(String nome);

	public void imprimirNomes() {
		for (Nome nome : nomes)
			System.out.println(nome);
	}
}
