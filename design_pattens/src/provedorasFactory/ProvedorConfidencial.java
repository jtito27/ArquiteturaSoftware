package senhafactory;

import java.io.File;
import java.util.Scanner;

import util.ResourceUtils;
/**
 * 
 * @author João Victor
 * @RA 201516689
 */

public class ProvedorConfidencial extends ProvedorInformacao {

	protected String recuperarInformacao() {
		String pacote = getClass().getPackage().getName().toString().replace('.', '/');
		File arquivo = ResourceUtils.getResourceAsFile(pacote + "/confidencial.txt");

		StringBuffer buffer = new StringBuffer();

		Scanner scanner = criarScanner(arquivo);
		while (scanner.hasNextLine()) {
			buffer.append(scanner.nextLine());
			buffer.append("\n");
		}
		scanner.close();

		return buffer.toString();
	}
}
