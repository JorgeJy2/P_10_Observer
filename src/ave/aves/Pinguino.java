package ave.aves;

import javax.swing.ImageIcon;

import ave.Ave;

public class Pinguino extends Ave {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float tamanio;
	
	public Pinguino() {
		super(10);
		tamanio = 0.7F;
	}
	
	public Pinguino(float peso,float tamanio) {
		super(peso);
		this.tamanio = tamanio;
	}
	
	@Override 
	public String moverse() {
		return "Caminar...";
	}

	@Override
	public String toString() {
		return "Tamaño= " + tamanio + " centimetros , peso= "+peso+" kilogramos";
	}

	@Override
	public String queSoy() {
		return "Pinguino";
	}

	@Override
	public ImageIcon getImagenIcon() {
		return new ImageIcon("imgs/linux.png");
	}

}
