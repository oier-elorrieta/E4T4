package test;

import org.junit.jupiter.api.Test;

import model.*;

import static org.junit.Assert.*;

public class TestAbestia {

    @Test
    public void testConstructor() {
        Abestia abestiak = new Abestia("Abestia", 180, true);
        assertEquals("Abestia", abestiak.getIzena());
        assertEquals(180, abestiak.getIraupena());
    }

    @Test
    public void testsetisGustokoena() {
        Abestia abestiak = new Abestia("Abestia", 180, false);
        assertFalse(abestiak.isGustokoena());
    }

    
}