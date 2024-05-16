package test.objetuakTest;
import static org.junit.Assert.*;
import org.junit.Test;

import model.Podcast;

import java.sql.Blob;
import java.sql.Time;

public class PodcastTest {

    @Test
    public void testId() {
        int idAudio = 1;
        String izena = "Podcast Name";
        Time iraupena = new Time(0, 10, 0);
        Blob irudia = null;

        Podcast podcast = new Podcast(idAudio, izena, iraupena, irudia);

        assertEquals(idAudio, podcast.getIdAudio());
    }
    @Test
    public void testizena() {
        int idAudio = 1;
        String izena = "Podcast Name";
        Time iraupena = new Time(0, 10, 0);
        Blob irudia = null;

        Podcast podcast = new Podcast(idAudio, izena, iraupena, irudia);
        assertEquals(izena, podcast.getIzena());

    }
    @Test
    public void testIraupena() {
        int idAudio = 1;
        String izena = "Podcast Name";
        Time iraupena = new Time(0, 10, 0);
        Blob irudia = null;

        Podcast podcast = new Podcast(idAudio, izena, iraupena, irudia);

        assertEquals(iraupena, podcast.getIraupena());
    }
    @Test
    public void testIrudia() {
        int idAudio = 1;
        String izena = "Podcast Name";
        Time iraupena = new Time(0, 10, 0);
        Blob irudia = null;

        Podcast podcast = new Podcast(idAudio, izena, iraupena, irudia);

        assertEquals(irudia, podcast.getIrudia());
    }

    @Test
    public void testSetIdAudio() {
        int idAudio = 1;
        Podcast podcast = new Podcast(idAudio, "Podcast Name", new Time(0, 10, 0), null);

        int newIdAudio = 2;
        podcast.setIdAudio(newIdAudio);

        assertEquals(newIdAudio, podcast.getIdAudio());
    }

    @Test
    public void testSetIzena() {
        String izena = "Podcast Name";
        Podcast podcast = new Podcast(1, izena, new Time(0, 10, 0), null);

        String newIzena = "New Podcast Name";
        podcast.setIzena(newIzena);

        assertEquals(newIzena, podcast.getIzena());
    }

    @Test
    public void testSetIraupena() {
        Time iraupena = new Time(0, 10, 0);
        Podcast podcast = new Podcast(1, "Podcast Name", iraupena, null);

        Time newIraupena = new Time(0, 15, 0);
        podcast.setIraupena(newIraupena);

        assertEquals(newIraupena, podcast.getIraupena());
    }

    @Test
    public void testSetIrudia() {
        Blob irudia = null;
        Podcast podcast = new Podcast(1, "Podcast Name", new Time(0, 10, 0), irudia);

        Blob newIrudia = null;
        podcast.setIrudia(newIrudia);

        assertEquals(newIrudia, podcast.getIrudia());
    }
}