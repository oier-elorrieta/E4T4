package test;

import model.*;

import static org.junit.Assert.*;

public class TestAudio {
    
    @Test
    public void testEquals() {
        Audio audio1 = new Audio("Song 1", 180);
        Audio audio2 = new Audio("Song 1", 180);
        Audio audio3 = new Audio("Song 2", 240);
        
        assertTrue(audio1.equals(audio2));
        
        assertFalse(audio1.equals(audio3));
    }
    
    @Test
    public void testToString() {
        Audio audio = new Audio("Song 1", 180);
        
        assertEquals("Audio [izena=Song 1, iraupena=180]", audio.toString());
    }
    
    @Test
    public void testGettersAndSetters() {
        Audio audio = new Audio("Song 1", 180);
        
        assertEquals("Song 1", audio.getIzena());
        assertEquals(180, audio.getIraupena());
        
        audio.setIzena("Song 2");
        audio.setIraupena(240);
        
        assertEquals("Song 2", audio.getIzena());
        assertEquals(240, audio.getIraupena());
    }
}