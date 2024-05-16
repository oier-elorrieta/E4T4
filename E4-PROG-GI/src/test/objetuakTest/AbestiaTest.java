package test.objetuakTest;
import static org.junit.Assert.*;
import org.junit.Test;

import model.Abestia;

import java.sql.Blob;
import java.sql.Time;

public class AbestiaTest {

    @Test
    public void testGustokoena() {
        int idAudio = 1;
        String izena = "Abestia";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;
        boolean gustokoena = true;

        Abestia abestia = new Abestia(idAudio, izena, iraupena, irudia, gustokoena);

        assertEquals(gustokoena, abestia.isGustokoena());
    }
    
    @Test
    public void testIrudia() {
        int idAudio = 1;
        String izena = "Abestia";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;
        boolean gustokoena = true;

        Abestia abestia = new Abestia(idAudio, izena, iraupena, irudia, gustokoena);

        assertEquals(irudia, abestia.getIrudia());
    }
    
    @Test
    public void testIraupean() {
        int idAudio = 1;
        String izena = "Abestia";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;
        boolean gustokoena = true;

        Abestia abestia = new Abestia(idAudio, izena, iraupena, irudia, gustokoena);

        assertEquals(iraupena, abestia.getIraupena());
    }
    
    @Test
    public void testIzena() {
        int idAudio = 1;
        String izena = "Abestia";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;
        boolean gustokoena = true;

        Abestia abestia = new Abestia(idAudio, izena, iraupena, irudia, gustokoena);

        assertEquals(izena, abestia.getIzena());
    }
    
    @Test
    public void testaudioa() {
        int idAudio = 1;
        String izena = "Abestia";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;
        boolean gustokoena = true;

        Abestia abestia = new Abestia(idAudio, izena, iraupena, irudia, gustokoena);

        assertEquals(idAudio, abestia.getIdAudio());
    }

    @Test
    public void testAbestiaConstructorWithIdIzenaIraupena() {
        int idAudio = 1;
        String izena = "Abestia";
        Time iraupena = new Time(0, 3, 30);

        Abestia abestia = new Abestia(idAudio, izena, iraupena);

        assertEquals(idAudio, abestia.getIdAudio());
    }

    @Test
    public void testIsGustokoena() {
        Abestia abestia = new Abestia();
        abestia.setGustokoena(true);

        assertTrue(abestia.isGustokoena());
    }

    @Test
    public void testSetGustokoena() {
        Abestia abestia = new Abestia();
        abestia.setGustokoena(true);

        assertTrue(abestia.isGustokoena());
    }

}