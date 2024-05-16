package test.objetuakTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.AbestiGuztokoa;
import model.Audio;
import model.Erabiltzailea;

public class AbestiGuztokoaTest {

	@Test
	public void testAbestiGuztokoaEquals() {
		Erabiltzailea erabiltzailea = new Erabiltzailea();
		Audio audioa = new Audio();
		
		AbestiGuztokoa abestiGuztokoa1 = new AbestiGuztokoa(erabiltzailea, audioa);	
		AbestiGuztokoa abestiGuztokoa2 = new AbestiGuztokoa(erabiltzailea, audioa);	
		
		assertTrue(abestiGuztokoa1.equals(abestiGuztokoa2));
	}
	
	@Test
	public void testAbestiGuztokoaPunteroEquals() {
		Erabiltzailea erabiltzailea = new Erabiltzailea();
		Audio audioa = new Audio();
		
		AbestiGuztokoa abestiGuztokoa1 = new AbestiGuztokoa(erabiltzailea, audioa);	
		
		assertTrue(abestiGuztokoa1.equals(abestiGuztokoa1));
	}
	
	@Test
	public void testAbestiGuztokoaNullEquals() {
		Erabiltzailea erabiltzailea = new Erabiltzailea();
		Audio audioa = new Audio();
		
		AbestiGuztokoa abestiGuztokoa1 = new AbestiGuztokoa(erabiltzailea, audioa);	
		AbestiGuztokoa abestiGuztokoa2 = null;	
		
		assertFalse(abestiGuztokoa1.equals(abestiGuztokoa2));
	}

	@Test
	public void testAbestiGuztokoaDiffClassEquals() {
		Erabiltzailea erabiltzailea = new Erabiltzailea();
		Audio audioa = new Audio();
		
		AbestiGuztokoa abestiGuztokoa1 = new AbestiGuztokoa(erabiltzailea, audioa);	
		String abestiGuztokoa2 = "abestiGuztoko2";	
		
		assertFalse(abestiGuztokoa1.equals(abestiGuztokoa2));
	}
	
	@Test
	public void testAbestiGuztokoaGetSetErabiltzailea() {
		Erabiltzailea erabiltzailea = new Erabiltzailea();
		AbestiGuztokoa abestiGuztokoa1 = new AbestiGuztokoa();	
		abestiGuztokoa1.setErabiltzailea(erabiltzailea);
		
		assertEquals(erabiltzailea, abestiGuztokoa1.getErabiltzailea());
	}
	
	@Test
	public void testAbestiGuztokoaGetSetAudio() {
		Audio audioa = new Audio();
		AbestiGuztokoa abestiGuztokoa1 = new AbestiGuztokoa();	
		abestiGuztokoa1.setAudio(audioa);
		
		assertEquals(audioa, abestiGuztokoa1.getAudio());
	}
	
	@Test
	public void testAbestiGuztokoatoString() {
		AbestiGuztokoa abestiGuztokoa1 = new AbestiGuztokoa();	
		String txt = "AbestiGuztokoa [erabiltzailea=" + null + ", audio=" + null + "]";
		
		assertEquals(txt, abestiGuztokoa1.toString());
	}
}
