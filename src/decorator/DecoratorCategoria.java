package decorator;

import interfaces.IPersona;

public abstract class DecoratorCategoria implements IPersona{
    protected IPersona encapsulado;
    
    public DecoratorCategoria(IPersona encapsulado) {
        super();
        this.encapsulado=encapsulado;
    }

   
}
