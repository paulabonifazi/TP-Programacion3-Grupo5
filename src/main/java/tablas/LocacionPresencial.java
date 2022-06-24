package tablas;

import interfaces.IAspecto;

public class LocacionPresencial extends Locacion{


///completo por fila
	@Override
	protected double homeOffice() {
		return -1;
	}

	@Override
	protected double presencial() {
		return 1;
	}

	@Override
	protected double indistinto() {
		return 1;
	}

	@Override
	public double valor(IAspecto o) {
		Locacion objeto = null;
		objeto = (Locacion) o;
		return objeto.presencial();
	}

}
