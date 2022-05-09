package paquete;

public class ValoracionAspecto {	
	
	private int pesoLocacion;
	private int pesoTipoPuesto;
	private int pesoRangoEtario;
	private int pesoExperienciaPrevia;
	private int pesoEstudiosCursados;
	private int pesoRemuneracion;
	private int pesoCargaHoraria;
	
	public ValoracionAspecto(int pesoLocacion, int pesoTipoPuesto, int pesoRangoEtario, int pesoExperienciaPrevia,
			int pesoEstudiosCursados, int pesoRemuneracion, int pesoCargaHoraria) 
	{
		
		super();
		this.pesoLocacion = pesoLocacion;
		this.pesoTipoPuesto = pesoTipoPuesto;
		this.pesoRangoEtario = pesoRangoEtario;
		this.pesoExperienciaPrevia = pesoExperienciaPrevia;
		this.pesoEstudiosCursados = pesoEstudiosCursados;
		this.pesoRemuneracion = pesoRemuneracion;
		this.pesoCargaHoraria = pesoCargaHoraria;
	}

	public int getPesoLocacion() {
		return pesoLocacion;
	}

	public int getPesoTipoPuesto() {
		return pesoTipoPuesto;
	}

	public int getPesoRangoEtario() {
		return pesoRangoEtario;
	}

	public int getPesoExperienciaPrevia() {
		return pesoExperienciaPrevia;
	}

	public int getPesoEstudiosCursados() {
		return pesoEstudiosCursados;
	}

	public int getPesoRemuneracion() {
		return pesoRemuneracion;
	}

	public int getPesoCargaHoraria() {
		return pesoCargaHoraria;
	}
	
	
	
}
