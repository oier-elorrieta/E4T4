package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ErabiltzaileFree;
import model.SesioAldagaiak;
import model.sql.Kone;

public class ErabiltzaileFreeDao {
	
	/**
	 * Erabiltzailea erregistratzeko metodoa.
	 * 
	 * @param erab ErabiltzaileFree objektua
	 * @return erregistratu den erabiltzailea
	 */
	public static boolean erregistratuErabiltzailea(ErabiltzaileFree erab) {
		try {
			Connection konexioa = Kone.konektatu();
			String kontsulta = "INSERT into Bezeroa(Izena,Abizena,Erabiltzailea,Pasahitza,JaiotzeData,IdHizkuntza) VALUES(?,?,?,?,?,?)";
			PreparedStatement pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1, erab.getIzena());
			pstm.setString(2, erab.getAbizena());
			pstm.setString(3, erab.getErabiltzailea());
			pstm.setString(4, erab.getPasahitza());
			pstm.setDate(5, (java.sql.Date) erab.getJaiotzeData());
			pstm.setString(6, erab.getHizkuntza());
			pstm.execute();
			return true;
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
			return false;
		}

	}
	
	/**
	 * ErabiltzaileFree objektua kargatzeko metodoa.
	 * 
	 * @param id Bezeroaren identifikazio zenbakia
	 * @return erabiltzailea kargatu den ala ez
	 */
	public static boolean kargatuErabiltzaileFree(int id) {
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
			Kone.itxiConexioa();
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
		return true;
	}
}
