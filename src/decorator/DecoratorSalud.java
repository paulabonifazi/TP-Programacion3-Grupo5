package decorator;

public class DecoratorSalud extends DecoratorCategoria{
    public DecoratorSalud(IPersona encapsulado) {
        super(encapsulado);
    }


    @Override
    public String getNomRazonS() {
        return encapsulado.getNomRazonS();
    }

    @Override
    public String getNombre() {
        return encapsulado.getNombre();
    }

    @Override
    public String getApellido() {
        return encapsulado.getApellido();
    }

    @Override
    public int getEdad() {
        return encapsulado.getEdad();
    }
    
    @Override
    public double porcentComicion() {
        return encapsulado.porcentComicion()+0.6;
    }
}
