package impressaoAbstractFactory;

/**
 * 
 * @author Jo�o Victor
 * @RA 201516689
 */
public interface AbstractImpressaoFactory {
	Impressao getimpressaoInstance(String tipoImpressao);
}
