package gui;

import java.util.HashMap;

public class AnimalChangeObservable {
	
	private HashMap<String, Cambiable> observadores;
	
	public AnimalChangeObservable() {
		observadores = new HashMap<String, Cambiable>();
	}
	
	public void addObserver(String key,Cambiable cambiable) {
		if (!observadores.containsKey(key)) { observadores.put(key, cambiable); }
	}
	
	public void deleteObserver(String key) {
		observadores.remove(key);
	}
	
	public void notificarCambioAnimal(int position) {
		for (Cambiable iterable : observadores.values()) {
			iterable.changeAnimal(position);
		}
	} 
	
	public void notificarCambioInfo(String info) {
		for (Cambiable iterable : observadores.values()) {
			iterable.changeInfo(info);
		}
	}
}
