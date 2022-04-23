package tablas;

public class TipoPuestoManagment extends TipoPuesto{

	@Override
	public double valor(IAspecto objeto) {
		TipoPuesto tp= null;
		tp = (TipoPuesto)objeto;
		return tp.managment();
	}
///completo por fila
	@Override
	protected double junior() {
		return -1;
	}

	@Override
	protected double senior() {
		return 1;
	}

	@Override
	protected double managment() {
		return -0.5;
	}

}
