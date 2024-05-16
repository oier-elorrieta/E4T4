package test.testDao;

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
	public void getPodcasterEntzunaldiakTest() throws SQLException {
		int zenbatPodcaster = 0;
				
		ArrayList<Podcasterra> podcasterrakTest = PodcasterraDao.getPodcasterEntzunaldiak();
		
		Podcasterra podcasterTest = new Podcasterra("Jordi Wild", null,0);
		
		assertEquals(podcasterrakTest.get(0), podcasterTest);
	}
	
	@Test
	public void getPodcasterraTest() throws SQLException {
		Podcasterra podcasterraTestarako = new Podcasterra(6, "Jordi Wild",
				"Bere YouTube kanala, El Rincón de Giorgio, 2013ko martxoan sortu zen eta gaur egun 11 milioi harpidedun baino gehiago ditu. Beste kanal bat ere badu, The Wild Project, bere podcastarena, eta 2022 eta 2023ko Esland sariak irabazi zituen. tertuliarik onena.​", null);
		Podcasterra podcasterraTest = PodcasterraDao.getPodcasterra("Jordi Wild");
		
		assertEquals(podcasterraTestarako, podcasterraTest);
	}
}