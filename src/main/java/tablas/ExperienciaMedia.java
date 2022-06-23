package tablas;

import interfaces.IAspecto;

public class ExperienciaMedia extends Experiencia{

	@Override
	public double valor(IAspecto objeto) {
		Experiencia e = null;
		e = (Experiencia)objeto;
		return e.media();
	}
///completo por fila
	@Override
	protected double nada() {
		return -0.5;
	}

	@Override
	protected double media() {
		return 1;
	}

	@Override
	protected double mucha() {
		return 1.5;
	}

}
