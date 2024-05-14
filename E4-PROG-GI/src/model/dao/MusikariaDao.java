package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Audio;
import model.Musikaria;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;


/**
 * MusikariaDao klasea datu-basearekin komunikatzeko erabiltzen den DAO klasea da.
 */
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
	public static ArrayList<Musikaria> getMusikariakEntzunaldiak() {
		ArrayList<Musikaria> musikariak = new ArrayList<Musikaria>();
		Musikaria musikariaSartu;
		Connection konexioa = Kone.konektatu();
		try {
			stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstatistikakAurkestuMusikariaTotala";
			rs = stm.executeQuery(kontsulta);
			while(rs.next()) {
			musikariaSartu = new Musikaria(rs.getString("Izena"), rs.getBlob("Irudia"), rs.getInt("Totala"));
			musikariak.add(musikariaSartu);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return musikariak;
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
	
	/**
	 * Audio baten arabera Musikaria itzultzen duen metodoa.
	 * 
	 * @param audio Audio objektua.
	 * @return Audioaren arabera Musikaria objektua.
	 */
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
	
	/**
	 * Musikaria gehitzeko metodoa.
	 * 
	 * @param musikari Gehitu nahi den Musikaria objektua.
	 * @return Musikaria gehitzea ondo egin den ala ez adierazten duen boolean balioa.
	 */
	public static boolean gehituMusikaria(Musikaria musikari) {
		boolean ondo = true;
		
		Connection konexioa = Kone.konektatu();
		kontsulta = "CALL InsertatuMusikaria(?,?,?,?)";
		try {
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1,musikari.getIzena());
			pstm.setString(2,musikari.getIrudiaString());
			pstm.setString(3,musikari.getDeskription());
			pstm.setString(4,musikari.getEzaugarria());
			pstm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			ondo =  false;
		}
		
		return ondo;
	}
}
