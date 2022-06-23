package tablas;

import interfaces.IAspecto;

public class ExperienciaMucha extends Experiencia{

	@Override
	public double valor(IAspecto objeto) {
		Experiencia e = null;
		e = (Experiencia)objeto;
		return e.mucha();
	}
///completo por fila
	@Override
	protected double nada() {
		return -2;
	}

	@Override
	protected double media() {
		return -1.5;
	}

	@Override
	protected double mucha() {
		return 1;
	}

}
