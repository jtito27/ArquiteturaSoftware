package impressaoAbstractFactory;
/**
 * 
 * @author João Victor
 * @RA 201516689
 */
public class ArquivoImpressao implements Impressao {

	@Override
	public void imprimir() {
		System.out.println("EU SOU ARQUIVO");

	}

}
