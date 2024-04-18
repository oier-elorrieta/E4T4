package model;

import java.util.Date;

public class Premium extends Bezeroak {
	private Date premiumMuga;

	public Premium(String erabiltzailea, String pasahitza, String izena, String abizena, Date jaiotzeData,
			String hizkuntza, Date premiumMuga) {
		super(erabiltzailea, pasahitza, izena, abizena, jaiotzeData, hizkuntza);
		this.premiumMuga = premiumMuga;
	}

	
}
