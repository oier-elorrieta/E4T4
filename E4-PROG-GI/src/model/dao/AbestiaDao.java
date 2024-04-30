package model.dao;

import java.sql.Connection;
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
	
/*	public static ArrayList<Abestia> getAbestiGustokoak() {
		ArrayList<Abestia> abestiakList = new ArrayList<Abestia>();
		Abestia abestia;

		int id = 0;

		Connection konexioa = Kone.konektatu();

		if (!SesioAldagaiak.erabiltzailePremium) {
			id = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			id = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}

		try {
			stm = konexioa.createStatement();
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
	
	public static void abestiGuztokoaEzabatu(int idAbestia) throws SQLException {

		int id = 0;
		if (!SesioAldagaiak.erabiltzailePremium) {
			id = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			id = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}

		Connection konexioa = Kone.konektatu();
		Statement stm =  konexioa.createStatement();
		kontsulta = "DELETE FROM Gustokoak WHERE IdBezeroa = " + id + " AND IdAudio = " + idAbestia;
		stm.executeUpdate(kontsulta);
		Kone.itxiConexioa();
	}
	
	public static boolean gustukoaKomprobatu(Audio abestia) throws SQLException {
		boolean gustokoaDu;
		int id = 0;

		if (!SesioAldagaiak.erabiltzailePremium) {
			id = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			id = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}
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
	public static void abestiGustokoaGehitu(Audio abestia) throws SQLException {
		int id = 0;

		if (!SesioAldagaiak.erabiltzailePremium) {
			id = SesioAldagaiak.erabiltzaileLogeatutaFree.getIdErabiltzailea();
		} else {
			id = SesioAldagaiak.erabiltzaileLogeatutaPremium.getIdErabiltzailea();
		}
		
		Connection konexioa = Kone.konektatu();
		Statement stm = konexioa.createStatement();
		kontsulta = "INSERT into Gustokoak(IdBezeroa, IdAudio) VALUES(?,?)";
		try {
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1, id);
			pstm.setInt(2, abestia.getIdAudio());
			pstm.execute();
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
		}
	}
	
}
