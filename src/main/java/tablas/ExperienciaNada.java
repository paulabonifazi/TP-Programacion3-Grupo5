package tablas;

import interfaces.IAspecto;

public class ExperienciaNada extends Experiencia{

	
///completo por fila
	@Override
	protected double nada() {
		return 1;
	}

	@Override
	protected double media() {
		return 1.5;
	}

	@Override
	protected double mucha() {
		return 2;
	}
	
	@Override
	public double valor(IAspecto objeto) {
		Experiencia e = null;
		e = (Experiencia)objeto;
		return e.nada();
	}
}

