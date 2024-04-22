package test;

import org.junit.jupiter.api.Test;

import model.*;

import static org.junit.Assert.*;

public class TestAbestiak {

    @Test
    public void testConstructor() {
        Abestiak abestiak = new Abestiak("Abestia", 180, true);
        assertEquals("Abestia", abestiak.getIzena());
        assertEquals(180, abestiak.getIraupena());
    }

    @Test
    public void testsetisGustokoena() {
        Abestiak abestiak = new Abestiak("Abestia", 180, false);
        assertFalse(abestiak.isGustokoena());
    }

    
}