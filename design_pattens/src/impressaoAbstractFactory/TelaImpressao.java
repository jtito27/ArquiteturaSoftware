package impressaoAbstractFactory;
/**
 * 
 * @author João Victor
 * @RA 201516689
 */
public class TelaImpressao implements Impressao{

	@Override
	public void imprimir() {
		System.out.println("EU SOU TELA");
		
	}

}
