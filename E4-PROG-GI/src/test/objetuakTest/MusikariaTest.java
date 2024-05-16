package test.objetuakTest;
import static org.junit.Assert.*;

import org.junit.Test;


import model.Musikaria;

public class MusikariaTest {


    @Test
    public void testMusikariaEqualsTrue() {
    Musikaria musikaria1 = new Musikaria(1, "musikaria", "musikadesc", null, "taldea");
    Musikaria musikaria2 = new Musikaria(1, "musikaria", "musikadesc", null, "taldea");
    assertTrue(musikaria1.equals(musikaria2));
    }
    
    @Test
    public void testMusikariaEqualsFalse() {
    Musikaria musikaria1 = new Musikaria(1, "musikaria", "musikadesc", null, "taldea");
    Musikaria musikaria2 = new Musikaria("musikaria", "musikadesc", "blob", "taldea");
    assertFalse(musikaria1.equals(musikaria2));
    }
    
    @Test
    public void testMusikariaPunteroEquals() {
    Musikaria musikaria1 = new Musikaria("musikaria", null, 0);
    assertTrue(musikaria1.equals(musikaria1));
    
    }
    
    @Test
    public void testMusikariaNullEquals() {
    Musikaria musikaria1 = new Musikaria("musikaria", "desc", null);
    String musikaria2 = "musikaria";
    assertFalse(musikaria1.equals(musikaria2)); 
    }
    
    @Test
    public void testMusikariaDiffClassEquals() {
    Musikaria musikaria1 = new Musikaria(1, "musikaria");
    Musikaria musikaria2 = null;
    assertFalse(musikaria1.equals(musikaria2));
    }
    
    @Test
    public void testMusikariaId() {
    Musikaria musikaria1 = new Musikaria();
    musikaria1.setIdArtista(1);
    assertEquals(1, musikaria1.getIdArtista());
    }
    
    @Test
    public void testMusikariaIzena() {
    Musikaria musikaria1 = new Musikaria();
    musikaria1.setIzena("musikari");
    assertEquals("musikari", musikaria1.getIzena());
    }
    
    @Test
    public void testMusikariaDeskripzioa() {
    Musikaria musikaria1 = new Musikaria();
    musikaria1.setDeskription("musikari");
    assertEquals("musikari", musikaria1.getDeskription());
    }
    
    @Test
    public void testMusikariaIrudia() {
    Musikaria musikaria1 = new Musikaria();
    musikaria1.setIrudia(null);
    assertEquals(null, musikaria1.getIrudia());
    }
    
    @Test
    public void testMusikariaEntzunaldiak() {
    Musikaria musikaria1 = new Musikaria();
    musikaria1.setEntzunaldiak(1);
    assertEquals(1, musikaria1.getEntzunaldiak());
    }
    
    @Test
    public void testMusikariaIrudiaString() {
    Musikaria musikaria1 = new Musikaria();
    musikaria1.setIrudiaString("irudia");
    assertEquals("irudia", musikaria1.getIrudiaString());
    }
    
    @Test
    public void testMusikariaEzaugarria() {
    Musikaria musikaria1 = new Musikaria();
    musikaria1.setEzaugarria("taldea");
    assertEquals("taldea", musikaria1.getEzaugarria());
    }
    
    @Test
    public void testMusikariaToString() {
    Musikaria musikaria1 = new Musikaria(1, "izena");
    String txt = "izena";
    assertEquals(txt, musikaria1.toString());
    }    
}