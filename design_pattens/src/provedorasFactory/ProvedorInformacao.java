package senhafactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * @author João Victor
 * @RA 201516689
 */

public abstract class ProvedorInformacao {
	protected abstract String recuperarInformacao();

	public void exibirInformacao() {
		System.out.println(recuperarInformacao());
	}

	protected Scanner criarScanner(File arquivo) {
		try {
			return new Scanner(arquivo);
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nï¿½o encontrado: " + arquivo.getPath());
			System.exit(1);
		}
		return null;
	}
}
