package main;

import java.util.ArrayList;
import java.util.List;

import ave.Ave;
import ave.aves.Aguila;
import ave.aves.Colibri;
import ave.aves.Gallina;
import ave.aves.Pinguino;
import gui.aviario.AviarioGui;
import model.TxtManagerDao;
import perro.AdapterPerro;

public class Aviario {

	public static void main(String[] args) {
		List<Ave> aves = new ArrayList<Ave>();
		aves.add(new Aguila());
		aves.add(new Colibri());
		aves.add(new Gallina());
		aves.add(new Pinguino());
	
		aves.add(new AdapterPerro());
		
		aves.add(new Gallina());
		aves.add(new Colibri());
		aves.add(new Aguila());		
		
		
		TxtManagerDao dao = TxtManagerDao.getInstance();
		dao.saveAll(aves);
		new AviarioGui();
	}
}
