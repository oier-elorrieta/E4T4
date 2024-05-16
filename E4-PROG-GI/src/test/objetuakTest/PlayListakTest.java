package test.objetuakTest;
import static org.junit.Assert.*;
import org.junit.Test;

import model.PlayListak;

import java.util.Date;

public class PlayListakTest {

    @Test
    public void testEquals() {
        PlayListak playlist1 = new PlayListak(1, "Playlist 1", new Date());
        PlayListak playlist2 = new PlayListak(1, "Playlist 1", new Date());
        PlayListak playlist3 = new PlayListak(2, "Playlist 2", new Date());

        assertFalse(playlist1.equals(playlist3));
    }
    @Test
    public void testEquals2() {
        PlayListak playlist1 = new PlayListak(1, "Playlist 1", new Date());
        PlayListak playlist2 = new PlayListak(1, "Playlist 1", new Date());
        PlayListak playlist3 = new PlayListak(2, "Playlist 2", new Date());

        assertTrue(playlist1.equals(playlist2));
    }

    @Test
    public void testToString() {
        PlayListak playlist = new PlayListak(1, "Playlist 1", new Date());
        String expected = "Playlist 1";
        String result = playlist.toString();
        assertEquals(expected, result);
    }

    @Test
    public void testGetIdPlayList() {
        PlayListak playlist = new PlayListak(1, "Playlist 1", new Date());
        int expected = 1;
        int result = playlist.getIdPlayList();
        assertEquals(expected, result);
    }

    @Test
    public void testSetIdPlayList() {
        PlayListak playlist = new PlayListak(1, "Playlist 1", new Date());
        int expected = 2;
        playlist.setIdPlayList(expected);
        int result = playlist.getIdPlayList();
        assertEquals(expected, result);
    }

    @Test
    public void testGetIzena() {
        PlayListak playlist = new PlayListak(1, "Playlist 1", new Date());
        String expected = "Playlist 1";
        String result = playlist.getIzena();
        assertEquals(expected, result);
    }

    @Test
    public void testSetIzena() {
        PlayListak playlist = new PlayListak(1, "Playlist 1", new Date());
        String expected = "Playlist 2";
        playlist.setIzena(expected);
        String result = playlist.getIzena();
        assertEquals(expected, result);
    }

    @Test
    public void testGetSorreraData() {
        Date date = new Date();
        PlayListak playlist = new PlayListak(1, "Playlist 1", date);
        Date result = playlist.getSorreraData();
        assertEquals(date, result);
    }

    @Test
    public void testSetSorreraData() {
        Date date = new Date();
        PlayListak playlist = new PlayListak(1, "Playlist 1", new Date());
        playlist.setSorreraData(date);
        Date result = playlist.getSorreraData();
        assertEquals(date, result);
    }
}