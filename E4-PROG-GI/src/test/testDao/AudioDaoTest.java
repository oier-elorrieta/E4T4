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
		PlayListak playlistTest = new PlayListak();
		playlistTest.setIdPlayList(1);
		int zenbatAbestiPlaylisteanTest = 0;

		Connection konexioa = Kone.konektatu();
		Statement stm = konexioa.createStatement();
		String kontsulta = "SELECT count(*) as zbk FROM PlaylistAbestiak pla INNER JOIN Audio au on pla.IdAudio = au.IdAudio where IdList = 1";
		ResultSet rs = stm.executeQuery(kontsulta);
		rs.next();
		zenbatAbestiPlaylisteanTest = rs.getInt("zbk");
		konexioa.close();

		ArrayList<Audio> audioakTest = AudioDao.getAbestiakByPlayList(playlistTest);
		assertEquals(zenbatAbestiPlaylisteanTest, audioakTest.size());
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