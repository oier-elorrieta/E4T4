package test.testDao;
import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Abestia;
import model.Album;
import model.Audio;
import model.ErabiltzaileFree;
import model.ErabiltzailePremium;
import model.Erabiltzailea;
import model.SesioAldagaiak;
import model.dao.AbestiaDao;
import model.sql.Kone;

public class AbestiaDaoTest {
	
    @Test
    public void getAbestiakByAlbumTest() {
    	ArrayList<Audio> abestiakTest = null;
    	Album albumTest = new Album(1, "AlbumTest");
    	int zenbatAbestiTest = 0;
  
    	try {
			Connection konexioa = Kone.konektatu();
			ArrayList<Audio> abestiak = new ArrayList<Audio>();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT count(*) as zbk FROM Abestia join Audio using(IdAudio) where IdAlbum = 1";
			ResultSet rs = stm.executeQuery(kontsulta);
			rs.next();
			zenbatAbestiTest = rs.getInt("zbk");
			konexioa.close();
		} catch (SQLException e) {
			e.getMessage();
		}
    	abestiakTest = AbestiaDao.getAbestiakByAlbum(albumTest);
    	
    	assertEquals(zenbatAbestiTest, abestiakTest.size());
    }

}