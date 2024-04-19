package model;

import java.util.Date;

public class ErabiltzailePremium extends Erabiltzailea {
	private Date premiumMuga;

	public ErabiltzailePremium(String erabiltzailea, String pasahitza, String izena, String abizena, Date jaiotzeData,
			String hizkuntza, Date premiumMuga) {
		super(erabiltzailea, pasahitza, izena, abizena, jaiotzeData, hizkuntza);
		this.premiumMuga = premiumMuga;
	}
	
	
}
