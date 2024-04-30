package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Musikaria;
import model.sql.Kone;


public class MusikariaDao {
	private static String kontsulta;
	private static Statement stm = null;
	private static PreparedStatement pstm;
	private static ResultSet rs;
	
	public static ResultSet getMusikariakEntzunaldiak() {
		Connection konexioa = Kone.konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstatistikakAurkestuMusikariaTotala";
			rs = stm.executeQuery(kontsulta);
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return rs;

	}
	
	public static Musikaria getMusikaria(String izena) {

		Connection konexioa = Kone.konektatu();
		Musikaria musikari = null;

		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM Musikaria m INNER JOIN Artista a on m.IdArtista = a.IdArtista WHERE IzenArtistikoa='"
					+ izena + "'";
			rs = stm.executeQuery(kontsulta);
			rs.next();
			musikari = new Musikaria(rs.getInt("a.IdArtista"), rs.getString("a.IzenArtistikoa"),
					rs.getString("a.Deskripzioa"), rs.getBlob("a.Irudia"), rs.getString("m.Ezaugarria"));
		} catch (SQLException e) {
			e.getMessage();

		}
		return musikari;

	}
}
