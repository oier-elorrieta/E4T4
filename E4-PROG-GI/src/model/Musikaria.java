package model;

/**
 * Klase hau Musikaria klasea da, Artistak klasea heredatzen duena.
 * Musikariak izena, deskribapena eta irudia ditu.
 */
public class Musikaria extends Artista {

	/**
	 * Musikariaren eraikitzailea.
	 * @param izena Musikariaren izena
	 * @param deskription Musikariaren deskribapena
	 * @param irudia Musikariaren irudia
	 */
	public Musikaria(String izena, String deskription, String irudia) {
		super(izena, deskription, irudia);
	}

}
