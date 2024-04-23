package model;

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
	public Abestia(String izena, int iraupena, boolean gustokoena) {
		super(izena, iraupena);
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
