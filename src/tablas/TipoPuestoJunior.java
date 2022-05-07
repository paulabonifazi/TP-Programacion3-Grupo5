package tablas;

import interfaces.IAspecto;

public class TipoPuestoJunior extends TipoPuesto{

	@Override
	public double valor(IAspecto objeto) {
		TipoPuesto tp= null;
		tp = (TipoPuesto)objeto;
		return tp.junior();
	}
///completo por fila
	@Override
	protected double junior() {
		return 1;
	}

	@Override
	protected double senior() {
		return -0.5;
	}

	@Override
	protected double managment() {
		return -1;
	}

}
