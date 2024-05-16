package model;
import java.util.Objects;

public class Estadistika {
	private String s1;
	private String s2;
	private int entzunda;
	
	
	/**
	 * Estadistika klasearen konstruktorea.
	 */
	public Estadistika() {
	}
	
	/**
	 * Estadistika klasearen konstruktorea.
	 * 
	 * @param s1 Lehenengo string-a.
	 * @param s2 Bigarren string-a.
	 * @param entzunda Entzundako zenbakia.
	 */
	public Estadistika(String s1, String s2, int entzunda) {
		this.s1 = s1;
		this.s2 = s2;
		this.entzunda = entzunda;
	}
	
	/**
	 * Objektuak berdinak diren ala ez adierazten du.
	 * 
	 * @param obj Konparatzeko objektua.
	 * @return Objektuak berdinak diren ala ez.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estadistika other = (Estadistika) obj;
		return entzunda == other.entzunda && Objects.equals(s1, other.s1) && Objects.equals(s2, other.s2);
	}
	
	/**
	 * Objektuaren testu errepresentazioa itzultzen du.
	 * 
	 * @return Objektuaren testu errepresentazioa.
	 */
	@Override
	public String toString() {
		return "Estadistika [s1=" + s1 + ", s2=" + s2 + ", entzunda=" + entzunda + "]";
	}
	
	/**
	 * s1 aldagaia itzultzen du.
	 * 
	 * @return s1 aldagaia.
	 */
	public String getS1() {
		return s1;
	}
	
	/**
	 * s1 aldagaia ezartzen du.
	 * 
	 * @param s1 Lehenengo string-a.
	 */
	public void setS1(String s1) {
		this.s1 = s1;
	}
	
	/**
	 * s2 aldagaia itzultzen du.
	 * 
	 * @return s2 aldagaia.
	 */
	public String getS2() {
		return s2;
	}
	
	/**
	 * s2 aldagaia ezartzen du.
	 * 
	 * @param s2 Bigarren string-a.
	 */
	public void setS2(String s2) {
		this.s2 = s2;
	}
	
	/**
	 * entzunda aldagaia itzultzen du.
	 * 
	 * @return entzunda aldagaia.
	 */
	public int getEntzunda() {
		return entzunda;
	}
	
	/**
	 * entzunda aldagaia ezartzen du.
	 * 
	 * @param entzunda Entzundako zenbakia.
	 */
	public void setEntzunda(int entzunda) {
		this.entzunda = entzunda;
	}
	
	
}
