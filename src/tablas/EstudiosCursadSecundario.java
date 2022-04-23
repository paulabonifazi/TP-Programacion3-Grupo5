package tablas;

public class EstudiosCursadSecundario extends EstudiosCursados{

	@Override
	public double valor(IAspecto objeto) {
		EstudiosCursados ec = null;
		ec = (EstudiosCursados) objeto;
		return ec.secundario();
	}
///completo por fila
	@Override
	protected double primario() {
		return -0.5;
	}

	@Override
	protected double secundario() {
		return 1;
	}

	@Override
	protected double terciario() {
		return 1.5;
	}

}
