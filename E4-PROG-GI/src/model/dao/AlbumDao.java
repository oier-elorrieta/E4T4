package model.dao;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Abestia;
import model.Album;
import model.Audio;
import model.Musikaria;
import model.sql.Kone;




public class AlbumDao {
	
	/**
	 * Musikariaren albumak itzultzen dituen metodoa.
	 * 
	 * @param musikari Musikari objektua
	 * @return Album objektuen ArrayList bat
	 */
	public static ArrayList<Album> getAlbumakByMusikari(Musikaria musikari) {
		Connection konexioa = Kone.konektatu();
		ArrayList<Album> albumak = new ArrayList<Album>();
		try {
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM Album where IdArtista =" + musikari.getIdArtista() + "";
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				albumak.add(new Album(rs.getInt("IdAlbum"), rs.getString("Izenburua"), rs.getString("Generoa"), rs.getBlob("Irudia"),rs.getDate("Urtea")));
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return albumak;
	}
	
	/**
	 * Albumen kanta kopurua betetzen duen metodoa.
	 * 
	 * @param albumak Album objektuen ArrayList bat
	 */
	public static boolean beteAlbumakKantaKop(ArrayList<Album> albumak) {
		Connection konexioa = Kone.konektatu();
		for (int i = 0; i < albumak.size(); i++) {
			try {
				Statement stm = konexioa.createStatement();
				String kontsulta = "SELECT count(IdAudio) FROM Abestia where IdAlbum =" + albumak.get(i).getId() + "";
				ResultSet rs = stm.executeQuery(kontsulta);
				rs.next();
				albumak.get(i).setKantaKop(rs.getInt("count(IdAudio)"));
			} catch (SQLException e) {
				e.getMessage();
				return false;
			}
		}
		Kone.itxiConexioa();
		return true;
	}
	
	/**
	 * Album klasea abestien albuma errepresentatzeko erabiliko da.
	 * Albumak izenburua, generoa eta irudia ditu.
	 */
	public static Album getAlbumByAbesti(Audio audio) {
		Album albumAbestia = null;
		Connection konexioa = Kone.konektatu();
		try {
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT al.IdAlbum, al.Izenburua, al.Generoa, al.Irudia  from Album al Inner join Abestia ab using (IdAlbum) inner join Audio au where au.IdAudio = " + audio.getIdAudio() + " and ab.IdAudio = " + audio.getIdAudio() + ";";
			ResultSet rs = stm.executeQuery(kontsulta);
			rs.next();
			albumAbestia = new Album(rs.getInt("al.IdAlbum"), rs.getString("al.Izenburua"), rs.getString("al.Generoa"), rs.getBlob("al.Irudia"));			
		} catch (SQLException e) {
			e.getMessage();
		}
		Kone.itxiConexioa();
		return albumAbestia;
	}
	
	/**
	 * 
	 * @param a
	 * @param idMusikari
	 * @return
	 */
	public static boolean gehituAlbum(Album a,int idMusikari) {
		
			boolean ondo = true;
			
			Connection konexioa = Kone.konektatuAdmin();
			String kontsulta = "CALL InsertatuAlbum(?,?,?,?,?)";
			try {
				PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
				pstm.setString(1,a.getIzenburua());
				pstm.setString(2,a.getIrudiaString());
				pstm.setString(3,a.getGeneroa());
				pstm.setDate(4, new java.sql.Date(a.getUrtea().getTime()));
				pstm.setInt(5,idMusikari);
				pstm.execute();
				konexioa.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				ondo =  false;
			}
			
			return ondo;
		}
	
	public static boolean aldatuAlbum(Album a) {
	
	boolean ondo = true;
	
	Connection konexioa = Kone.konektatuAdmin();
	String kontsulta = "UPDATE Album set Izenburua = ?,Urtea = ?,Generoa = ?, Irudia = fromBase64(?) WHERE AlbumId = ?";
	try {
		PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
		pstm.setString(1,a.getIzenburua());
		pstm.setDate(2,new java.sql.Date(a.getUrtea().getTime()));
		pstm.setString(3,a.getGeneroa());
		pstm.setString(4,a.getIrudiaString());
		pstm.setInt(5,a.getId());
		pstm.execute();
		konexioa.close();
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		ondo =  false;
	}
	
	return ondo;
	}
}

