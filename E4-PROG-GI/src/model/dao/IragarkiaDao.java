package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Iragarkia;
import model.sql.Kone;

/**
 * IragarkiaDao klasea datu-basearekin komunikatzeko erabiltzen den DAO klasea
 * da.
 */
public class IragarkiaDao {

	/**
	 * Datu-basean dauden iragarkiak itzultzen ditu.
	 * 
	 * @return iragarkiak ArrayList bat, Iragarkia objektuak gordetzen dituena.
	 */
	public static ArrayList<Iragarkia> getIragarkiak() {
		ArrayList<Iragarkia> iragarkiak = new ArrayList<Iragarkia>();
		Iragarkia iragarkia;
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "select * from Audio where mota = 'iragarkia'";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				iragarkia = new Iragarkia(rs.getInt("IdAudio"), rs.getString("Izena"), rs.getBlob("Irudia"));
				iragarkiak.add(iragarkia);
			}
			konexioa.close();
			return iragarkiak;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}

	}

}
