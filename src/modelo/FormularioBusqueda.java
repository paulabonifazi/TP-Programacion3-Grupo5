package modelo;

public class FormularioBusqueda {
	
	private	String locacion;
	private String remuneracion;
	private String cargaHoraria;
	private String tipoPuesto;
	private String rangoEtario;
	private String experienciaPrevia;
	private String estudiosCursados;
	
	
	public FormularioBusqueda(String locacion, String remuneracion, String cargaHoraria, String tipoPuesto,
			String rangoEtario, String experienciaPrevia, String estudiosCursados) {
		super();
		this.locacion = locacion;
		this.remuneracion = remuneracion;
		this.cargaHoraria = cargaHoraria;
		this.tipoPuesto = tipoPuesto;
		this.rangoEtario = rangoEtario;
		this.experienciaPrevia = experienciaPrevia;
		this.estudiosCursados = estudiosCursados;
	}


	public String getLocacion() {
		return locacion;
	}


	public String getRemuneracion() {
		return remuneracion;
	}


	public String getCargaHoraria() {
		return cargaHoraria;
	}


	public String getTipoPuesto() {
		return tipoPuesto;
	}


	public String getRangoEtario() {
		return rangoEtario;
	}


	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}


	public String getEstudiosCursados() {
		return estudiosCursados;
	}
	
	
	
}
