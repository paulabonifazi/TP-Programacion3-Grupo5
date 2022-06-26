package decorator;

import paquete.EmpleadoPretenso;


public class EmplPretensoComisioFactory {
    public static double getPorcentajeComision (EmpleadoPretenso empl) {
        IPersona encapsulado;
     
            if(empl.getTicket().getFbTicket().getTipoPuesto().equals("Junior"))
                  encapsulado = new DecoratorSalud(empl);
            else if(empl.getTicket().getFbTicket().getTipoPuesto().equals ("Senior"))
                    encapsulado = new DecoratorComLocal(empl);
            else 
                encapsulado = new DecoratorComIntern(empl);
     
     return encapsulado.porcentComicion();   
    }
}
