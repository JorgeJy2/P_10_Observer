package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import ave.Ave;

public class TxtManagerDao  implements DAOAviario{

	private static final String NAME_FILE = "aves.txt";
	private static TxtManagerDao  instance;
	
	private TxtManagerDao() {
	}
	
	public static TxtManagerDao getInstance() {
		if ( instance == null) 
			instance = new TxtManagerDao();
		
		return instance;
	}
	
	@Override
	public List<Ave> getAll() {
		FileInputStream f = null;
		ObjectInputStream inputStream  = null;
		List<Ave> aves = new ArrayList<Ave>();
		try {
			f = new FileInputStream(new File(NAME_FILE));
			inputStream = new ObjectInputStream(f);
			Object aveObj =  inputStream.readObject();
			while ( aveObj != null) {
				Ave  ave = (Ave) aveObj;
				aves.add(ave);
				aveObj = inputStream.readObject();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error en file");
			return null;
		} catch (IOException e) {
			//System.out.println("Entrada de objeto null");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Class not fount");
			return null;
		}finally {
			try {
				inputStream.close();
				f.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("No se puede cerrar");
			}
		}
		return aves;

	}

	@Override
	public boolean saveAll(List<Ave> aves) {
		
		FileOutputStream f = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			f = new FileOutputStream(new File(NAME_FILE));
			objectOutputStream= new ObjectOutputStream(f);
			for (Ave ave : aves)
				objectOutputStream.writeObject(ave);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error en file");
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error en io");
			return false;
		}finally {
			try {
				objectOutputStream.close();
				f.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("No se puede cerrar");
				return false;
			}
		}
		return true;
	}

}
