package tablas;



public class CargaHorariaMedia extends CargaHoraria {

	@Override
	public double valor(IAspecto objeto) {
		CargaHoraria ch = null;
		ch = (CargaHoraria) objeto;
		return ch.media();
	}
	
	///completo por fila

	@Override
	protected double media() {

		return 1;
	}

	@Override
	protected double completa() {

		return -0.5;
	}

	@Override
	protected double extendida() {
	
		return -1;
	}
	

}
