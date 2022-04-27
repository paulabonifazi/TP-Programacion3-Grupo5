package tablas;

public class LocacionPresencial extends Locacion{

	@Override
	public double valor(IAspecto objeto) {
		Locacion l = null;
		l = (Locacion)objeto;
		return l.presencial();
	}
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
		return -1;
	}

}
