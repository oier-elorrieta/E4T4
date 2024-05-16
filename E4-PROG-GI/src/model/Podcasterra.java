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
	}
	
	public Podcasterra(String izena, Blob irudia, int entzunaldiak) {
		super(izena, irudia, entzunaldiak);
	}
}
