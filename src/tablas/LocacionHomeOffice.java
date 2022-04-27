package tablas;

public class LocacionHomeOffice extends Locacion{

	@Override
	public double valor(IAspecto objeto) {
		Locacion l = null;
		l = (Locacion)objeto;
		return l.homeOffice();
	}
///completo por fila
	@Override
	protected double homeOffice() {
		return 1;
	}

	@Override
	protected double presencial() {
		return -1;
	}

	@Override
	protected double indistinto() {
		return 1;
	}

}
