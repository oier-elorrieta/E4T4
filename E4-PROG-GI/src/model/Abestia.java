package model;

import java.sql.Blob;
import java.util.Objects;

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
	public Abestia(int idAudio, String izena, String iraupena, Blob irudia, boolean gustokoena) {
		super(idAudio, izena, iraupena, irudia);
		this.setGustokoena(gustokoena);
	}

	/**
	 * Abestia gustatzen zaion edo ez itzultzen du.
	 * 
	 * @return abestia gustatzen zaion edo ez
	 */
	public boolean isGustokoena() {
		return gustokoena;
	}

	/**
	 * Abestia gustatzen zaion edo ez ezarri.
	 * 
	 * @param gustokoena  abestia gustatzen zaion edo ez adierazten du
	 */
	public void setGustokoena(boolean gustokoena) {
		this.gustokoena = gustokoena;
	}	
}
