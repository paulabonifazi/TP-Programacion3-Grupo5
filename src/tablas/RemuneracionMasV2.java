package tablas;

import Interfaces.IAspecto;

public class RemuneracionMasV2 extends Remuneracion{

	@Override
	public double valor(IAspecto objeto) {
		Remuneracion r = null;
		r = (Remuneracion)objeto;
		return r.masV2();
	}
///completo por fila
	@Override
	protected double hastaV1() {
		return 1;
	}

	@Override
	protected double entreV1yV2() {
		return 1;
	}

	@Override
	protected double masV2() {
		return 1;
	}

}

