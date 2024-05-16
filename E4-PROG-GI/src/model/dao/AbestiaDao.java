package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Abestia;
import model.Album;
import model.Audio;
import model.SesioAldagaiak;
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
}
