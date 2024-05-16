package test.objetuakTest;
import static org.junit.Assert.*;
import org.junit.Test;

import model.Audio;

import java.sql.Blob;
import java.sql.Time;
import java.util.Objects;

public class AudioTest {

    @Test
    public void testAudio() {
        int idAudio = 1;
        String izena = "Test Audio";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;

        Audio audio = new Audio(idAudio, izena, iraupena, irudia);

        assertEquals(idAudio, audio.getIdAudio());
    }
    @Test
    public void testIzena() {
        int idAudio = 1;
        String izena = "Test Audio";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;

        Audio audio = new Audio(idAudio, izena, iraupena, irudia);

        assertEquals(izena, audio.getIzena());
    }
    @Test
    public void testIraupena() {
        int idAudio = 1;
        String izena = "Test Audio";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;

        Audio audio = new Audio(idAudio, izena, iraupena, irudia);

        assertEquals(iraupena, audio.getIraupena());
    }
    @Test
    public void testIrudia() {
        int idAudio = 1;
        String izena = "Test Audio";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;

        Audio audio = new Audio(idAudio, izena, iraupena, irudia);

        assertEquals(irudia, audio.getIrudia());
    }

    @Test
    public void testGetAudio() {
        Audio audio = new Audio();

        int idAudio = 1;
        audio.setIdAudio(idAudio);
        assertEquals(idAudio, audio.getIdAudio());
    }
    @Test
    public void testGetIzena() {
        Audio audio = new Audio();

        String izena = "Test Audio";
        audio.setIzena(izena);
        assertEquals(izena, audio.getIzena());
    }
    @Test
    public void testGetIraupena() {
        Audio audio = new Audio();
        
        Time iraupena = new Time(0, 3, 30);
        audio.setIraupena(iraupena);
        assertEquals(iraupena, audio.getIraupena());

    }
    @Test
    public void testGetIrudia() {
        Audio audio = new Audio();

        Blob irudia = null;
        audio.setIrudia(irudia);
        assertEquals(irudia, audio.getIrudia());
    }

    @Test
    public void testToString() {
        int idAudio = 1;
        String izena = "Test Audio";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;

        Audio audio = new Audio(idAudio, izena, iraupena, irudia);

        String expected = "Audio [idAudio=" + idAudio + ", izena=" + izena + ", iraupena=" + iraupena + ", irudia=" + irudia + "]";
        assertEquals(expected, audio.toString());
    }

    @Test
    public void testEquals() {
        int idAudio = 1;
        String izena = "Test Audio";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;

        Audio audio1 = new Audio(idAudio, izena, iraupena, irudia);
        Audio audio2 = new Audio(idAudio, izena, iraupena, irudia);

        assertTrue(audio1.equals(audio2));
    }

    @Test
    public void testNotEquals() {
        int idAudio1 = 1;
        String izena1 = "Test Audio 1";
        Time iraupena1 = new Time(0, 3, 30);
        Blob irudia1 = null;

        int idAudio2 = 2;
        String izena2 = "Test Audio 2";
        Time iraupena2 = new Time(0, 4, 0);
        Blob irudia2 = null;

        Audio audio1 = new Audio(idAudio1, izena1, iraupena1, irudia1);
        Audio audio2 = new Audio(idAudio2, izena2, iraupena2, irudia2);

        assertFalse(audio1.equals(audio2));
    }

    @Test
    public void testNotEqualsWithDifferentObject() {
        int idAudio = 1;
        String izena = "Test Audio";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;

        Audio audio = new Audio(idAudio, izena, iraupena, irudia);
        String otherObject = "Test";

        assertFalse(audio.equals(otherObject));
    }

    @Test
    public void testEqualsWithNull() {
        int idAudio = 1;
        String izena = "Test Audio";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;

        Audio audio = new Audio(idAudio, izena, iraupena, irudia);

        assertFalse(audio.equals(null));
    }
}