package tablas;

import interfaces.IAspecto;

public class TablaFactory {
	public static IAspecto getValorAspecto(String nombreAspecto) {
		IAspecto aspecto = null;
		
	///EstudiosCursados	
		 if (nombreAspecto.equals("Primario"))
			aspecto = new EstudiosCursadPrimario();
		else if (nombreAspecto.equals("Secundario"))
			aspecto = new EstudiosCursadSecundario();
		else if (nombreAspecto.equals("Terciario"))
			aspecto = new EstudiosCursadTerciario();
		
	///CargaHoraria
	/*	else if (nombreAspecto.equals("Completa"))
			aspecto = new CargaHorariaCompleta();
		else if (nombreAspecto.equals("Extendida"))
			aspecto = new CargaHorariaExtendida();
		else if (nombreAspecto.equals("Media"))
			aspecto = new CargaHorariaMedia();
		*/
	
	///Experiencia	
		else if (nombreAspecto.equals("Media"))
			aspecto = new ExperienciaMedia();
		else if (nombreAspecto.equals("Mucha"))
			aspecto = new ExperienciaMucha();
		else if (nombreAspecto.equals("Nada"))
			aspecto = new ExperienciaNada();
		
	///Locacion	
		else if (nombreAspecto.equals("HomeOffice"))
			aspecto = new LocacionHomeOffice();
		else if (nombreAspecto.equals("Presencial"))
			aspecto = new LocacionPresencial();
		else if (nombreAspecto.equals("Indistinto"))
			aspecto = new LocacionIndistinto();
		
	///RangoEtario	
		else if (nombreAspecto.equals("Menos de 40"))
			aspecto = new RangoEtarioMenos40();
		else if (nombreAspecto.equals("40 a 50"))
			aspecto = new RangoEtarioEntre40a50();
		else if (nombreAspecto.equals("Mas de 50"))
			aspecto = new RangoEtarioMas50();
	
	///Remuneracion	
		else if (nombreAspecto.equals("HASTAV1"))
			aspecto = new RemuneracionV1();
		else if (nombreAspecto.equals("ENTREV1YV2"))
			aspecto = new RemuneracionV2();
		else if (nombreAspecto.equals("MASV2"))
			aspecto = new RemuneracionV3();
		
	///TipoPuesto
		else if (nombreAspecto.equals("Junior"))
			aspecto = new TipoPuestoJunior();
		else if (nombreAspecto.equals("Senior"))
			aspecto = new TipoPuestoSenior();
		else if (nombreAspecto.equals("Managment"))
			aspecto = new TipoPuestoManagment();
		
		
		return aspecto;
		
	}

}
