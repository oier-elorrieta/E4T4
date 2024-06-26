package model;


import java.sql.Blob;

/**
 * Klase hau Musikaria klasea da, Artistak klasea heredatzen duena.
 * Musikariak izena, deskribapena eta irudia ditu.
 */
public class Musikaria extends Artista {
	//hau gero hobeto enum batera aldatzea
	private String ezaugarria;
	
	
	/**
	 * Musikariaren eraikitzailea.
	 * @param izena Musikariaren izena
	 * @param deskription Musikariaren deskribapena
	 * @param blob Musikariaren irudia
	 */
	public Musikaria() {
		super();
	}
	
	public Musikaria(int idArtista,String izena) {
		super(idArtista,izena);
	}
	
	public Musikaria(String izena, String deskription, Blob irudia) {
		super(izena, deskription, irudia);
	}
	
	public Musikaria(String izena, Blob irudia, int entzunaldiak) {
		super(izena, irudia, entzunaldiak);
	}
	
	public Musikaria(String izena, String deskription, String irudiaString,String ezaugarria) {
		super(izena, deskription, irudiaString);
		
		this.ezaugarria = ezaugarria;
	}

	public Musikaria(int idArtista ,String izena, String deskription, Blob irudia,String ezaugarria) {
		super(idArtista,izena, deskription, irudia);
		this.ezaugarria = ezaugarria;
	}

	public String getEzaugarria() {
		return ezaugarria;
	}

	public void setEzaugarria(String ezaugarria) {
		this.ezaugarria = ezaugarria;
	}
	
	@Override
	public String toString() {
		return izena;
	}

	
	
	

}
