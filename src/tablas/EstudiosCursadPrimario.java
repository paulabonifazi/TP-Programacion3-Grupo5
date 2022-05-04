package tablas;

import Interfaces.IAspecto;

public class EstudiosCursadPrimario extends EstudiosCursados{

	@Override
	public double valor(IAspecto objeto) {
		EstudiosCursados ec = null;
		ec = (EstudiosCursados) objeto;
		return ec.primario();
	}
///completo por fila
	@Override
	protected double primario() {
		return 1;
	}

	@Override
	protected double secundario() {
		return 1.5;
	}

	@Override
	protected double terciario() {
		return 2;
	}

}
