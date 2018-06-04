package pizzariafactory;
/**
 * 
 * @author Jo�o Victor
 * @RA 201516689
 */


public class PizzaioloCalabresa implements Pizzaiolo {

	public Pizza criarPizza() {
		return new PizzaCalabresa();
	}

	@Override
	public Calzone criarCalzone() {
		return new CalzoneCalabresa();
	}
}
