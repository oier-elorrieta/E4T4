package model;

import java.sql.Blob;
import java.util.Objects;



/**
 * Artistak klasea abstraktoa da, eta artisten informazioa gordetzeko erabiltzen da.
 */
public abstract class Artista {
	protected int idArtista;
	protected String izena;
	protected String deskription;
	protected Blob irudia;
	protected int entzunaldiak;
	protected String irudiaString;
	
	
	/**
	 * Artistak klasearen eraikitzailea.
	 * @param izena artistaren izena
	 * @param deskription artistaren deskribapena
	 * @param irudia artistaren irudia
*/
	public Artista() {
		
	}
	
	public Artista(int idArtista,String izena, String deskription, Blob irudia) {
		this.idArtista=idArtista;
		this.izena = izena;
		this.deskription = deskription;
		this.irudia = irudia;
		this.idArtista = idArtista;
	}
	
	public Artista(int idArtista,String izena) {
		this.idArtista = idArtista;
		this.izena = izena;
	}
	
	public Artista(String izena, String deskription, Blob irudia) {

		this.izena = izena;
		this.deskription = deskription;
		this.irudia = irudia;
	}
	
	public Artista(String izena, String deskription, String irudiaString) {
		this.izena = izena;
		this.deskription = deskription;
		this.irudiaString = irudiaString;
	}

	public Artista(String izena, Blob irudia, int entzunaldiak) {
		this.izena = izena;
		this.irudia = irudia;
		this.entzunaldiak = entzunaldiak;
	}
	/**
	 * Objektu hau eta beste objektu bat berdinak diren ala ez adierazten duen metodoa.
	 * @param obj beste objektu bat
	 * @return objektuak berdinak diren ala ez adierazten duen boolean balioa
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		return Objects.equals(deskription, other.deskription) && entzunaldiak == other.entzunaldiak
				&& idArtista == other.idArtista
				&& Objects.equals(irudiaString, other.irudiaString) && Objects.equals(izena, other.izena);
	}

	/**
	 * Objektuaren informazioa testu moduan itzultzen duen metodoa.
	 * @return objektuaren informazioa testu moduan
	 */
	@Override
	public String toString() {
		return "Artistak [izena=" + izena + ", deskription=" + deskription + ", irudia=" + irudia + "]";
	}

	
	/**
	 * Artistaren izena itzultzen duen metodoa.
	 * @return artistaren izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * Artistaren izena ezartzen duen metodoa.
	 * @param izena artistaren izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * Artistaren deskribapena itzultzen duen metodoa.
	 * @return artistaren deskribapena
	 */
	public String getDeskription() {
		return deskription;
	}

	/**
	 * Artistaren deskribapena ezartzen duen metodoa.
	 * @param deskription artistaren deskribapena
	 */
	public void setDeskription(String deskription) {
		this.deskription = deskription;
	}

	/**
	 * Artistaren irudia itzultzen duen metodoa.
	 * @return artistaren irudia
	 */
	public Blob getIrudia() {
		return irudia;
	}

	/**
	 * Artistaren irudia ezartzen duen metodoa.
	 * @param irudia artistaren irudia
	 */
	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	public String getIrudiaString() {
		return irudiaString;
	}
	public void setIrudiaString(String irudiaString) {
		this.irudiaString = irudiaString;
	}
	
	public int getEntzunaldiak() {
		return entzunaldiak;
	}
	public void setEntzunaldiak(int entzunaldiak) {
		this.entzunaldiak = entzunaldiak;
	}
	
	
}
