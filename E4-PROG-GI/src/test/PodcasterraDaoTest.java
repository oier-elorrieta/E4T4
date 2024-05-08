package test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import model.Podcasterra;
import model.dao.PodcasterraDao;
import model.sql.Kone;

public class PodcasterraDaoTest {

	@Test
	public void getPodcasterraTest() {
		Podcasterra podcasterTest = null;
		podcasterTest = PodcasterraDao.getPodcasterra("Ibai Llanos");
		assertEquals(podcasterTest.getIdArtista(), 4);
	}
}