package model;

import java.util.Objects;

/**
 * Audio klasea errepresentazioa egiten du audio fitxategien datuei buruz.
 */
public class Audio {
	protected String izena;
	protected int iraupena;
	
	/**
	 * Audio objektuaren eraikitzailea.
	 * 
	 * @param izena     audioaren izena
	 * @param iraupena  audioaren iraupena
	 */
	public Audio(String izena, int iraupena) {
		this.izena = izena;
		this.iraupena = iraupena;
	}

	/**
	 * Objektu hau eta beste objektu bat berdinak diren ala ez adierazten du.
	 * 
	 * @param obj  konparatzeko objektua
	 * @return     objektuak berdinak diren ala ez adierazten duen boolean balioa
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audio other = (Audio) obj;
		return iraupena == other.iraupena && Objects.equals(izena, other.izena);
	}

	/**
	 * Objektuaren testu-representazioa itzultzen du.
	 * 
	 * @return  objektuaren testu-representazioa
	 */
	@Override
	public String toString() {
		return "Audio [izena=" + izena + ", iraupena=" + iraupena + "]";
	}

	/**
	 * Audioaren izena itzultzen du.
	 * 
	 * @return  audioaren izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * Audioaren izena ezartzen du.
	 * 
	 * @param izena  audioaren izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * Audioaren iraupena itzultzen du.
	 * 
	 * @return  audioaren iraupena
	 */
	public int getIraupena() {
		return iraupena;
	}

	/**
	 * Audioaren iraupena ezartzen du.
	 * 
	 * @param iraupena  audioaren iraupena
	 */
	public void setIraupena(int iraupena) {
		this.iraupena = iraupena;
	}	
}