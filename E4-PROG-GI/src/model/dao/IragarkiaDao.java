package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Album;
import model.Iragarkia;
import model.Musikaria;
import model.sql.Kone;

public class IragarkiaDao {
	
	public static ArrayList<Iragarkia> getIragarkiak() {
		Connection konexioa = Kone.konektatu();
		ArrayList<Iragarkia> iragarkiak = new ArrayList<Iragarkia>();
		Iragarkia iragarkia;
		try {
			Statement stm = konexioa.createStatement();
			String kontsulta = "select * from Audio where mota = 'iragarkia'";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				iragarkia = new Iragarkia(rs.getInt("IdAudio"), rs.getString("Izena"), rs.getBlob("Irudia"));
				iragarkiak.add(iragarkia);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return iragarkiak;
	}
	
}
