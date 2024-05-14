package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Abestia;
import model.Estadistika;
import model.sql.Kone;

public class EstadistikaDao {
	
	public static ArrayList<Estadistika> getAbestiakTopEguna() {
		ResultSet rs;
		String kontsulta;
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstadistikaAbestiaEgunean";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Musikaria"), rs.getString("Abestia"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static ArrayList<Estadistika> getAbestiakTopHilea() {
		ResultSet rs;
		String kontsulta;
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstadistikaAbestiaHilean";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Musikaria"), rs.getString("Abestia"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static ArrayList<Estadistika> getAbestiakTopUrtea() {
		ResultSet rs;
		String kontsulta;
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstadistikaAbestiaUrtean";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Musikaria"), rs.getString("Abestia"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static ArrayList<Estadistika> getPodcastTopEguna() {
		ResultSet rs;
		String kontsulta;
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstadistikaPodcastEgunean";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Podcasterra"), rs.getString("Izena"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static ArrayList<Estadistika> getPodcastTopHilea() {
		ResultSet rs;
		String kontsulta;
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstadistikaPodcastHilean";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Podcasterra"), rs.getString("Izena"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static ArrayList<Estadistika> getPodcastTopUrtea() {
		ResultSet rs;
		String kontsulta;
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstadistikaPodcastUrtean";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Podcasterra"), rs.getString("Izena"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static ArrayList<Estadistika> getTopEntzundaEgunean() {
		ResultSet rs;
		String kontsulta;
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EntzundaEgunean";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Izena"), "", rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static ArrayList<Estadistika> getTopEntzundaHilean() {
		ResultSet rs;
		String kontsulta;
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EntzundaHilean";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Izena"), "", rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static ArrayList<Estadistika> getTopEntzundaUrtean() {
		ResultSet rs;
		String kontsulta;
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EntzundaUrtean";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Izena"), "", rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static ArrayList<Estadistika> getAlbumakTopEguna() {
		ResultSet rs;
		String kontsulta;
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstadistikaAlbumakEgunean";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Artista"), rs.getString("Albuma"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static ArrayList<Estadistika> getAlbumakTopHilea() {
		ResultSet rs;
		String kontsulta;
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstadistikaAlbumaklHilean";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Artista"), rs.getString("Albuma"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
	
	public static ArrayList<Estadistika> getAlbumakTopUrtea() {
		ResultSet rs;
		String kontsulta;
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			kontsulta = "SELECT * FROM EstadistikaAlbumakUrtean";
			rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Artista"), rs.getString("Albuma"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
}
