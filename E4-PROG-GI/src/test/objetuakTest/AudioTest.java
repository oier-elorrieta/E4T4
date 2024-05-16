package test.objetuakTest;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Audio;

import java.sql.Blob;
import java.sql.Time;
import java.util.Objects;

public class AudioTest {

	@Test
	public void testAudioEqualsTrue() {
		Time iraupena = new Time(0, 3, 30);
		Audio audio1 = new Audio(1, "Test Audio", iraupena, null);
		Audio audio2 = new Audio(1, "Test Audio", iraupena);

		assertTrue(audio1.equals(audio2));
	}

	@Test
	public void testGetSetIdAudio() {
		Audio audio1 = new Audio();
		audio1.setIdAudio(1);

		assertEquals(1, audio1.getIdAudio());
	}

	@Test
	public void testGetSetIzena() {
		Audio audio1 = new Audio();
		audio1.setIzena("izena1");

		assertEquals("izena1", audio1.getIzena());
	}
	
	@Test
	public void testGetSetIraupena() {
		Audio audio1 = new Audio();
		Time iraupena = new Time(0, 3, 30);
		audio1.setIraupena(iraupena);

		assertEquals(iraupena, audio1.getIraupena());
	}
	
	@Test
	public void testGetSetBlob() {
		Audio audio1 = new Audio();
		audio1.setIrudia(null);

		assertEquals(null, audio1.getIrudia());
	}
	
	@Test
	public void testToString() {
		int idAudio = 1;
		String izena = "Test Audio";
		Time iraupena = new Time(0, 3, 30);
		Blob irudia = null;

		Audio audio = new Audio(idAudio, izena, iraupena, irudia);

		String expected = "Audio [idAudio=" + idAudio + ", izena=" + izena + ", iraupena=" + iraupena + ", irudia="
				+ irudia + "]";
		assertEquals(expected, audio.toString());
	}

	@Test
	public void testEquals() {
		int idAudio = 1;
		String izena = "Test Audio";
		Time iraupena = new Time(0, 3, 30);
		Blob irudia = null;

		Audio audio1 = new Audio(idAudio, izena, iraupena, irudia);
		Audio audio2 = new Audio(idAudio, izena, iraupena, irudia);

		assertTrue(audio1.equals(audio2));
	}

	@Test
	public void testNotEquals() {
		int idAudio1 = 1;
		String izena1 = "Test Audio 1";
		Time iraupena1 = new Time(0, 3, 30);
		Blob irudia1 = null;

		int idAudio2 = 2;
		String izena2 = "Test Audio 2";
		Time iraupena2 = new Time(0, 4, 0);
		Blob irudia2 = null;

		Audio audio1 = new Audio(idAudio1, izena1, iraupena1, irudia1);
		Audio audio2 = new Audio(idAudio2, izena2, iraupena2, irudia2);

		assertFalse(audio1.equals(audio2));
	}

	@Test
	public void testNotEqualsWithDifferentObject() {
		int idAudio = 1;
		String izena = "Test Audio";
		Time iraupena = new Time(0, 3, 30);
		Blob irudia = null;

		Audio audio = new Audio(idAudio, izena, iraupena, irudia);
		String otherObject = "Test";

		assertFalse(audio.equals(otherObject));
	}

	@Test
	public void testEqualsWithNull() {
		int idAudio = 1;
		String izena = "Test Audio";
		Time iraupena = new Time(0, 3, 30);
		Blob irudia = null;

		Audio audio = new Audio(idAudio, izena, iraupena, irudia);

		assertFalse(audio.equals(null));
	}
}