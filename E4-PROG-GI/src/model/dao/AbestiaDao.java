package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Abestia;
import model.Audio;
import model.SesioAldagaiak;
import model.sql.Kone;


public class AbestiaDao {
	private static String kontsulta;
	
	private static PreparedStatement pstm;
	private static ResultSet rs;
	
	public static ArrayList<Audio> getAbestiakByAlbum(int idAlbum) {
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Audio> abestiak = new ArrayList<Audio>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM Abestia join Audio using(IdAudio) where IdAlbum = '" + idAlbum + "'";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				abestiak.add(new Abestia(rs.getInt("IdAudio"), rs.getString("Izena"), rs.getTime("Iraupena"),
						rs.getBlob("Irudia"), false));
			}
			return abestiak;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	
	
	public static void abestiGustokoaGehitu(Audio audio) throws SQLException {
		int id = 0;

		id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		
		Connection konexioa = Kone.konektatu();
		Statement stm = konexioa.createStatement();
		kontsulta = "INSERT into Gustokoak(IdBezeroa, IdAudio) VALUES(?,?)";
		try {
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1, id);
			pstm.setInt(2, audio.getIdAudio());
			pstm.execute();
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
		}
	}
	
	public static void abestiGuztokoaEzabatu(int idAbestia) throws SQLException {
		int id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		Connection konexioa = Kone.konektatu();
		Statement stm =  konexioa.createStatement();
		kontsulta = "DELETE FROM Gustokoak WHERE IdBezeroa = " + id + " AND IdAudio = " + idAbestia;
		stm.executeUpdate(kontsulta);
		Kone.itxiConexioa();
	}
	
	/**
	 * Abestia gustukoa den ala ez konprobatzen du.
	 * 
	 * @param abestia Konprobatu nahi den abestia.
	 * @return Abestia gustukoa den ala ez.
	 * @throws SQLException
	 */
	public static boolean abestiGuztokoaKonprobatu(Audio abestia) throws SQLException {
		boolean gustokoaDu;
		int id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		Connection konexioa = Kone.konektatu();
		Statement stm = konexioa.createStatement();
		kontsulta = "SELECT count(IdAudio) as cont from Gustokoak where IdBezeroa = " + id + " and IdAudio = "
				+ abestia.getIdAudio() + ";";
		rs = stm.executeQuery(kontsulta);
		rs.next();

		if (rs.getInt("cont") == 0) {
			gustokoaDu = false;
		} else {
			gustokoaDu = true;
		}
		Kone.itxiConexioa();

		return gustokoaDu;
	}
		
}
