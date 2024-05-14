package model.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Hizkuntza;
import model.sql.Kone;

public class HizkuntzaDao {

	/**
	 * Hizkuntzak jaso eta itzultzen dituen ArrayList bat itzultzen du.
	 * 
	 * @return Hizkuntzak ArrayList moduan
	 */
	public static ArrayList<Hizkuntza> getHizkuntzak() {
		ArrayList<Hizkuntza> hizkuntzak = new ArrayList<Hizkuntza>();
		Hizkuntza hizkuntzaSartu;
		try {
			Connection konexioa = Kone.konektatu();
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM Hizkuntza";
			ResultSet rs = stm.executeQuery(kontsulta);
			while(rs.next()) {
				hizkuntzaSartu = new Hizkuntza(rs.getString("IdHizkuntza"), rs.getString("Deskribapena"));
				hizkuntzak.add(hizkuntzaSartu);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return hizkuntzak;
	}
	
}
