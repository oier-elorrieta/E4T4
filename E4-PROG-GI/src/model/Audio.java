package model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Audio klasea errepresentazioa egiten du audio fitxategien datuei buruz.
 */
public class Audio {
	protected int idAudio;
	protected String izena;
	protected Time iraupena;
	
	/**
	 * Audio objektuaren eraikitzailea.
	 * 
	 * @param izena     audioaren izena
	 * @param iraupena  audioaren iraupena
	 */
	public Audio(int idAudio, String izena, Time iraupena) {
		this.idAudio = idAudio;
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
		return izena + " - " + iraupena;
	}

	/**
	 * Audioaren izena itzultzen du.
	 * 
	 * @return  audioaren izena
	 */
	
	
	
	public String getIzena() {
		return izena;
	}

	public Time getIraupena() {
		return iraupena;
	}

	public int getIdAudio() {
		return idAudio;
	}

	public void setIdAudio(int idAudio) {
		this.idAudio = idAudio;
	}

	public void setIraupena(Time iraupena) {
		this.iraupena = iraupena;
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
}