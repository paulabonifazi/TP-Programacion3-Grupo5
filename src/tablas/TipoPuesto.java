package tablas;

import Interfaces.IAspecto;

public abstract class TipoPuesto implements IAspecto{

	protected abstract double junior();
	protected abstract double senior();
	protected abstract double managment();
}
