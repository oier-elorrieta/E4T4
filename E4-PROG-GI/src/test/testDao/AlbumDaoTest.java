package test.testDao;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import model.Album;
import model.Audio;
import model.Musikaria;
import model.dao.AlbumDao;
import model.dao.MusikariaDao;
import model.sql.Kone;
import test.AlbumTest;

public class AlbumDaoTest {

    @Test
    public void getAlbumakByMusikariTest() {
    	ArrayList<Album> albumak = null;
        Musikaria musikariTest = new Musikaria(1, "MusikariaTest");
        int zenbatAlbumTest = 0;
        
        try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT count(*) as zbk FROM Album where IdArtista = 1";
			ResultSet rs = stm.executeQuery(kontsulta);
			rs.next();
			zenbatAlbumTest = rs.getInt("zbk");
			konexioa.close();
		} catch (SQLException e) {
			e.getMessage();
		}
        albumak = AlbumDao.getAlbumakByMusikari(musikariTest);
        
        assertEquals(zenbatAlbumTest, albumak.size());
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