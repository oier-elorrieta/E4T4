package model;


import java.sql.Time;

import java.sql.Blob;

/**
 * Abestiak klasea Audio klasetik heredatzen duena.
 * Abestiak klasea abestiak kudeatzeko erabiltzen da.
 * 
 * Gustokoena atributua abestia gustatzen zaion edo ez adierazten du.
 */
public class Abestia extends Audio {
	private boolean gustokoena;
	
	/**
	 * Abestiak klasearen eraikitzailea.
	 * 
	 * @param izena       abestiaren izena
	 * @param iraupena    abestiaren iraupena
	 * @param gustokoena  abestia gustatzen zaion edo ez adierazten du
	 */

	public Abestia() {
		
	}
	
	public Abestia(int idAudio, String izena, Time iraupena, Blob irudia, boolean gustokoena) {
		super(idAudio, izena, iraupena, irudia);
		this.setGustokoena(gustokoena);
	}
	
	public Abestia(int idAudio, String izena, Time iraupena) {
		super(idAudio, izena, iraupena);
		this.setGustokoena(gustokoena);
	}
	
	/**
	 * Abestia gustatzen zaion edo ez ezarri.
	 * 
	 * @param gustokoena  abestia gustatzen zaion edo ez adierazten du
	 */
	public void setGustokoena(boolean gustokoena) {
		this.gustokoena = gustokoena;
	}
	
	public boolean getGustokoena() {
		return gustokoena;
	}

	@Override
	public String toString() {
		return "Izena:" + izena + " || Iraupena: " + iraupena;
	}
	
	
}
