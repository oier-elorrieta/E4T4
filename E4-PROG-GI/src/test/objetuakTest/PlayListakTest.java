package test.objetuakTest;
import static org.junit.Assert.*;
import org.junit.Test;

import model.PlayListak;

import java.util.Date;

public class PlayListakTest {

    @Test
    public void testPlayListEquals() {
        PlayListak playlist1 = new PlayListak(1, "Playlist 1", new Date());
        PlayListak playlist2 = new PlayListak(1, "Playlist 1", new Date());

        assertTrue(playlist1.equals(playlist2));
    }
  
    @Test
    public void testPlayListPunteroEquals() {
        PlayListak playlist1 = new PlayListak(1, "Playlist 1", new Date());

        assertTrue(playlist1.equals(playlist1));
    }
    
    @Test
    public void testPlayListNullEquals() {
        PlayListak playlist1 = new PlayListak(1, "Playlist 1", new Date());
        PlayListak playlist2 = null;

        assertFalse(playlist1.equals(playlist2));
    }
    
    @Test
    public void testPlayListDiffClassEquals() {
        PlayListak playlist1 = new PlayListak(1, "Playlist 1", new Date());
        String playlist2 = "playlist2";

        assertFalse(playlist1.equals(playlist2));
    }
    
    @Test
    public void testPlayListId() {
        PlayListak playlist1 = new PlayListak();
        playlist1.setIdPlayList(1);

        assertEquals(1, playlist1.getIdPlayList());
    }
    
    @Test
    public void testPlayListIzena() {
        PlayListak playlist1 = new PlayListak();
        playlist1.setIzena("playlist1");

        assertEquals("playlist1", playlist1.getIzena());
    }
    
    @Test
    public void testPlayListSorreraData() {
    	Date date = new Date();
        PlayListak playlist1 = new PlayListak();
        playlist1.setSorreraData(new Date());;

        assertEquals(date, playlist1.getSorreraData());
    }
    
    @Test
    public void testPlayListToString() {
        PlayListak playlist1 = new PlayListak();
        playlist1.setIzena("playlist1");
        String txt = "playlist1";
        assertEquals("playlist1", playlist1.toString());
    }
}