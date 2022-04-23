package tablas;

public class EstudiosCursadTerciario extends EstudiosCursados{

	@Override
	public double valor(IAspecto objeto) {
		EstudiosCursados ec = null;
		ec = (EstudiosCursados) objeto;
		return ec.terciario();
	}
///completo por fila
	@Override
	protected double primario() {
		return -2;
	}

	@Override
	protected double secundario() {
		return -1.5;
	}

	@Override
	protected double terciario() {
		return 1;
	}

}
