package model;

import java.util.Objects;

public class Estadistika {
	private String s1;
	private String s2;
	private int entzunda;
	
	
	
	public Estadistika() {
	}
	public Estadistika(String s1, String s2, int entzunda) {
		super();
		this.s1 = s1;
		this.s2 = s2;
		this.entzunda = entzunda;
	}
	@Override
	public int hashCode() {
		return Objects.hash(entzunda, s1, s2);
	}
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
	@Override
	public String toString() {
		return "Estadistika [s1=" + s1 + ", s2=" + s2 + ", entzunda=" + entzunda + "]";
	}
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public int getEntzunda() {
		return entzunda;
	}
	public void setEntzunda(int entzunda) {
		this.entzunda = entzunda;
	}
	
	
}
