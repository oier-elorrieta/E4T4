package test.objetuakTest;
import static org.junit.Assert.*;

import java.sql.Blob;

import org.junit.Test;


import model.Musikaria;

public class MusikariaTest {


    @Test
    public void testIzena() {
        Blob irudia = null;
        Musikaria musikaria = new Musikaria("Izena", "Deskribapena", irudia);
        assertEquals("Izena", musikaria.getIzena());
    }
    @Test
    public void testDeskripzioa() {
        Blob irudia = null;
        Musikaria musikaria = new Musikaria("Izena", "Deskribapena", irudia);

        assertEquals("Deskribapena", musikaria.getDeskription());

    }
    @Test
    public void testirudia() {
        Blob irudia = null;
        Musikaria musikaria = new Musikaria("Izena", "Deskribapena", irudia);
        assertEquals(irudia, musikaria.getIrudia());
    }

    @Test
    public void testToString() {
        Blob irudia = null;
        Musikaria musikaria = new Musikaria(1, "Izena", "Deskribapena", irudia, "Ezaugarria");
        String expected = "Izena";
        assertEquals(expected, musikaria.toString());
    }
}