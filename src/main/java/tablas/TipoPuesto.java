package tablas;

import interfaces.IAspecto;

public abstract class TipoPuesto implements IAspecto{

	protected abstract double junior();
	protected abstract double senior();
	protected abstract double managment();
}
