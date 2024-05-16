package test.objetuakTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Hizkuntza;

public class HizkuntzaTest {

	@Test
	public void hizkuntzaIdGetSetTest() {
		Hizkuntza hizkuntza1 = new Hizkuntza();
		hizkuntza1.setIdHizkuntza("id1");
		
		assertEquals("id1", hizkuntza1.getIdHizkuntza());	
	}
	
	@Test
	public void hizkuntzaIzenaGetSetTest() {
		Hizkuntza hizkuntza1 = new Hizkuntza();
		hizkuntza1.setIzenaHizkuntza("izena1");
		
		assertEquals("izena1", hizkuntza1.getIzenaHizkuntza());	
	}
	
	@Test
	public void hizkuntzaEqualsTrueTest() {
		Hizkuntza hizkuntza1 = new Hizkuntza("EU", "Euskera");
		Hizkuntza hizkuntza2 = new Hizkuntza("EU", "Euskera");
		
		assertTrue(hizkuntza1.equals(hizkuntza2));	
	}

	@Test
	public void hizkuntzaEqualsPunteroTest() {
		Hizkuntza hizkuntza1 = new Hizkuntza("EU", "Euskera");
		
		assertTrue(hizkuntza1.equals(hizkuntza1));	
	}
	
	@Test
	public void hizkuntzaEqualsNullTest() {
		Hizkuntza hizkuntza1 = new Hizkuntza("EU", "Euskera");
		Hizkuntza hizkuntza2 = null;
		
		assertFalse(hizkuntza1.equals(hizkuntza2));	
	}
	
	@Test
	public void hizkuntzaEqualsDifClassTest() {
		Hizkuntza hizkuntza1 = new Hizkuntza("EU", "Euskera");
		String hizkuntza2 = "hiz";
		
		assertFalse(hizkuntza1.equals(hizkuntza2));	
	}
	
	@Test
	public void hizkuntzaToStringTest() {
		Hizkuntza hizkuntza1 = new Hizkuntza("EU", "Euskera");
		String txt = "Hizkuntza [idHizkuntza=EU, izenaHizkuntza=Euskera]";
		assertEquals(txt, hizkuntza1.toString());	
	}
}
