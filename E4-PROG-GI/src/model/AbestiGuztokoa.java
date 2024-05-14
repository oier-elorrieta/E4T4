package model;

public class AbestiGuztokoa {
	private Erabiltzailea erabiltzailea;
	private Audio audio;
	
	
	public AbestiGuztokoa(Erabiltzailea erabiltzailea, Audio audio) {
		this.erabiltzailea = erabiltzailea;
		this.audio = audio;
	}
	
	public Erabiltzailea getErabiltzailea() {
		return erabiltzailea;
	}
	public void setErabiltzailea(Erabiltzailea erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}
	public Audio getAudio() {
		return audio;
	}
	public void setAudio(Audio audio) {
		this.audio = audio;
	}
	
	
}
