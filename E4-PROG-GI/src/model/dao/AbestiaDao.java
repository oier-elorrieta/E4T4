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
	
	/**
	 * Erabiltzailearen gustoko abestiak itzultzen ditu.
	 * 
	 * @return Abestiak ArrayList moduan itzultzen ditu.
	 */
	public static ArrayList<Abestia> getAbestiGustokoak() {
		ArrayList<Abestia> abestiakList = new ArrayList<Abestia>();
		Abestia abestia;

		int id = 0;

		Connection konexioa = Kone.konektatu();
/*
		if (!SesioAldagaiak.erabiltzailePremium) {
			id = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			id = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}
*/
		id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		try {
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT a.IdAudio, a.Izena, a.Iraupena, a.Irudia FROM Gustokoak g join Audio a using (IdAudio) where IdBezeroa = "
					+ id;
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				Abestia abestiaSartu = new Abestia(rs.getInt("a.IdAudio"), rs.getString("a.izena"),
						rs.getTime("a.Iraupena"), rs.getBlob("a.Irudia"), true);
				abestiakList.add(abestiaSartu);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		Kone.itxiConexioa();
		return abestiakList;
	}
	
	/**
	 * Album baten abestiak itzultzen ditu.
	 * 
	 * @param idAlbum Albumaren identifikadorea.
	 * @return Abestiak ArrayList moduan itzultzen ditu.
	 */
	public static ArrayList<Audio> getAbestiak(int idAlbum) {
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
	
	/**
	 * Abestia gustukoa ezabatzen du.
	 * 
	 * @param idAbestia Abestiaren identifikadorea.
	 * @throws SQLException
	 */
	public static void abestiGuztokoaEzabatu(int idAbestia) throws SQLException {

		int id = 0;
		/*
		if (!SesioAldagaiak.erabiltzailePremium) {
			id = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			id = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}*/
		
		id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();

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
	public static boolean gustukoaKomprobatu(Audio abestia) throws SQLException {
		boolean gustokoaDu;
		int id = 0;
/*
		if (!SesioAldagaiak.erabiltzailePremium) {
			id = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			id = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}*/
		id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
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
	
	/**
	 * Abestia gustukoa gisa gehitzen du.
	 * 
	 * @param abestia Gehitu nahi den abestia.
	 * @throws SQLException
	 */
	public static void abestiGustokoaGehitu(Audio audio) throws SQLException {
		int id = 0;
/*
		if (!SesioAldagaiak.erabiltzailePremium) {
			id = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			id = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}
		*/
		
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
	
	
	/*
	public static boolean areGaurkoEntzunaldiak(int idAudio) {
		
		boolean badago = false;
		try {
		Connection konexioa = Kone.konektatu();
		Statement stm = konexioa.createStatement();
		kontsulta = "SELECT * FROM EstadistikakEgunean WHERE IdAudio = "+idAudio falta da data;
		ResultSet rs = stm.executeQuery(kontsulta);
		
		if(rs.next()) {
			badago = true;
		}
		
		}catch(SQLException e) {
			e.getMessage();
		}
		return badago;
	}
		*/

	public static void erregistratuErreprodukzioa(Audio audio) {
		
		int idBezero;
		/*
		if (!SesioAldagaiak.erabiltzailePremium) {
			idBezero = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			idBezero = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}
		*/
		
		idBezero = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		try {
		Connection konexioa = Kone.konektatu();
			kontsulta = "INSERT into Erreprodukzioak (IdBezeroa, IdAudio, ErreData) VALUES(?,?,?)";
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1, idBezero);
			pstm.setInt(2, audio.getIdAudio());
			pstm.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
			pstm.execute();
		
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
		}
	}
	
	

}
