package model;

import java.util.Date;

public abstract class Bezeroak extends Erabiltzailea {
	protected String izena;
	protected String abizena;
	protected Date jaiotzeData;
	protected String hizkuntza;
	
	public Bezeroak(String erabiltzailea, String pasahitza, String izena, String abizena, Date jaiotzeData,
			String hizkuntza) {
		super(erabiltzailea, pasahitza);
		this.izena = izena;
		this.abizena = abizena;
		this.jaiotzeData = jaiotzeData;
		this.hizkuntza = hizkuntza;
	}
}
