package test.objetuakTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Estadistika;

public class EstadistikaTest {

	@Test
	public void testEstadistikaEquals() {
		Estadistika estadistika1 = new Estadistika("s1", "s2", 1);
		Estadistika estadistika2 = new Estadistika("s1", "s2", 1);
		
		assertTrue(estadistika1.equals(estadistika2));
	}
	
	@Test
	public void testEstadistikaPunteroEquals() {
		Estadistika estadistika1 = new Estadistika("s1", "s2", 1);
		
		assertTrue(estadistika1.equals(estadistika1));
	}
	
	@Test
	public void testEstadistikaNullEquals() {
		Estadistika estadistika1 = new Estadistika("s1", "s2", 1);
		Estadistika estadistika2 = null;
		
		assertFalse(estadistika1.equals(estadistika2));
	}
	
	@Test
	public void testEstadistikaDiffClassEquals() {
		Estadistika estadistika1 = new Estadistika("s1", "s2", 1);
		String estadistika2 = "estadistika2";
		
		assertFalse(estadistika1.equals(estadistika2));
	}
	
	@Test
	public void testEstadistikaS1() {
		Estadistika estadistika1 = new Estadistika();
		estadistika1.setS1("s1");
		
		assertEquals("s1", estadistika1.getS1());
	}
	
	@Test
	public void testEstadistikaS2() {
		Estadistika estadistika1 = new Estadistika();
		estadistika1.setS2("s2");
		
		assertEquals("s2", estadistika1.getS2());
	}
	
	@Test
	public void testEstadistikaEntzunda() {
		Estadistika estadistika1 = new Estadistika();
		estadistika1.setEntzunda(1);
		
		assertEquals(1, estadistika1.getEntzunda());
	}
	
	@Test
	public void testEstadistikaToString() {
		Estadistika estadistika1 = new Estadistika("s1", "s2", 1);
		String txt = "Estadistika [s1=s1, s2=s2, entzunda=1]";
		assertEquals(txt, estadistika1.toString());
	}

}
