package test;
import static org.junit.Assert.*;
import org.junit.Test;

import model.Album;

import java.sql.Blob;

public class AlbumTest {

    @Test
    public void testConstructor() {
        Blob irudia = null;
        Album album = new Album(1, "Izenburua", "Generoa", irudia);
        assertEquals(irudia, album.getIrudia());
    }

    @Test
    public void testSetGeneroa() {
        Blob irudia = null;
        Album album = new Album(1, "Izenburua", "Generoa", irudia);
        album.setGeneroa("New Generoa");
        assertEquals("New Generoa", album.getGeneroa());
    }
    
    @Test
    public void testgetIzenburua() {
        Blob irudia = null;
        Album album = new Album(1, "Izenburua", "Generoa", irudia);
        album.setIzenburua("New Izenburua");
        assertEquals("New Izenburua", album.getIzenburua());
    }
    
    @Test
    public void testSetIrudia() {
        Blob irudia = null;
        Album album = new Album(1, "Izenburua", "Generoa", irudia);
        album.setIrudia(irudia);
        assertEquals(irudia, album.getIrudia());
    }

    @Test
    public void testGetId() {
        Blob irudia = null;
        Album album = new Album(1, "Izenburua", "Generoa", irudia);
        assertEquals(1, album.getId());
    }

    @Test
    public void testSetId() {
        Blob irudia = null;
        Album album = new Album(1, "Izenburua", "Generoa", irudia);
        album.setId(2);
        assertEquals(2, album.getId());
    }

    @Test
    public void testGetKantaKop() {
        Blob irudia = null;
        Album album = new Album(1, "Izenburua", "Generoa", irudia);
        album.setKantaKop(10);
        assertEquals(10, album.getKantaKop());
    }

    @Test
    public void testToString() {
        Blob irudia = null;
        Album album = new Album(1, "Izenburua", "Generoa", irudia);
        album.setKantaKop(5);
        String expected = "Izenburua: Izenburua  || Generoa: Generoa  || Kantak: 5";
        assertEquals(expected, album.toString());
    }
}