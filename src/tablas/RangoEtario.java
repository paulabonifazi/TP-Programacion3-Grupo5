package tablas;

import Interfaces.IAspecto;

public abstract class RangoEtario implements IAspecto{
	protected abstract double menos40();
	protected abstract double entre40a50();
	protected abstract double mas50();
}
