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

	public Musikaria(int idArtista ,String izena, String deskription, Blob irudia,String ezaugarria) {
		super(idArtista,izena, deskription, irudia);
		this.ezaugarria = ezaugarria;
	}
	
	public Musikaria(String izena, String deskription, Blob irudia) {
		super(izena, deskription, irudia);
	}
	
	public Musikaria(String izena, Blob irudia, int entzunaldiak) {
		super(izena, irudia, entzunaldiak);
	}
	
	@Override
	public String toString() {
		return "Musikaria [ezaugarria=" + ezaugarria + ", idArtista=" + idArtista + ", izena=" + izena
				+ ", deskription=" + deskription + ", irudia=" + irudia + "]";
	}

}
