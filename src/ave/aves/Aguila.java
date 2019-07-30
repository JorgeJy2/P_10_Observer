package ave.aves;

import javax.swing.ImageIcon;

import ave.Ave;

public class Aguila extends Ave{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float tamanio;
	
	public Aguila() {
		super(0.4F);
		tamanio = 70F;
	}

	public Aguila(float peso, float tamanio) {
		super(peso);
		this.tamanio = tamanio;
	}
	
	@Override
	public String toString() {
		return "Tamaño= " + tamanio + " kilogramos, peso= "+peso+" kilogramos";
	}

	@Override
	public String queSoy() {
		return "Aguila";
	}

	@Override
	public ImageIcon getImagenIcon() {
		return new ImageIcon("imgs/eagle.png");
	}

}
