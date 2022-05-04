package tablas;

import Interfaces.IAspecto;

public class TipoPuestoSenior extends TipoPuesto{

	@Override
	public double valor(IAspecto objeto) {
		TipoPuesto tp= null;
		tp = (TipoPuesto)objeto;
		return tp.senior();
	}
///completo por fila
	@Override
	protected double junior() {
		return -0.5;
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

