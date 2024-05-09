package test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import org.junit.Test;

import model.Audio;
import model.PlayListak;
import model.dao.PlayListakDao;

public class PlayListakDaoTest {

    @Test
    public void testGetPlaylist() {
        ArrayList<PlayListak> result = PlayListakDao.getPlaylist();
        assertNotNull(result);
    }

    @Test
    public void testPlaylistGehitu() {
        PlayListakDao.playlistGehitu("Test Playlist");
        ArrayList<PlayListak> playlists = PlayListakDao.getPlaylist();
        boolean found = false;
        for (PlayListak playlist : playlists) {
            if (playlist.getIzena().equals("Test Playlist")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testPlaylistEzabatu() throws SQLException {
      
        PlayListakDao.playlistGehitu("Test Playlist");
       
        ArrayList<PlayListak> playlists = PlayListakDao.getPlaylist();
        int id = 0;
        for (PlayListak playlist : playlists) {
            if (playlist.getIzena().equals("Test Playlist")) {
                id = playlist.getIdPlayList();
                break;
            }
        }
       
        PlayListakDao.playlistEzabatu(id);
     
        playlists = PlayListakDao.getPlaylist();
        boolean found = false;
        for (PlayListak playlist : playlists) {
            if (playlist.getIdPlayList() == id) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }

    @Test
    public void testAbestiPlaylistEzabatu() throws SQLException {
        
        PlayListakDao.playlistGehitu("Test Playlist");
      
        ArrayList<PlayListak> playlists = PlayListakDao.getPlaylist();
        int playlistId = 0;
        for (PlayListak playlist : playlists) {
            if (playlist.getIzena().equals("Test Playlist")) {
                playlistId = playlist.getIdPlayList();
                break;
            }
        }
     
        int idAudio = 1;
        String izena = "Test Audio";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;

        Audio testAudio = new Audio(idAudio, izena, iraupena, irudia);
        PlayListakDao.playlisteanAbestiaGehitu(new PlayListak(playlistId, "Test Playlist", null), testAudio);
        
        PlayListakDao.abestiPlaylistEzabatu(playlistId, testAudio.getIdAudio());
        
        ArrayList<Audio> playlistAudios = PlayListakDao.getPlayListAbestiak(new PlayListak(playlistId, "Test Playlist", null));
        boolean found = false;
        for (Audio audio : playlistAudios) {
            if (audio.getIdAudio() == testAudio.getIdAudio()) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }

    @Test
    public void testGetPlayListAbestiak() {
        ArrayList<Audio> result = PlayListakDao.getPlayListAbestiak(new PlayListak(0, "Gustokoena", null));
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testPlaylisteanAbestiaGehitu() {
       
        PlayListakDao.playlistGehitu("Test Playlist");
   
        ArrayList<PlayListak> playlists = PlayListakDao.getPlaylist();
        int playlistId = 0;
        for (PlayListak playlist : playlists) {
            if (playlist.getIzena().equals("Test Playlist")) {
                playlistId = playlist.getIdPlayList();
                break;
            }
        }
        
        int idAudio = 1;
        String izena = "Test Audio";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;

        Audio testAudio = new Audio(idAudio, izena, iraupena, irudia);
        PlayListakDao.playlisteanAbestiaGehitu(new PlayListak(playlistId, "Test Playlist", null), testAudio);
       
        ArrayList<Audio> playlistAudios = PlayListakDao.getPlayListAbestiak(new PlayListak(playlistId, "Test Playlist", null));
        boolean found = false;
        for (Audio audio : playlistAudios) {
            if (audio.getIdAudio() == testAudio.getIdAudio()) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testKomprobatuAbestiaBadago() {
      
        PlayListakDao.playlistGehitu("Test Playlist");
      
        ArrayList<PlayListak> playlists = PlayListakDao.getPlaylist();
        int playlistId = 0;
        for (PlayListak playlist : playlists) {
            if (playlist.getIzena().equals("Test Playlist")) {
                playlistId = playlist.getIdPlayList();
                break;
            }
        }
        
        int idAudio = 1;
        String izena = "Test Audio";
        Time iraupena = new Time(0, 3, 30);
        Blob irudia = null;

        Audio testAudio = new Audio(idAudio, izena, iraupena, irudia);
        PlayListakDao.playlisteanAbestiaGehitu(new PlayListak(playlistId, "Test Playlist", null), testAudio);
       
        boolean result = PlayListakDao.komprobatuAbestiaBadago(new PlayListak(playlistId, "Test Playlist", null), testAudio);
        assertTrue(result);
    }

    @Test
    public void testGetPlayListIzenarekin() {
        int result = PlayListakDao.getPlayListIzenarekin("Gustokoena");
        assertEquals(0, result);
    }

}