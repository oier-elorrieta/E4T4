package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Estadistika;
import model.sql.Kone;

public class EstadistikaDao {

	/**
	 * Eguneko abestiak lortzeko funtzioa.
	 * 
	 * @return Eguneko abestiak duen ArrayList bat.
	 */
	public static ArrayList<Estadistika> getAbestiakTopEguna() {
		try {
			Connection konexioa = Kone.konektatu();
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM EstadistikaAbestiaEgunean";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(
						new Estadistika(rs.getString("Musikaria"), rs.getString("Abestia"), rs.getInt("Entzunaldiak")));
			}
			konexioa.close();
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Hilabete bakoitzean abestiak lortzeko funtzioa.
	 * 
	 * @return Hilabete bakoitzean abestiak duen ArrayList bat.
	 */
	public static ArrayList<Estadistika> getAbestiakTopHilea() {
		try {
			Connection konexioa = Kone.konektatu();
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM EstadistikaAbestiaHilean";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(
						new Estadistika(rs.getString("Musikaria"), rs.getString("Abestia"), rs.getInt("Entzunaldiak")));
			}
			konexioa.close();
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Urte bakoitzean abestiak lortzeko funtzioa.
	 * 
	 * @return Urte bakoitzean abestiak duen ArrayList bat.
	 */
	public static ArrayList<Estadistika> getAbestiakTopUrtea() {
		try {
			Connection konexioa = Kone.konektatu();
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM EstadistikaAbestiaUrtean";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(
						new Estadistika(rs.getString("Musikaria"), rs.getString("Abestia"), rs.getInt("Entzunaldiak")));
			}
			konexioa.close();
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Eguneko podcast-ak lortzeko funtzioa.
	 * 
	 * @return Eguneko podcast-ak duen ArrayList bat.
	 */
	public static ArrayList<Estadistika> getPodcastTopEguna() {
		try {
			Connection konexioa = Kone.konektatu();
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM EstadistikaPodcastEgunean";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(
						new Estadistika(rs.getString("Podcasterra"), rs.getString("Izena"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Hilabete bakoitzean podcast-ak lortzeko funtzioa.
	 * 
	 * @return Hilabete bakoitzean podcast-ak duen ArrayList bat.
	 */
	public static ArrayList<Estadistika> getPodcastTopHilea() {
		try {
			Connection konexioa = Kone.konektatu();
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM EstadistikaPodcastHilean";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(
						new Estadistika(rs.getString("Podcasterra"), rs.getString("Izena"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Urte bakoitzean podcast-ak lortzeko funtzioa.
	 * 
	 * @return Urte bakoitzean podcast-ak duen ArrayList bat.
	 */
	public static ArrayList<Estadistika> getPodcastTopUrtea() {
		try {
			Connection konexioa = Kone.konektatu();
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM EstadistikaPodcastUrtean";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(
						new Estadistika(rs.getString("Podcasterra"), rs.getString("Izena"), rs.getInt("Entzunaldiak")));
			}
			konexioa.close();
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Eguneko entzundakoak lortzeko funtzioa.
	 * 
	 * @return Eguneko entzundakoak duen ArrayList bat.
	 */
	public static ArrayList<Estadistika> getTopEntzundaEgunean() {
		try {
			Connection konexioa = Kone.konektatu();
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM EntzundaEgunean";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Izena"), "", rs.getInt("Entzunaldiak")));
			}
			konexioa.close();
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Hilabete bakoitzean entzundakoak lortzeko funtzioa.
	 * 
	 * @return Hilabete bakoitzean entzundakoak duen ArrayList bat.
	 */
	public static ArrayList<Estadistika> getTopEntzundaHilean() {
		Connection konexioa = Kone.konektatu();
		try {
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM EntzundaHilean";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Izena"), "", rs.getInt("Entzunaldiak")));
			}
			konexioa.close();
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Urte bakoitzean entzundakoak lortzeko funtzioa.
	 * 
	 * @return Urte bakoitzean entzundakoak duen ArrayList bat.
	 */
	public static ArrayList<Estadistika> getTopEntzundaUrtean() {
		try {
			Connection konexioa = Kone.konektatu();
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM EntzundaUrtean";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(new Estadistika(rs.getString("Izena"), "", rs.getInt("Entzunaldiak")));
			}
			konexioa.close();
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Eguneko albumak lortzeko funtzioa.
	 * 
	 * @return Eguneko albumak duen ArrayList bat.
	 */
	public static ArrayList<Estadistika> getAlbumakTopEguna() {
		try {
			Connection konexioa = Kone.konektatu();
			ArrayList<Estadistika> estadistika = new ArrayList<Estadistika>();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM EstadistikaAlbumakEgunean";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				estadistika.add(
						new Estadistika(rs.getString("Artista"), rs.getString("Albuma"), rs.getInt("Entzunaldiak")));
			}
			konexioa.close();
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Hilabete bakoitzean albumak lortzeko funtzioa.
	 * 
	 * @return Hilabete bakoitzean albumak duen ArrayList bat.
	 */
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
				estadistika.add(
						new Estadistika(rs.getString("Artista"), rs.getString("Albuma"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Urte bakoitzean albumak lortzeko funtzioa.
	 * 
	 * @return Urte bakoitzean albumak duen ArrayList bat.
	 */
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
				estadistika.add(
						new Estadistika(rs.getString("Artista"), rs.getString("Albuma"), rs.getInt("Entzunaldiak")));
			}
			return estadistika;
		} catch (SQLException e) {
			e.getMessage();
			return null;
		}
	}
}
