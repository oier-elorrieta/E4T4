package test.testDao;

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
}