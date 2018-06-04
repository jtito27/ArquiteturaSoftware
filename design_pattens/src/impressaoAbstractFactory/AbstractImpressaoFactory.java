package impressaoAbstractFactory;

/**
 * 
 * @author João Victor
 * @RA 201516689
 */
public interface AbstractImpressaoFactory {
	Impressao getimpressaoInstance(String tipoImpressao);
}
