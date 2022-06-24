package tablas;

import interfaces.IAspecto;

public class RemuneracionV1 extends Remuneracion{

	@Override
	public double valor(IAspecto objeto) {
		Remuneracion r = null;
		r = (Remuneracion)objeto;
		return r.V1();
	}
///completo por fila
	@Override
	protected double V1() {
		return 1;
	}

	@Override
	protected double V2() {
		return -0.5;
	}

	@Override
	protected double V3() {
		return -1;
	}

}
