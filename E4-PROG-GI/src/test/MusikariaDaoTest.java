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
    public void testGetMusikariakEntzunaldiak() {
        ArrayList<Musikaria> result = MusikariaDao.getMusikariakEntzunaldiak();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetMusikaria() {
        Musikaria result = MusikariaDao.getMusikaria("Estopa");
        assertNotNull(result);
        assertEquals("Estopa", result.getIzena());
        assertNotNull(result.getIrudia());
        assertEquals(10, result.getEntzunaldiak());
    }

    @Test
    public void testGetMusikariaByAudio() {
        Audio audio = new Audio();
        audio.setIdAudio(1);
        Musikaria result = MusikariaDao.getMusikariaByAudio(audio);
        assertNotNull(result);
        assertEquals("Estopa", result.getIzena());
        assertNotNull(result.getIrudia());
        assertEquals("Description", result.getDeskription());
    }
}