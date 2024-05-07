package test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import org.junit.Test;

import model.Abestia;
import model.Audio;
import model.PlayListak;
import model.SesioAldagaiak;
import model.dao.AudioDao;

public class AudioDaoTest {

    @Test
    public void testGetPlayListAbestiak() throws SQLException {
        PlayListak aukeraPlaylist = new PlayListak();
        aukeraPlaylist.setIdPlayList(1);
        
        ArrayList<Audio> result = AudioDao.getPlayListAbestiak(aukeraPlaylist);
        
        assertEquals(2, result.size());
    }
}