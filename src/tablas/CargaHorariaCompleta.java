package tablas;

import interfaces.IAspecto;

public class CargaHorariaCompleta extends CargaHoraria {

	@Override
	public double valor(IAspecto objeto) {
		CargaHoraria ch = null;
		ch = (CargaHoraria) objeto;
		return ch.completa();
	}
	
	///completo por fila

	@Override
	protected double media() {

		return -0.5;
	}

	@Override
	protected double completa() {

		return 1;
	}

	@Override
	protected double extendida() {
	
		return -0.5;
	}
	

}
