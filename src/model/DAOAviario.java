package model;

import java.util.List;

import ave.Ave;

public interface DAOAviario {

	List<Ave> getAll();
	
	boolean saveAll(List<Ave> aves);
}
