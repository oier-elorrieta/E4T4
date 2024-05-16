package model;

import java.util.Objects;

/**
 * AbestiGuztokoa klasea erabiltzailearen eta audioaren informazioa gordetzeko erabiltzen da.
 */
public class AbestiGuztokoa {
	private Erabiltzailea erabiltzailea;
	private Audio audio;
	

	public AbestiGuztokoa() {
		
	}
	/**
	 * AbestiGuztokoa klasearen eraikitzailea.
	 * @param erabiltzailea AbestiGuztokoaren erabiltzailea
	 * @param audio AbestiGuztokoaren audioa
	 */

	public AbestiGuztokoa(Erabiltzailea erabiltzailea, Audio audio) {
		this.erabiltzailea = erabiltzailea;
		this.audio = audio;
	}
	
	/**
	 * Erabiltzailea lortzeko metodoa.
	 * @return AbestiGuztokoaren erabiltzailea
	 */
	public Erabiltzailea getErabiltzailea() {
		return erabiltzailea;
	}
	
	/**
	 * Erabiltzailea ezartzeko metodoa.
	 * @param erabiltzailea AbestiGuztokoaren erabiltzailea
	 */
	public void setErabiltzailea(Erabiltzailea erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}
	
	/**
	 * Audioa lortzeko metodoa.
	 * @return AbestiGuztokoaren audioa
	 */
	public Audio getAudio() {
		return audio;
	}
	
	/**
	 * Audioa ezartzeko metodoa.
	 * @param audio AbestiGuztokoaren audioa
	 */
	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbestiGuztokoa other = (AbestiGuztokoa) obj;
		return Objects.equals(audio, other.audio) && Objects.equals(erabiltzailea, other.erabiltzailea);
	}

	@Override
	public String toString() {
		return "AbestiGuztokoa [erabiltzailea=" + erabiltzailea + ", audio=" + audio + "]";
	}
	
	
	
}
