package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ErabiltzaileFree;
import model.Erabiltzailea;
import model.SesioAldagaiak;
import model.sql.Kone;

public class ErabiltzaileaDao {
	
	
	public static boolean eguneratuErabiltzailea(Erabiltzailea erab) {
		try {
			Connection konexioa = Kone.konektatu();
			String kontsulta = "UPDATE Bezeroa"
					+ "	SET Izena = ?, Abizena = ?, Erabiltzailea = ?, Pasahitza = ?, JaiotzeData = ?, IdHizkuntza = ?"
					+ "	WHERE IdBezeroa = ?;";
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1, erab.getIzena());
			pstm.setString(2, erab.getAbizena());
			pstm.setString(3, erab.getErabiltzailea());
			pstm.setString(4, erab.getPasahitza());
			pstm.setDate(5, new java.sql.Date(erab.getJaiotzeData().getTime()));
			pstm.setString(6, erab.getHizkuntza());
			pstm.setInt(7, SesioAldagaiak.logErabiltzailea.getIdErabiltzailea());
			pstm.execute();
			Kone.itxiConexioa();
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
			return false;
		}
		return true;
	}
	
	public static Erabiltzailea isLoginaOk(String erabiltzailea) {
		Erabiltzailea erabiltzaileaSortu;
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT Erabiltzailea, Pasahitza, IdBezeroa, Mota FROM Bezeroa WHERE Erabiltzailea = '"
					+ erabiltzailea + "'";
			ResultSet rs = stm.executeQuery(kontsulta);
			rs.next();
			erabiltzaileaSortu = new Erabiltzailea(rs.getInt("IdBezeroa"), rs.getString("Erabiltzailea"), rs.getString("Pasahitza"));
			Kone.itxiConexioa();
			return erabiltzaileaSortu;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static String erabiltzaileMota(Erabiltzailea erabiltzailea) {
		String mota;
		Connection konexioa = Kone.konektatu();
		try {
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT Mota FROM Bezeroa WHERE IdBezeroa = " + erabiltzailea.getIdErabiltzailea();
			ResultSet rs = stm.executeQuery(kontsulta);
			rs.next();
			mota = rs.getString("Mota");
			return mota;
		} catch (SQLException e) {
			e.getMessage();
		}
		return null;
	}
	
	
}
