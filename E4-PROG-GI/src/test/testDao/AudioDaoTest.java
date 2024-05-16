package test.testDao;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.chrono.Era;
import java.util.ArrayList;

import org.junit.Test;

import model.Abestia;
import model.Audio;
import model.ErabiltzaileFree;
import model.PlayListak;
import model.SesioAldagaiak;
import model.dao.AudioDao;
import model.sql.Kone;

public class AudioDaoTest {

	@Test
	public void getAbestiakByPlayListTest() throws SQLException {
		
		Time time = new Time(0, 4, 8);    	
		Abestia audioTest = new Abestia(1, "Phoenix", time, null, false);
		
		PlayListak playlistTest = new PlayListak();
		playlistTest.setIdPlayList(1);

		ArrayList<Audio> audioakTest = AudioDao.getAbestiakByPlayList(playlistTest);
		System.out.println(audioakTest);
		assertEquals(audioTest, audioakTest.get(0));
	}

	@Test
	public void erregistratuErreprodukzioaTest() throws SQLException {
		Audio audioTest = new Audio();
    	audioTest.setIdAudio(1);
    	
    	ErabiltzaileFree ErabiltzaileFree = new ErabiltzaileFree(1, null, null, null, null, null, null);
    	SesioAldagaiak.logErabiltzailea = ErabiltzaileFree;
    	
    	assertTrue(AudioDao.erregistratuErreprodukzioa(audioTest));
	}
}