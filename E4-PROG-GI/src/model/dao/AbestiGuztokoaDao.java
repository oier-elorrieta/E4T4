package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.AbestiGuztokoa;
import model.Abestia;
import model.Audio;
import model.SesioAldagaiak;
import model.sql.Kone;

public class AbestiGuztokoaDao {
	/**
	 * Abesti gustokoak jasotzeko metodoa.
	 * 
	 * @return abesti gustokoak ArrayList bat
	 */
	public static ArrayList<Audio> getAbestiGustokoak() {
		int id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		ArrayList<Audio> abestiakList = new ArrayList<Audio>();
		Abestia abestiaSartu;
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT a.IdAudio, a.Izena, a.Iraupena, a.Irudia FROM Gustokoak g join Audio a using (IdAudio) where IdBezeroa = "
					+ id;
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				abestiaSartu = new Abestia(rs.getInt("a.IdAudio"), rs.getString("a.izena"),
						rs.getTime("a.Iraupena"), rs.getBlob("a.Irudia"), true);
				abestiakList.add(abestiaSartu);
			}
			konexioa.close();
			return abestiakList;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}

	}

	/**
	 * Abesti gustokoa gehitzeko metodoa.
	 * 
	 * @param abestiGuztokoa Abesti gustokoa
	 * @return gehitzea ondo egin den ala ez
	 * @throws SQLException SQL errorea
	 */
	public static boolean abestiGustokoaGehitu(AbestiGuztokoa abestiGuztokoa) throws SQLException {
		int id = SesioAldagaiak.logErabiltzailea.getIdErabiltzailea();
		try {
			Connection konexioa = Kone.konektatu();
			String kontsulta = "INSERT into Gustokoak(IdBezeroa, IdAudio) VALUES(?,?)";
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1, id);
			pstm.setInt(2, abestiGuztokoa.getAudio().getIdAudio());
			pstm.execute();
			konexioa.close();
			return true;
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
			return false;
		}
	}

	/**
	 * Abesti gustokoa ezabatzeko metodoa.
	 * 
	 * @param abestiGuztokoa Abesti gustokoa
	 * @return ezabatzea ondo egin den ala ez
	 */
	public static boolean abestiGuztokoaEzabatu(AbestiGuztokoa abestiGuztokoa) {
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "DELETE FROM Gustokoak WHERE IdBezeroa = "
					+ abestiGuztokoa.getErabiltzailea().getIdErabiltzailea() + " AND IdAudio = "
					+ abestiGuztokoa.getAudio().getIdAudio();
			stm.executeUpdate(kontsulta);
			konexioa.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
		

	}

	/**
	 * Abesti gustokoa konprobatzeko metodoa.
	 * 
	 * @param abestiGuztokoa Abesti gustokoa
	 * @return abesti gustokoa duen ala ez
	 * @throws SQLException SQL errorea
	 */
	public static boolean abestiGuztokoaKonprobatu(AbestiGuztokoa abestiGuztokoa) throws SQLException {
		boolean gustokoaDu;
		Connection konexioa = Kone.konektatu();
		Statement stm = konexioa.createStatement();
		String kontsulta = "SELECT count(IdAudio) as cont from Gustokoak where IdBezeroa = "
				+ abestiGuztokoa.getErabiltzailea().getIdErabiltzailea() + " and IdAudio = "
				+ abestiGuztokoa.getAudio().getIdAudio() + ";";
		ResultSet rs = stm.executeQuery(kontsulta);
		rs.next();

		if (rs.getInt("cont") == 0) {
			gustokoaDu = false;
		} else {
			gustokoaDu = true;
		}
		konexioa.close();
		return gustokoaDu;
	}

}
