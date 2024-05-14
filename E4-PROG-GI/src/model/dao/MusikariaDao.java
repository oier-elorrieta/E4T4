package model.dao;
import java.sql.Blob;
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
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM EstatistikakAurkestuMusikariaTotala";
			ResultSet rs = stm.executeQuery(kontsulta);
			while(rs.next()) {
			musikariaSartu = new Musikaria(rs.getString("Izena"), rs.getBlob("Irudia"), rs.getInt("Totala"));
			musikariak.add(musikariaSartu);
			}
			konexioa.close();
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
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM Musikaria m INNER JOIN Artista a on m.IdArtista = a.IdArtista WHERE IzenArtistikoa='"
					+ izena + "'";
			ResultSet rs = stm.executeQuery(kontsulta);
			rs.next();
			musikari = new Musikaria(rs.getInt("a.IdArtista"), rs.getString("a.IzenArtistikoa"),
					rs.getString("a.Deskripzioa"), rs.getBlob("a.Irudia"), rs.getString("m.Ezaugarria"));
			konexioa.close();
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
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT ar.IzenArtistikoa, ar.Deskripzioa, ar.Irudia from Artista ar inner join Album al using (IdArtista) Inner join Abestia ab using (IdAlbum) inner join Audio au where au.IdAudio = " + audio.getIdAudio() + " and ab.IdAudio = " + audio.getIdAudio() + ";";
			ResultSet rs = stm.executeQuery(kontsulta);
			rs.next();
			musikaria = new Musikaria(rs.getString("ar.IzenArtistikoa"),
					rs.getString("ar.Deskripzioa"), rs.getBlob("ar.Irudia"));
			konexioa.close();
		} catch (SQLException e) {
			e.getMessage();

		}
		
		
		
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
		String kontsulta = "CALL InsertatuMusikaria(?,?,?,?)";
		try {
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1,musikari.getIzena());
			pstm.setString(2,musikari.getIrudiaString());
			pstm.setString(3,musikari.getDeskription());
			pstm.setString(4,musikari.getEzaugarria());
			pstm.execute();
			konexioa.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			ondo =  false;
		}
		
		return ondo;
	}

	
	public static ArrayList<Musikaria> getMusikariak() {
		ArrayList<Musikaria> musikariak = new ArrayList<Musikaria>();
		Musikaria musikari;
		Connection konexioa = Kone.konektatu();
		try {
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM Artista JOIN Musikaria using (IdArtista)";
			ResultSet rs = stm.executeQuery(kontsulta);
			while(rs.next()) {
			musikari = new Musikaria(rs.getInt("IdArtista"),rs.getString("IzenArtistikoa"),rs.getString("Deskripzioa"),rs.getBlob("Irudia"),rs.getString("ezaugarria"));
			musikariak.add(musikari);

			
			}
			konexioa.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return musikariak;
	}
	
	public static boolean ezabatuMusikaria(String izena) {
		Connection konexioa = Kone.konektatu();
		try {
			String kontsulta = "DELETE FROM Artista WHERE IzenArtistikoa = '" + izena + "'";
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.execute();
			konexioa.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public static boolean aldatuMusikaria(Musikaria musikari) {
		boolean ondo = true;
		
		Connection konexioa = Kone.konektatu();
		String kontsulta = "Call AldatuMusikaria(?,?,?,?,?)";
		try {
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1,musikari.getIdArtista());
			pstm.setString(2,musikari.getIzena());
			pstm.setString(3,musikari.getIrudiaString());
			pstm.setString(4,musikari.getDeskription());
			pstm.setString(5,musikari.getEzaugarria());
			pstm.execute();
			konexioa.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			ondo =  false;
		}
		
		return ondo;
	}
	
	
	
	
	

}
