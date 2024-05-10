package test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Test;

import model.Audio;
import model.ErabiltzaileFree;
import model.PlayListak;
import model.SesioAldagaiak;
import model.dao.PlayListakDao;
import model.sql.Kone;

public class PlayListakDaoTest {

    @Test
    public void getPlaylistTest() {
    	SesioAldagaiak.erabiltzailePremium = false;
    	SesioAldagaiak.erabiltzaileLogeatutaFree = new ErabiltzaileFree(1, null, null, null, null, null, null);
        ArrayList<PlayListak> result = PlayListakDao.getPlaylist();
        assertNotNull(result);
    }

    
    @Test
    public void playlistGehituEzabatuTest() throws SQLException {
    	SesioAldagaiak.erabiltzailePremium = false;
    	SesioAldagaiak.erabiltzaileLogeatutaFree = new ErabiltzaileFree(1, null, null, null, null, null, null);
    	PlayListakDao.playlistGehitu("Testa");
    	PlayListakDao.getPlayListIzenarekin("Testa");
    	assertNotEquals(PlayListakDao.getPlayListIzenarekin("Testa"), 0);
    }
    
    @Test
    public void playlisteanAbestiaGehituTest() throws SQLException {
    	PlayListakDao.playlistGehitu("Testa1");
    	PlayListak playlistTest = PlayListakDao.getPlayListIzenarekin("Testa1");
    	Audio audioTest = new Audio();
    	audioTest.setIdAudio(1);
    	PlayListakDao.playlisteanAbestiaGehitu(playlistTest, audioTest);
    	boolean sartuta = PlayListakDao.komprobatuAbestiaBadago(playlistTest, audioTest);
    	assertTrue(sartuta);
    	PlayListakDao.abestiPlaylistEzabatu(playlistTest.getIdPlayList(), audioTest.getIdAudio());
    	sartuta = PlayListakDao.komprobatuAbestiaBadago(playlistTest, audioTest);
    	assertFalse(sartuta);
    }
    
    @Test
    public void getAbestiPlayListTest() throws SQLException {
    	PlayListakDao.playlistGehitu("Testa2");
    	PlayListak playlistTest = PlayListakDao.getPlayListIzenarekin("Testa2");
    	Audio audioTest = new Audio();
    	audioTest.setIdAudio(1);
    	PlayListakDao.playlisteanAbestiaGehitu(playlistTest, audioTest);
    	ArrayList<Audio> audioak = PlayListakDao.getPlayListAbestiak(playlistTest);
    	assertEquals(audioak.size(), 1);
    }
    
    @AfterClass
    public static void delete() throws SQLException {
    	PlayListak playlistTest = PlayListakDao.getPlayListIzenarekin("Testa");
    	PlayListakDao.playlistEzabatu(playlistTest.getIdPlayList());
    	PlayListak playlistTest1 = PlayListakDao.getPlayListIzenarekin("Testa1");
    	PlayListakDao.playlistEzabatu(playlistTest1.getIdPlayList());
    	PlayListak playlistTest2 = PlayListakDao.getPlayListIzenarekin("Testa2");
    	PlayListakDao.playlistEzabatu(playlistTest2.getIdPlayList());
    }
    

}