package model;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;

/**
 * Album klasea errepresentatzen duen klasea.
 */
public class Album {

	private int id;
	private String izenburua;
	private String generoa;
	private Blob irudia;
	private String irudiaString;
	private int kantaKop;
	private Date urtea;

	/**
	 * Album klasearen eraikitzailea.
	 * 
	 * @param id         albumaren identifikadorea
	 * @param izenburua  albumaren izenburua
	 * @param generoa    albumaren generoa
	 * @param irudia     albumaren irudia
	 */
	public Album(int id, String izenburua, String generoa, Blob irudia,Date urtea) {

		this.izenburua = izenburua;
		this.generoa = generoa;
		this.irudia = irudia;
		this.id = id;
		this.urtea = urtea;

	}
	
	public Album(String izenburua, String generoa, String irudia,Date urtea) {

		this.izenburua = izenburua;
		this.generoa = generoa;
		this.irudiaString = irudia;
		this.urtea = urtea;
	
	}
	
	
	

	/**
	 * Album klasearen eraikitzailea.
	 * 
	 * @param id         albumaren identifikadorea
	 * @param izenburua  albumaren izenburua
	 */
	public Album(int id, String izenburua) {
		this.id = id;
		this.izenburua = izenburua;
	}

	/**
	 * Albumaren izenburua itzultzen du.
	 * 
	 * @return albumaren izenburua
	 */
	public String getIzenburua() {
		return izenburua;
	}

	/**
	 * Albumaren izenburua ezartzen du.
	 * 
	 * @param izenburua  albumaren izenburua
	 */
	public void setIzenburua(String izenburua) {
		this.izenburua = izenburua;
	}

	/**
	 * Albumaren generoa itzultzen du.
	 * 
	 * @return albumaren generoa
	 */
	public String getGeneroa() {
		return generoa;
	}

	/**
	 * Albumaren generoa ezartzen du.
	 * 
	 * @param generoa  albumaren generoa
	 */
	public void setGeneroa(String generoa) {
		this.generoa = generoa;
	}

	/**
	 * Albumaren irudia itzultzen du.
	 * 
	 * @return albumaren irudia
	 */
	public Blob getIrudia() {
		return irudia;
	}

	/**
	 * Albumaren irudia ezartzen du.
	 * 
	 * @param irudia  albumaren irudia
	 */
	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	/**
	 * Albumaren identifikadorea itzultzen du.
	 * 
	 * @return albumaren identifikadorea
	 */
	public int getId() {
		return id;
	}

	/**
	 * Albumaren identifikadorea ezartzen du.
	 * 
	 * @param id  albumaren identifikadorea
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Albumaren kanta kopurua itzultzen du.
	 * 
	 * @return albumaren kanta kopurua
	 */
	public int getKantaKop() {
		return kantaKop;
	}

	/**
	 * Albumaren kanta kopurua ezartzen du.
	 * 
	 * @param kantaKop  albumaren kanta kopurua
	 */
	public void setKantaKop(int kantaKop) {
		this.kantaKop = kantaKop;
	}

	/**
	 * Albumaren testu errepresentazioa itzultzen du.
	 * 
	 * @return albumaren testu errepresentazioa
	 */
	@Override
	public String toString() {
		return "Izenburua: " + izenburua + "  || Generoa: " + generoa + "  || Kantak: " + kantaKop;
	}

	public String getIrudiaString() {
		return irudiaString;
	}

	public void setIrudiaString(String irudiaString) {
		this.irudiaString = irudiaString;
	}

	public Date getUrtea() {
		return urtea;
	}

	public void setUrtea(Date urtea) {
		this.urtea = urtea;
	}
	
	
	
	

}
