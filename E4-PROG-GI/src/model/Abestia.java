package model;

<<<<<<< HEAD
import java.sql.Time;
import java.time.LocalTime;
=======
import java.sql.Blob;
>>>>>>> feb4441f893e8d9d7cd4b0f3ecffc5ee42e8a047
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
<<<<<<< HEAD
	public Abestia(int idAudio, String izena, Time iraupena) {
		super(idAudio, izena, iraupena);
		
=======
	public Abestia(int idAudio, String izena, String iraupena, Blob irudia, boolean gustokoena) {
		super(idAudio, izena, iraupena, irudia);
		this.setGustokoena(gustokoena);
>>>>>>> feb4441f893e8d9d7cd4b0f3ecffc5ee42e8a047
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
