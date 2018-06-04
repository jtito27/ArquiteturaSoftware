package nomesfactory;
/**
 * 
 * @author Jo�o Victor
 * @RA 201516689
 */
import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {

		String nomeCompleto = JOptionPane.showInputDialog(null, "Digite o nome completo:");

		AplicacaoNomes aplicacaoNormal = new AplicacaoNomesNormal();
		AplicacaoNomes aplicacaoInvertido = new AplicacaoNomesInvertido();

		for (int i = 0; i < nomeCompleto.length(); i++) {
			if (nomeCompleto.indexOf(",") != -1)
				aplicacaoInvertido.adicionarNome(nomeCompleto);
			else
				aplicacaoNormal.adicionarNome(nomeCompleto);
		}

		aplicacaoNormal.imprimirNomes();
		aplicacaoInvertido.imprimirNomes();
	}
}
