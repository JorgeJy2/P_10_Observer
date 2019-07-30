package perro;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Perro implements  Serializable{

	private static final long serialVersionUID = 1L;
	
	private float peso = 14.60F;
	private float tamanio =1.20F;
	
	

	public String moverse() {
		return "Estoy caminando en 4 patas.";
	}
	
	public String queSoy() {
		return "Perro";
	}
	
	/**
	 * Todas los perros al comer aumentan un 20% del peso actual
	 */
	public void comer() {
		peso *= 1.20 ;
	}

	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getTamanio() {
		return tamanio;
	}
	public void setTamanio(float tamanio) {
		this.tamanio = tamanio;
	}

	public ImageIcon ver() {
		return new ImageIcon("imgs/perro.png");
	}

	@Override
	public String toString() {
		return "Tamaño= " + tamanio + " kilogramos, peso= "+peso+" kilogramos";
	}
}
