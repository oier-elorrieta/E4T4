package model;

import java.util.Objects;

/**
 * Artistak klasea abstraktoa da, eta artisten informazioa gordetzeko erabiltzen da.
 */
public abstract class Artista {
	protected String izena;
	protected String deskription;
	protected String irudia;
	
	/**
	 * Artistak klasearen eraikitzailea.
	 * @param izena artistaren izena
	 * @param deskription artistaren deskribapena
	 * @param irudia artistaren irudia
	 */
	public Artista(String izena, String deskription, String irudia) {
		this.izena = izena;
		this.deskription = deskription;
		this.irudia = irudia;
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
		return Objects.equals(deskription, other.deskription) && Objects.equals(irudia, other.irudia)
				&& Objects.equals(izena, other.izena);
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
	public String getIrudia() {
		return irudia;
	}

	/**
	 * Artistaren irudia ezartzen duen metodoa.
	 * @param irudia artistaren irudia
	 */
	public void setIrudia(String irudia) {
		this.irudia = irudia;
	}
}
