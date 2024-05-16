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
		
		Connection konexioa = Kone.konektatu();
		Statement stm = konexioa.createStatement();
		String kontsulta = "SELECT count(*) as zbk FROM EstatistikakAurkestuPodcasterraTotala";
		ResultSet rs = stm.executeQuery(kontsulta);
		rs.next();
		zenbatPodcaster = rs.getInt("zbk");
		konexioa.close();
		
		ArrayList<Podcasterra> podcasterrakTest = PodcasterraDao.getPodcasterEntzunaldiak();
		
		assertEquals(zenbatPodcaster, podcasterrakTest.size());
	}
	
	@Test
	public void getPodcasterraTest() throws SQLException {
		Podcasterra podcasterraTestarako = new Podcasterra(7, "Ibai Llanos", null, null);
		Podcasterra podcasterraTest = PodcasterraDao.getPodcasterra("Ibai Llanos");
		
		assertEquals(podcasterraTestarako.getIdArtista(), podcasterraTest.getIdArtista());
	}
}