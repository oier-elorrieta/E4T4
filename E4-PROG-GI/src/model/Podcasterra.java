package model;

import java.sql.Blob;

/**
 * Podcaterra klasea Artistak klasea heredatzen duena.
 * 
 * Klase honek Podcaterra artistaren informazioa gordetzen du: izena, deskribapena eta irudia.
 */
public class Podcasterra extends Artista {

	
	public Podcasterra(int idArtista,String izena) {
		super(idArtista, izena);
	}
	
	public Podcasterra(int idArtista, String izena, String deskription, Blob irudia) {
		super(idArtista, izena, deskription, irudia);
		// TODO Auto-generated constructor stub
	}
	
	public Podcasterra(String izena, Blob irudia, int entzunaldiak) {
		super(izena, irudia, entzunaldiak);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Podcaterra klasearen eraikitzailea.
	 * 
	 * @param izena        Podcaterra artistaren izena
	 * @param deskription  Podcaterra artistaren deskribapena
	 * @param irudia       Podcaterra artistaren irudia
	 */
}
