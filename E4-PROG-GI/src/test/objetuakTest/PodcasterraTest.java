package test.objetuakTest;
import static org.junit.Assert.*;

import java.sql.Blob;

import org.junit.Test;

import model.Podcasterra;

public class PodcasterraTest {

	@Test 
	public void testsetEntzunaldiak() {
		Blob irudia = null;
		Podcasterra podcasterra = new Podcasterra(1, "Podcasterra", "Description", irudia);
		podcasterra.setEntzunaldiak(podcasterra.getEntzunaldiak());
		assertEquals(0, podcasterra.getEntzunaldiak());
	}

    @Test
    public void testDescripzioa() {
        Podcasterra podcasterra = new Podcasterra(1, "Podcasterra", "Description", null);
        podcasterra.setDeskription("New Description");
        assertEquals("New Description", podcasterra.getDeskription());
    }
    
    @Test
    public void testIrudia() {
    	Podcasterra podcasterra = new Podcasterra(1, "Podcasterra", "Description", null);
        Blob newIrudia = null;
        podcasterra.setIrudia(newIrudia);
        assertEquals(newIrudia, podcasterra.getIrudia());
    }
    
    @Test
    public void testIzena() {
    	Podcasterra podcasterra = new Podcasterra(1, "Podcasterra", "Description", null);
    	podcasterra.setIzena("New Podcasterra");
    	assertEquals("New Podcasterra", podcasterra.getIzena());
    }
    
    @Test
    public void testIdArtista() {
    	Podcasterra podcasterra = new Podcasterra(1, "Podcasterra", "Description", null);
        podcasterra.setIdArtista(2);
        assertEquals(2, podcasterra.getIdArtista());
    }
}