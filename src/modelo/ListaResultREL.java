package modelo;

import java.util.ArrayList;

///objeto para generar lista Asignaciones
///al crear un usuario se debe verificar que el nombre no exista -> la busqueda puede ser por nombre usuario

public class ListaResultREL {
	private String nombreEmpresa;
	private ArrayList <String> listaEmpleados = new ArrayList<String>();
	
	
	
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public ArrayList<String> getListaEmpleados() {
		return listaEmpleados;
	} 
	
	
	
}
