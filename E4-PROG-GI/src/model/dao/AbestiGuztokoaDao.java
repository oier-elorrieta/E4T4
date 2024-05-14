package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Abestia;
import model.Audio;
import model.SesioAldagaiak;
import model.sql.Kone;

public class AbestiGuztokoaDao {
	public static ArrayList<Audio> getAbestiGustokoak() {
		ArrayList<Audio> abestiakList = new ArrayList<Audio>();
		Audio abestia;

		int id = 0;

		Connection konexioa = Kone.konektatu();

		id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		try {
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT a.IdAudio, a.Izena, a.Iraupena, a.Irudia FROM Gustokoak g join Audio a using (IdAudio) where IdBezeroa = "
					+ id;
			ResultSet rs = stm.executeQuery(kontsulta);
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
}
