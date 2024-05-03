package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Audio;
import model.Musikaria;
import model.sql.Kone;


public class MusikariaDao {
	private static String kontsulta;
	private static Statement stm = null;
	private static PreparedStatement pstm;
	private static ResultSet rs;
	
	/**
	 * Entzunaldi guztiak itzultzen dituen metodoa.
	 * 
	 * @return Entzunaldi guztiak itzultzen dituen ResultSet objektua.
	 */
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
	
	/**
	 * Musikaria itzultzen duen metodoa.
	 * 
	 * @param izena Musikariaren izena.
	 * @return Eskatutako izenarekin bat datorren Musikaria objektua.
	 */
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
	
	public static Musikaria getMusikariaByAudio(Audio audio) {
		Musikaria musikaria = null;
		Connection konexioa = Kone.konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT ar.IzenArtistikoa, ar.Deskripzioa, ar.Irudia from Artista ar inner join Album al using (IdArtista) Inner join Abestia ab using (IdAlbum) inner join Audio au where au.IdAudio = " + audio.getIdAudio() + " and ab.IdAudio = " + audio.getIdAudio() + ";";
			rs = stm.executeQuery(kontsulta);
			rs.next();
			musikaria = new Musikaria(rs.getString("ar.IzenArtistikoa"),
					rs.getString("ar.Deskripzioa"), rs.getBlob("ar.Irudia"));
		} catch (SQLException e) {
			e.getMessage();

		}
		Kone.itxiConexioa();
		
		
		return musikaria;
	}
}
