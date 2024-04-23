package test;

import org.junit.Test;

import model.Musikaria;

import static org.junit.Assert.*;

public class TestMusikaria {

    @Test
    public void testConstructor() {
        Musikaria musikaria = new Musikaria("Izena", "Deskriptiona", "Irudia");

        assertEquals("Izena", musikaria.getIzena());
        assertEquals("Deskriptiona", musikaria.getDeskription());
        assertEquals("Irudia", musikaria.getIrudia());
    }
}