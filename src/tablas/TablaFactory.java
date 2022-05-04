package tablas;

public class TablaFactory {
	public static IAspecto getValorAspecto(String nombreAspecto) {
		IAspecto aspecto = null;
	///CargaHoraria
		if (nombreAspecto.equals("CHCOMPLETA"))
			aspecto = new CargaHorariaCompleta();
		else if (nombreAspecto.equals("CHEXTENDIDA"))
			aspecto = new CargaHorariaExtendida();
		else if (nombreAspecto.equals("CHMEDIA"))
			aspecto = new CargaHorariaMedia();
		
	///EstudiosCursados	
		else if (nombreAspecto.equals("PRIMARIO"))
			aspecto = new EstudiosCursadPrimario();
		else if (nombreAspecto.equals("SECUNDARIO"))
			aspecto = new EstudiosCursadSecundario();
		else if (nombreAspecto.equals("TERCIARIO"))
			aspecto = new EstudiosCursadTerciario();
		
	///Experiencia	
		else if (nombreAspecto.equals("EXPMEDIA"))
			aspecto = new ExperienciaMedia();
		else if (nombreAspecto.equals("EXPMUCHA"))
			aspecto = new ExperienciaMucha();
		else if (nombreAspecto.equals("EXPNADA"))
			aspecto = new ExperienciaNada();
		
	///Locacion	
		else if (nombreAspecto.equals("HOMEOFFICE"))
			aspecto = new LocacionHomeOffice();
		else if (nombreAspecto.equals("PRESENCIAL"))
			aspecto = new LocacionPresencial();
		else if (nombreAspecto.equals("INDISTINTO"))
			aspecto = new LocacionIndistinto();
		
	///RangoEtario	
		else if (nombreAspecto.equals("MENOS40"))
			aspecto = new RangoEtarioMenos40();
		else if (nombreAspecto.equals("ENTRE40A50"))
			aspecto = new RangoEtarioEntre40a50();
		else if (nombreAspecto.equals("MAS50"))
			aspecto = new RangoEtarioMas50();
	
	///Remuneracion	
		else if (nombreAspecto.equals("HASTAV1"))
			aspecto = new RemuneracionHastaV1();
		else if (nombreAspecto.equals("ENTREV1YV2"))
			aspecto = new RemuneracionEntreV1yV2();
		else if (nombreAspecto.equals("MASV2"))
			aspecto = new RemuneracionMasV2();
		
	///TipoPuesto
		else if (nombreAspecto.equals("JUNIOR"))
			aspecto = new TipoPuestoJunior();
		else if (nombreAspecto.equals("SENIOR"))
			aspecto = new TipoPuestoSenior();
		else if (nombreAspecto.equals("MANAGMENT"))
			aspecto = new TipoPuestoManagment();
		
		
		return aspecto;
		
	}

	
	
	/*		forma de usarlo
	 	IAspecto aspEmplead =  FactoryAspecto.getValorAspecto(acceso a FB empleadoPretenso);
	 	IAspecto aspEmpresa =  FactoryAspecto.getValorAspecto("acceso a FB empleador");
	 	
		System.out.print(aspEmpresa.valor(aspEmplead));
	*/
	 
}
