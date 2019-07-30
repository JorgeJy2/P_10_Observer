package perro;

import javax.swing.ImageIcon;

import ave.Ave;

public class AdapterPerro  extends Ave {

	private static final long serialVersionUID = 1L;
	private Perro perro = new Perro();
	
	public AdapterPerro() {
		super(0);
		peso = perro.getPeso();	
	}


	@Override
	public ImageIcon getImagenIcon() {
		return perro.ver();
	}

	@Override
	public String queSoy() {
		return  perro.queSoy();
	}
	
	@Override
	public void alimentar() {
		perro.comer();
	}
	
	@Override
	public String moverse () {
		return  perro.moverse();
	}
	
	@Override
	public String toString () {
		return perro.toString();
	}

}
