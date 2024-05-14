package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ErabiltzaileFree;
import model.SesioAldagaiak;
import model.sql.Kone;

public class ErabiltzaileFreeDao {
	
	public static void kargatuErabiltzaileFree(int id) {
		Connection konexioa = Kone.konektatu();
		try {
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM Bezeroa WHERE IdBezeroa = " + id;
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				SesioAldagaiak.logErabiltzailea = new ErabiltzaileFree(rs.getInt("IdBezeroa"),
						rs.getString("Erabiltzailea"), rs.getString("Pasahitza"), rs.getString("Izena"),
						rs.getString("Abizena"), rs.getDate("JaiotzeData"), rs.getString("IdHizkuntza"));
			}

		} catch (SQLException e) {
			e.getMessage();
		}
		Kone.itxiConexioa();
	}
}
