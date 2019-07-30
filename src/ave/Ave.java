package ave;

import java.io.Serializable;

public abstract class Ave implements Visualizable, Alimentable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected float peso;
	
	public Ave(float peso) {
		this.peso = peso;
	}
	
	public String moverse() {
		return "Estoy volando...";
	}
	
	public abstract String queSoy();
	
	
	/**
	 * Todas la aves al comer aumentan un 10% del peso actual
	 */
	@Override
	public void alimentar() {
		peso *= 1.10 ;
	}
}
