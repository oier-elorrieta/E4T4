package test.testDao;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Abestia;
import model.Album;
import model.Audio;
import model.ErabiltzaileFree;
import model.ErabiltzailePremium;
import model.Erabiltzailea;
import model.SesioAldagaiak;
import model.dao.AbestiaDao;
import model.sql.Kone;

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