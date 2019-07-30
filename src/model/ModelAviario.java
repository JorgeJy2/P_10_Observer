package model;

import java.util.List;

import ave.Ave;

public class ModelAviario {

	private List<Ave> aves;

	
	private static ModelAviario instance;
	
	private ModelAviario() {
		
		DAOAviario aviarioDao = TxtManagerDao.getInstance();
		aves = aviarioDao.getAll();	
	}
	
	public static ModelAviario getInstance() {
		if(instance == null) 
			instance = new ModelAviario();
		return instance;
	}

	public List<Ave> getAves() {
		return aves;
	}
	
	public Ave getAve(int posicion) {
		return aves.get(posicion);
	}
	
	public int contadorAves () {
		return aves.size();
	}
	
	public void saveAves () {
		DAOAviario aviarioDao = TxtManagerDao.getInstance();
		aviarioDao.saveAll(aves);
	}

}

