package impressaoAbstractFactory;
/**
 * 
 * @author Jo�o Victor
 * @RA 201516689
 */
public final class ImpressaoFactoryProducer {
	private ImpressaoFactoryProducer(){
		throw new AssertionError();
	}

	public static AbstractImpressaoFactory getFactory(String t){
		
		switch(t)
		{
			case "ImpressaoFactory": return new ImpressaoFactory();
		}

		return null;
	}
}
