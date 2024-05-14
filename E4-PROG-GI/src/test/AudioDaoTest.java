package test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import org.junit.Test;

import model.Abestia;
import model.Audio;
import model.ErabiltzaileFree;
import model.PlayListak;
import model.SesioAldagaiak;
import model.dao.AudioDao;

public class AudioDaoTest {

    @Test
    public void testGetPlayListAbestiak() throws SQLException {
        PlayListak aukeraPlaylist = new PlayListak();
        aukeraPlaylist.setIdPlayList(1);
        
        ErabiltzaileFree erabiltzailea = new ErabiltzaileFree(1, "eka", "bla", "Ekaitz", "Blanca", new java.sql.Date(1984-02-22), "es");
    	SesioAldagaiak.erabiltzaileLogeatutaFree = erabiltzailea;
        ArrayList<Audio> result = AudioDao.getAbestiakByPlayList(aukeraPlaylist);
        
        assertEquals(0, result.size());
    }
}