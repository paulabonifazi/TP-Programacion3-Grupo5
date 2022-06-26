package decorator;

import paquete.Empleador;
import paquete.Persona;

public class EmpleadoComisioFactory {
    public static double getPorcentajeComision (Empleador empl) {
        IPersona encapsulado;
     
            if(empl.getRubro().equals("Salud"))
                  encapsulado = new DecoratorSalud(empl);
            else if(empl.getRubro().equals ("Comercio local"))
                    encapsulado = new DecoratorComLocal(empl);
            else 
                encapsulado = new DecoratorComIntern(empl);
     
     return encapsulado.porcentComicion();   
    }
}
