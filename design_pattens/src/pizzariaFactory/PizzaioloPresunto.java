package pizzariafactory;
/**
 * 
 * @author João Victor
 * @RA 201516689
 */

public class PizzaioloPresunto implements Pizzaiolo {

	public Pizza criarPizza() {
		return new PizzaPresunto();
	}

	@Override
	public Calzone criarCalzone() {
		return new CalzonePresunto();
	}
}
