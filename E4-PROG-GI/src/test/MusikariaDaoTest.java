package test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.util.ArrayList;

import org.junit.Test;

import model.Audio;
import model.Musikaria;
import model.dao.MusikariaDao;

public class MusikariaDaoTest {

    @Test
    public void testGetMusikariakEntzunaldiak1() {
        ArrayList<Musikaria> result = MusikariaDao.getMusikariakEntzunaldiak();
        assertNotNull(result);
    }
    
    @Test
    public void testGetMusikariakEntzunaldiak2() {
        ArrayList<Musikaria> result = MusikariaDao.getMusikariakEntzunaldiak();
        assertEquals(4, result.size());
    }

    @Test
    public void testGetMusikaria1() {
        Musikaria result = MusikariaDao.getMusikaria("Estopa");
        assertNotNull(result);
    }
    
    @Test
    public void testGetMusikaria2() {
        Musikaria result = MusikariaDao.getMusikaria("Estopa");
        assertEquals("Estopa", result.getIzena());
    }
    
    @Test
    public void testGetMusikaria3() {
        Musikaria result = MusikariaDao.getMusikaria("Estopa");
        assertNotNull(result.getIrudia());
    }
    
    @Test
    public void testGetMusikaria4() {
        Musikaria result = MusikariaDao.getMusikaria("Estopa");
        assertEquals(0, result.getEntzunaldiak());
    }

    @Test
    public void testGetMusikariaByAudio1() {
        Audio audio = new Audio();
        audio.setIdAudio(1);
        Musikaria result = MusikariaDao.getMusikariaByAudio(audio);
        assertNotNull(result);

    }
    @Test
    public void testGetMusikariaByAudio2() {
        Audio audio = new Audio();
        audio.setIdAudio(1);
        Musikaria result = MusikariaDao.getMusikariaByAudio(audio);
        assertEquals("Burnout Syndromes", result.getIzena());
    }
    @Test
    public void testGetMusikariaByAudio3() {
        Audio audio = new Audio();
        audio.setIdAudio(1);
        Musikaria result = MusikariaDao.getMusikariaByAudio(audio);
        assertNotNull(result.getIrudia());
    }
    @Test
    public void testGetMusikariaByAudio4() {
        Audio audio = new Audio();
        audio.setIdAudio(1);
        Musikaria result = MusikariaDao.getMusikariaByAudio(audio);
        assertEquals("BURNOUT SINDROMES (バーンアウトシンドロームズ) Osakako japoniar rock talde bat da. 2005eko maiatzaren 4an eratua.", result.getDeskription());
    }
}