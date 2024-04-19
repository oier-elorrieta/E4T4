package model;

import java.util.Objects;

public class Abestiak extends Audio {
	private boolean gustokoena;

	public Abestiak(String izena, int iraupena, boolean gustokoena) {
		super(izena, iraupena);
		this.gustokoena = gustokoena;
	}
	
}
