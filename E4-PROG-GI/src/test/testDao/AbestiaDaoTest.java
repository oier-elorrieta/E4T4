package test.testDao;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.ArrayList;

import org.junit.Test;

import model.Abestia;
import model.Album;
import model.Audio;
import model.dao.AbestiaDao;

public class AbestiaDaoTest {

	@Test
	public void getAbestiakByAlbumTest() {
		Album albumTest = new Album(1, "AlbumTest");
		Time time = new Time(0, 4, 8);
		Abestia abestiaTest = new Abestia(1, "Phoenix", time, null, false);
		ArrayList<Audio> abestiakTest = AbestiaDao.getAbestiakByAlbum(albumTest);
		assertEquals(abestiaTest, abestiakTest.get(0));
	}

}