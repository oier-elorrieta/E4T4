package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Abestia;
import model.Album;
import model.Audio;
import model.sql.Kone;

/**
 * AbestiaDao klasea, Abestia entitatearekin erlazionatutako datu-basearen
 * eragiketak egiteko erabiltzen den DAO klasea da.
 */
public class AbestiaDao {
	/**
	 * Album baten arabera Abestiak lortzeko metodoa.
	 * 
	 * @param album Album objektua, Abestiak lortzeko erabiliko den albuma.
	 * @return Abestiak ArrayList-a, albumaren arabera lortutako Abestiak.
	 */
	public static ArrayList<Audio> getAbestiakByAlbum(Album album) {
		try {
			Connection konexioa = Kone.konektatu();
			ArrayList<Audio> abestiak = new ArrayList<Audio>();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM Abestia join Audio using(IdAudio) where IdAlbum = '" + album.getId()
					+ "'";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				abestiak.add(new Abestia(rs.getInt("IdAudio"), rs.getString("Izena"), rs.getTime("Iraupena"),
						rs.getBlob("Irudia"), false));
			}
			konexioa.close();
			return abestiak;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	public static boolean gehituAudioa(Abestia a) {

		boolean ondo = true;

		Connection konexioa = Kone.konektatuAdmin();
		String kontsulta = "Insert into Audio (Izena,Iraupena,Irudia) VALUES(?,?,from_base64(?))";
		try {
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1, a.getIzena());
			pstm.setTime(2, a.getIraupena());
			pstm.setString(3, a.getIrudiaString());
			pstm.execute();
			konexioa.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			ondo = false;
		}
		
		return ondo;
	}
	
	

	public static boolean gehituAbestia(Abestia a, int idAlbum) {

		gehituAudioa(a);
		int ida = bilatuIdAudioa(a.getIzena());
		
		boolean ondo = true;

		Connection konexioa = Kone.konektatuAdmin();
		String kontsulta = "CALL InsertatuAbestia(?,?)";
		try {
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1, ida);
			pstm.setInt(2, idAlbum);
			pstm.execute();
			konexioa.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			ondo = false;
		}

		return ondo;
	}

	public static int bilatuIdAudioa(String izena) {

		int i = 0;
		Connection konexioa = Kone.konektatuAdmin();
		String kontsulta = "SELECT IdAudio FROM Audio WHERE Izena = '"+izena+"'";
		try {
			Statement stm = konexioa.createStatement();
			ResultSet rs = stm.executeQuery(kontsulta);

			rs.next();

			i = rs.getInt("IdAudio");

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return i;
	}

	public static boolean ezabatuAbestia(Abestia a) {

		boolean ondo = true;

		Connection konexioa = Kone.konektatuAdmin();
		String kontsulta = "Delete from Audio where IdAudio = ?";
		try {
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1, a.getIdAudio());
			pstm.execute();
			konexioa.close();
		} catch (SQLException e) {

			ondo = false;
		}

		return ondo;
	}

}
