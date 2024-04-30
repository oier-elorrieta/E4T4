package model;

import java.sql.Blob;
import java.util.ArrayList;


public class Album {

	private int id;
	private String izenburua;
	private String generoa;
	private Blob irudia;
	private int kantaKop;

	
	public Album(int id,String izenburua, String generoa, Blob irudia) {
		
		this.izenburua = izenburua;
		this.generoa = generoa;
		this.irudia = irudia;
		this.id = id;
		
	}

	public String getIzenburua() {
		return izenburua;
	}

	public void setIzenburua(String izenburua) {
		this.izenburua = izenburua;
	}

	public String getGeneroa() {
		return generoa;
	}

	public void setGeneroa(String generoa) {
		this.generoa = generoa;
	}

	public Blob getIrudia() {
		return irudia;
	}

	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public int getKantaKop() {
		return kantaKop;
	}

	public void setKantaKop(int kantaKop) {
		this.kantaKop = kantaKop;
	}

	@Override
	public String toString() {
		return "Izenburua: " + izenburua + "  || Generoa: " + generoa + "  || Kantak: "+ kantaKop;
	}
	

	
	
	
	
	
	
}
