package tablas;

public class CargaHorariaExtendida extends CargaHoraria {

	@Override
	public double valor(IAspecto objeto) {
		CargaHoraria ch = null;
		ch = (CargaHoraria) objeto;
		return ch.extendida();
	}
	
	///completo por fila

	@Override
	protected double media() {

		return -1;
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
