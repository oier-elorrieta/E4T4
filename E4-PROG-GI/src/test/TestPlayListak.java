package test;

import static org.junit.Assert.*;
import org.junit.Test;

import model.PlayListak;

import java.util.Date;

public class TestPlayListak {

    @Test
    public void testEquals() {
        Date date1 = new Date();
        Date date2 = new Date();
        PlayListak playlist1 = new PlayListak("Playlist 1", date1);
        PlayListak playlist2 = new PlayListak("Playlist 1", date1);
        PlayListak playlist3 = new PlayListak("Playlist 2", date1);
        PlayListak playlist4 = new PlayListak("Playlist 1", date2);

        // Test equal playlists
        assertTrue(playlist1.equals(playlist2));

        // Test playlists with different names
        assertFalse(playlist1.equals(playlist3));

        // Test playlists with different creation dates
        assertFalse(playlist1.equals(playlist4));
    }

    @Test
    public void testToString() {
        Date date = new Date();
        PlayListak playlist = new PlayListak("Playlist 1", date);
        String expected = "PlayListak [izena=Playlist 1, sorreraData=" + date + "]";
        assertEquals(expected, playlist.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Date date = new Date();
        PlayListak playlist = new PlayListak("Playlist 1", date);

        // Test getIzena()
        assertEquals("Playlist 1", playlist.getIzena());

        // Test getSorreraData()
        assertEquals(date, playlist.getSorreraData());

        // Test setIzena()
        playlist.setIzena("New Playlist");
        assertEquals("New Playlist", playlist.getIzena());

        // Test setSorreraData()
        Date newDate = new Date();
        playlist.setSorreraData(newDate);
        assertEquals(newDate, playlist.getSorreraData());
    }
}