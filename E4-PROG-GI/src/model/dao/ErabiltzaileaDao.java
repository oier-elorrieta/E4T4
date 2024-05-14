package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ErabiltzaileFree;
import model.Erabiltzailea;
import model.SesioAldagaiak;
import model.sql.Kone;

public class ErabiltzaileaDao {
	public static boolean erregistratu(ErabiltzaileFree erab) {
		try {
			Connection konexioa = Kone.konektatu();
			String kontsulta = "INSERT into Bezeroa(Izena,Abizena,Erabiltzailea,Pasahitza,JaiotzeData,IdHizkuntza) VALUES(?,?,?,?,?,?)";
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1, erab.getIzena());
			pstm.setString(2, erab.getAbizena());
			pstm.setString(3, erab.getErabiltzailea());
			pstm.setString(4, erab.getPasahitza());
			pstm.setDate(5, (java.sql.Date) erab.getJaiotzeData());
			pstm.setString(6, erab.getHizkuntza());
			pstm.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
			return false;
		}

	}
	
	public static void eguneratuErabiltzailea(Erabiltzailea erab) {
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
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
		}
		Kone.itxiConexioa();
	}
}
