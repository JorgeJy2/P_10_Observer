package ave.aves;

import javax.swing.ImageIcon;

import ave.Ave;

public class Gallina extends Ave {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean poneHuevos;

	public Gallina() {
		super(2.1F);
		poneHuevos = true;
	}
	
	public Gallina(float peso, boolean ponerHuevos) {
		super(peso);
		this.poneHuevos = ponerHuevos;
	}

	@Override
	public String moverse() {
		return "Caminar...";
	}

	@Override
	public String toString() {
		String actividad = (poneHuevos) ? "Pone huevos" :"No pone huevos";
		return actividad+ ", peso= "+peso+" kilogramos";
	}

	@Override
	public String queSoy() {
		return "Gallina";
	}

	@Override
	public ImageIcon getImagenIcon() {
		return new ImageIcon("imgs/chicken.png");
	}


}
