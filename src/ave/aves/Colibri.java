package ave.aves;

import javax.swing.ImageIcon;

import ave.Ave;

public class Colibri extends Ave {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public static enum colores {ROJO,VERDE,AZUL};
	
	private colores color;
	
	public Colibri() {
		super(0.2F);
		color = colores.ROJO;
	}
	
	public Colibri(float peso, colores color) {
		super(peso);
		this.color = color;
	}

	@Override
	public String toString() {
		return "color= " + color + ", peso= "+peso+" kilogramos";
	}

	@Override
	public String queSoy() {
		return "Colibri";
	}

	@Override
	public ImageIcon getImagenIcon() {
		return new ImageIcon("imgs/hummingbird.png");
	}	
}
