package test.testDao;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import model.Audio;
import model.Musikaria;
import model.dao.MusikariaDao;
import model.sql.Kone;

public class MusikariaDaoTest {

    @Test
    public void getMusikariakEntzunaldiakTest() throws SQLException {
    	int zenbatMusikariTest = 0;
    	
    	Connection konexioa = Kone.konektatu();
		Statement stm = konexioa.createStatement();
		String kontsulta = "SELECT count(*) as zbk FROM EstatistikakAurkestuMusikariaTotala";
		ResultSet rs = stm.executeQuery(kontsulta);
		rs.next();
		zenbatMusikariTest = rs.getInt("zbk");
		konexioa.close();
		
		ArrayList<Musikaria> musikariakTest = MusikariaDao.getMusikariakEntzunaldiak();
		
		assertEquals(zenbatMusikariTest, musikariakTest.size());
    }
    
    @Test
    public void getMusikariaTest() throws SQLException {
    	String  izenaMusikari = "Burnout Syndromes";
    	
    	
    	Connection konexioa = Kone.konektatu();
		Statement stm = konexioa.createStatement();
		String kontsulta = "SELECT * FROM Musikaria m INNER JOIN Artista a on m.IdArtista = a.IdArtista WHERE IzenArtistikoa='"+izenaMusikari+"'";
		ResultSet rs = stm.executeQuery(kontsulta);
		rs.next();
		Musikaria musikariaTestarako = new Musikaria(rs.getInt("a.IdArtista"), rs.getString("a.IzenArtistikoa"));
		konexioa.close();
		
		
		Musikaria musikariaTest = MusikariaDao.getMusikaria(izenaMusikari);
		
		assertEquals(musikariaTestarako.getIdArtista(), musikariaTest.getIdArtista());
    }
    
    
    
}