package test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.util.ArrayList;

import org.junit.Test;

import model.Album;
import model.Audio;
import model.Musikaria;
import model.dao.AlbumDao;

public class AlbumDaoTest {

    @Test
    public void testGetAlbumak() {
        Musikaria musikari = new Musikaria();
        musikari.setIdArtista(1);
        ArrayList<Album> result = AlbumDao.getAlbumak(musikari);
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testBeteAlbumakKantaKop() {
        ArrayList<Album> albumak = new ArrayList<>();
        Album album1 = new Album();
        album1.setId(1);
        Album album2 = new Album();
        album2.setId(2);
        albumak.add(album1);
        albumak.add(album2);
        AlbumDao.beteAlbumakKantaKop(albumak);
        assertEquals(3, album1.getKantaKop());
        assertEquals(2, album2.getKantaKop());
    }

    @Test
    public void testGetAlbumByAbesti() {
        Audio audio = new Audio();
        audio.setIdAudio(1);
        Album result = AlbumDao.getAlbumByAbesti(audio);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Album1", result.getIzenburua());
    }
}