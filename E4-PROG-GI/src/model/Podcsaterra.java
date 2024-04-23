package model;

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
	public Podcsaterra(String izena, String deskription, String irudia) {
		super(izena, deskription, irudia);
	}
}
