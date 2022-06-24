package tablas;

import interfaces.IAspecto;

public class RangoEtarioMas50 extends RangoEtario{

	@Override
	public double valor(IAspecto objeto) {
		RangoEtario rg = null;
		rg =(RangoEtario)objeto;
		return rg.mas50();
	}

///completo por fila	
	@Override
	protected double menos40() {
		return -1;
	}

	@Override
	protected double entre40a50() {
		return -0.5;
	}

	@Override
	protected double mas50() {
		return 1;
	}

}