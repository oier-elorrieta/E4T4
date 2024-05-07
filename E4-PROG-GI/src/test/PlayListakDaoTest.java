package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
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
        assertEquals(1, result.size());
    }

    @Test
    public void testPlaylistGehitu() {
        PlayListakDao.playlistGehitu("Test Playlist");
        // Assert that the playlist has been added successfully
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
        // Add a test playlist
        PlayListakDao.playlistGehitu("Test Playlist");
        // Get the id of the test playlist
        ArrayList<PlayListak> playlists = PlayListakDao.getPlaylist();
        int id = 0;
        for (PlayListak playlist : playlists) {
            if (playlist.getIzena().equals("Test Playlist")) {
                id = playlist.getIdPlayList();
                break;
            }
        }
        // Delete the test playlist
        PlayListakDao.playlistEzabatu(id);
        // Assert that the playlist has been deleted successfully
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
        // Add a test playlist
        PlayListakDao.playlistGehitu("Test Playlist");
        // Get the id of the test playlist
        ArrayList<PlayListak> playlists = PlayListakDao.getPlaylist();
        int playlistId = 0;
        for (PlayListak playlist : playlists) {
            if (playlist.getIzena().equals("Test Playlist")) {
                playlistId = playlist.getIdPlayList();
                break;
            }
        }
        // Add a test audio to the playlist
        Audio testAudio = new Audio(1, "Test Audio", null, null, false);
        PlayListakDao.playlisteanAbestiaGehitu(new PlayListak(playlistId, "Test Playlist", null), testAudio);
        // Delete the test audio from the playlist
        PlayListakDao.abestiPlaylistEzabatu(playlistId, testAudio.getIdAudio());
        // Assert that the audio has been deleted successfully from the playlist
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
        assertEquals(0, result.size());
    }

    @Test
    public void testPlaylisteanAbestiaGehitu() {
        // Add a test playlist
        PlayListakDao.playlistGehitu("Test Playlist");
        // Get the id of the test playlist
        ArrayList<PlayListak> playlists = PlayListakDao.getPlaylist();
        int playlistId = 0;
        for (PlayListak playlist : playlists) {
            if (playlist.getIzena().equals("Test Playlist")) {
                playlistId = playlist.getIdPlayList();
                break;
            }
        }
        // Add a test audio to the playlist
        Audio testAudio = new Audio(1, "Test Audio", null, null, false);
        PlayListakDao.playlisteanAbestiaGehitu(new PlayListak(playlistId, "Test Playlist", null), testAudio);
        // Assert that the audio has been added successfully to the playlist
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
        // Add a test playlist
        PlayListakDao.playlistGehitu("Test Playlist");
        // Get the id of the test playlist
        ArrayList<PlayListak> playlists = PlayListakDao.getPlaylist();
        int playlistId = 0;
        for (PlayListak playlist : playlists) {
            if (playlist.getIzena().equals("Test Playlist")) {
                playlistId = playlist.getIdPlayList();
                break;
            }
        }
        // Add a test audio to the playlist
        Audio testAudio = new Audio(1, "Test Audio", null, null, false);
        PlayListakDao.playlisteanAbestiaGehitu(new PlayListak(playlistId, "Test Playlist", null), testAudio);
        // Assert that the audio exists in the playlist
        boolean result = PlayListakDao.komprobatuAbestiaBadago(new PlayListak(playlistId, "Test Playlist", null), testAudio);
        assertTrue(result);
    }

    @Test
    public void testGetPlayListIzenarekin() {
        int result = PlayListakDao.getPlayListIzenarekin("Gustokoena");
        assertEquals(0, result);
    }

}