package test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.util.ArrayList;

import org.junit.Test;

import model.Album;
import model.Audio;
import model.Musikaria;
import model.dao.AlbumDao;
import model.dao.MusikariaDao;

public class AlbumDaoTest {

    @Test
    public void testGetAlbumakDaude() {
        Musikaria musikari = MusikariaDao.getMusikaria("LiSa");
        ArrayList<Album> result = AlbumDao.getAlbumak(musikari);
        assertNotNull(result);
    }
    
    @Test
    public void testGetAlbumakBete() {
        Musikaria musikari = MusikariaDao.getMusikaria("LiSa");
        ArrayList<Album> result = AlbumDao.getAlbumak(musikari);
        assertEquals(2, result.size());
    }

    @Test
    public void testBeteAlbumakKantaKop() {
    	Musikaria musikari = MusikariaDao.getMusikaria("LiSa");
        ArrayList<Album> albumak = AlbumDao.getAlbumak(musikari);
        AlbumDao.beteAlbumakKantaKop(albumak);
        assertEquals(3, albumak.get(0).getKantaKop());
        assertEquals(0, albumak.get(1).getKantaKop());
    }

    @Test
    public void testGetAlbumByAbesti1() {
        Audio audio = new Audio();
        audio.setIdAudio(1);
        Album result = AlbumDao.getAlbumByAbesti(audio);
        assertNotNull(result);

    }
    @Test
    public void testGetAlbumByAbesti2() {
        Audio audio = new Audio();
        audio.setIdAudio(1);
        Album result = AlbumDao.getAlbumByAbesti(audio);
        assertEquals(1, result.getId());
    }
    @Test
    public void testGetAlbumByAbesti3() {
        Audio audio = new Audio();
        audio.setIdAudio(1);
        Album result = AlbumDao.getAlbumByAbesti(audio);
        assertEquals("BS - Singles", result.getIzenburua());
    }
}