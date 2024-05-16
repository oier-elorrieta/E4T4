package test.objetuakTest;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Album;

import java.util.Date;

public class AlbumTest {

	@Test
	public void testAlbumEquals() {
		Date date = new Date();
		Album album1 = new Album(1, "Izenburua", "Generoa", null, date);
		Album album2 = new Album(1, "Izenburua", "Generoa", null, date);
		assertTrue(album1.equals(album2));
	}

	@Test
	public void testAlbumPunteroEquals() {
		Date date = new Date();
		Album album1 = new Album("Izenburua", "Generoa", null, date);
		assertTrue(album1.equals(album1));
	}

	@Test
	public void testAlbumNullEquals() {
		Album album1 = new Album(1, "Izenburua", "Generoa", null);
		Album album2 = null;
		assertFalse(album1.equals(album2));
	}

	@Test
	public void testAlbumDiffClassEquals() {
		Album album1 = new Album(1, "Izenburua");
		String album2 = "album2";
		assertFalse(album1.equals(album2));
	}
	
	@Test
	public void testAlbumId() {
		Album album1 = new Album();
		album1.setId(1);
		assertEquals(1, album1.getId());
	}
	
	@Test
	public void testAlbumIzenburua() {
		Album album1 = new Album();
		album1.setIzenburua("izenburua");
		assertEquals("izenburua", album1.getIzenburua());
	}
	
	@Test
	public void testAlbumGeneroa() {
		Album album1 = new Album();
		album1.setGeneroa("rock");
		assertEquals("rock", album1.getGeneroa());
	}
	
	@Test
	public void testAlbumIrudia() {
		Album album1 = new Album();
		album1.setIrudia(null);
		assertEquals(null, album1.getIrudia());
	}
	
	@Test
	public void testAlbumIrudiaString() {
		Album album1 = new Album();
		album1.setIrudiaString("irudiaString");
		assertEquals("irudiaString", album1.getIrudiaString());
	}
	
	@Test
	public void testAlbumKantaKop() {
		Album album1 = new Album();
		album1.setKantaKop(1);
		assertEquals(1, album1.getKantaKop());
	}
	
	@Test
	public void testAlbumUrtea() {
		Date date = new Date();
		Album album1 = new Album();
		album1.setUrtea(date);
		assertEquals(date, album1.getUrtea());
	}
	
	@Test
	public void testAlbumToString() {
		Album album1 = new Album();
		album1.setIzenburua("izenburua");
		album1.setGeneroa("generoa");
		album1.setKantaKop(1);
		String txt = "Izenburua: izenburua  || Generoa: generoa  || Kantak: 1";
		assertEquals(txt, album1.toString());
	}
	

}