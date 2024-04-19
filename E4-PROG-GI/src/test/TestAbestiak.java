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
        assertTrue(abestiak.isGustokoena());
    }
    
    // Add more test methods here if needed
    
}