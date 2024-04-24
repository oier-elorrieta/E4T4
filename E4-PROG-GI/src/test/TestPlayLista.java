package test;

import static org.junit.Assert.*;
import org.junit.Test;

import model.PlayListak;

import java.util.Date;

public class TestPlayLista {

    @Test
    public void testEquals() {
        Date date1 = new Date();
        PlayListak playlist1 = new PlayListak(1,"Playlist 1", date1);
        PlayListak playlist2 = new PlayListak(2,"Playlist 1", date1);
        PlayListak playlist3 = new PlayListak(3,"Playlist 2", date1);

        assertTrue(playlist1.equals(playlist2));

        assertFalse(playlist1.equals(playlist3));
    }

    @Test
    public void testToString() {
        Date date = new Date();
        PlayListak playlist = new PlayListak(4, "Playlist 1", date);
        String expected = "PlayListak [izena=Playlist 1, sorreraData=" + date + "]";
        assertEquals(expected, playlist.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Date date = new Date();
        PlayListak playlist = new PlayListak(5, "Playlist 1", date);

        assertEquals(date, playlist.getSorreraData());
    }

    @Test
    public void testgetsetAbizena() {
        Date date = new Date();
        PlayListak playlist = new PlayListak(6,"Playlist 1", date);
        playlist.setIzena("New Playlist");
        assertEquals("New Playlist", playlist.getIzena());
    }

    @Test
    public void testgetsetJaiotzeData() {
        Date date = new Date();
        PlayListak playlist = new PlayListak(7,"Playlist 1", date);
        playlist.setSorreraData(date);;
        assertEquals(date, playlist.getSorreraData());
    }
}