package test.testDao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import model.Album;
import model.Audio;
import model.Musikaria;
import model.dao.AlbumDao;

public class AlbumDaoTest {

    @Test
    public void getAlbumakByMusikariTest() {
    	
        Musikaria musikariTest = new Musikaria(1, "MusikariaTest");
        
        Date date = new Date();
        date.setYear(2011);
        date.setMonth(8);
        date.setDate(11);
        
        Album album = new Album(1, "BS - Singles","Rock", null, date);
        
        ArrayList<Album> albumak = AlbumDao.getAlbumakByMusikari(musikariTest);
 
        assertEquals(albumak.get(0),album);
    }
    
    @Test
    public void beteAlbumakKantaKopTest() {
    	Album albumTest = new Album(1, "AlbumTest");
    	ArrayList<Album> albumak = new ArrayList<Album>();
    	albumak.add(albumTest);  	
    	
        assertTrue(AlbumDao.beteAlbumakKantaKop(albumak));
    }
    
    @Test
    public void getAlbumByAbesti() {
    	Audio audioTest = new Audio();
    	audioTest.setIdAudio(1);	
    	Album albumTest = AlbumDao.getAlbumByAbesti(audioTest);
        assertEquals(albumTest.getId(), 1);
    }   
        
}