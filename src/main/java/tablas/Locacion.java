package tablas;


import interfaces.IAspecto;

public abstract class Locacion implements IAspecto{

	protected abstract double homeOffice();
	protected abstract double presencial();
	protected abstract double indistinto();

}
