package model;

import java.sql.Blob;

/**
 * Podcaterra klasea Artistak klasea heredatzen duena.
 * 
 * Klase honek Podcaterra artistaren informazioa gordetzen du: izena, deskribapena eta irudia.
 */
public class Podcsaterra extends Artista {

	/**
	 * Podcaterra klasearen eraikitzailea.
	 * 
	 * @param izena        Podcaterra artistaren izena
	 * @param deskription  Podcaterra artistaren deskribapena
	 * @param irudia       Podcaterra artistaren irudia
	 */
<<<<<<< HEAD
	public Podcsaterra(int idArtista, String izena, String deskription, String irudia) {
		super(idArtista,izena, deskription, irudia);
=======
	public Podcsaterra(String izena, String deskription, Blob irudia) {
		super(izena, deskription, irudia);
>>>>>>> feb4441f893e8d9d7cd4b0f3ecffc5ee42e8a047
	}
}
