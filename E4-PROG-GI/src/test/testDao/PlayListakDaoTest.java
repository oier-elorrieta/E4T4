package test.testDao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Audio;
import model.ErabiltzaileFree;
import model.PlayListak;
import model.SesioAldagaiak;
import model.dao.PlayListakDao;

public class PlayListakDaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ErabiltzaileFree erabiltzaileTest = new ErabiltzaileFree(1, null, null, null, null, null, null);
		SesioAldagaiak.logErabiltzailea = erabiltzaileTest;
		PlayListakDao.playlistGehitu("playListEzabatzekoTest");
		PlayListakDao.playlistGehitu("playListAbestientzakoTest");

		PlayListak playListTest = PlayListakDao.getPlayListIzenarekin("PlaylistProba");
		Audio audioTest = new Audio();
		audioTest.setIdAudio(2);
		PlayListakDao.playlisteanAbestiaGehitu(playListTest, audioTest);
		
	}

	@Test
	public void getPlaylistTest() throws SQLException {
		ErabiltzaileFree erabiltzaileTest = new ErabiltzaileFree(1, null, null, null, null, null, null);
		SesioAldagaiak.logErabiltzailea = erabiltzaileTest;

		ArrayList<PlayListak> playlistList = PlayListakDao.getPlaylist();
		PlayListak playlist = new PlayListak(1, "PlaylistProba", null);

		assertEquals(playlist, playlistList.get(1));
	}

	@Test
	public void playlistGehituTest() throws SQLException {
		ErabiltzaileFree erabiltzaileTest = new ErabiltzaileFree(1, null, null, null, null, null, null);
		SesioAldagaiak.logErabiltzailea = erabiltzaileTest;
		boolean test;

		test = PlayListakDao.playlistGehitu("playListTest");

		assertTrue(test);
	}

	@Test
	public void playlistEzabatuTest() throws SQLException {
		boolean test;

		PlayListak playlistTest = PlayListakDao.getPlayListIzenarekin("playListEzabatzekoTest");
		test = PlayListakDao.playlistEzabatu(playlistTest.getIdPlayList());

		assertTrue(test);
	}

	@Test
	public void playlisteanAbestiaGehituTest() throws SQLException {
		boolean test;
		PlayListak playListTest = PlayListakDao.getPlayListIzenarekin("PlaylistProba");
		Audio audioTest = new Audio();
		audioTest.setIdAudio(3);

		test = PlayListakDao.playlisteanAbestiaGehitu(playListTest, audioTest);

		assertTrue(test);
	}

	@Test
	public void abestiPlaylistEzabatuTest() throws SQLException {
		boolean test;
		PlayListak playListTest = PlayListakDao.getPlayListIzenarekin("PlaylistProba");

		test = PlayListakDao.abestiPlaylistEzabatu(playListTest.getIdPlayList(), 2);

		assertTrue(test);
	}

}