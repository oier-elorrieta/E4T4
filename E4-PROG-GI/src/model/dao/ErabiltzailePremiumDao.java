package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ErabiltzailePremium;
import model.SesioAldagaiak;
import model.sql.Kone;

public class ErabiltzailePremiumDao {
	/**
	 * Erregistratu erabiltzailea premium bezala.
	 * 
	 * @param id    Erabiltzailearen identifikazio zenbakia
	 * @param iranD Premium egunera arteko data
	 */
	public static void erregistratuPremium(int id, java.sql.Date iranD) {
		Connection konexioa = Kone.konektatu();
		String kontsulta;
		PreparedStatement pstm;
		try {
			Statement stm = konexioa.createStatement();
			// Zaiatu Premium bezala ezartzen berria bada
			kontsulta = "INSERT into Premium values(?, ?);";
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setInt(1, id);
			pstm.setDate(2, iranD);
			pstm.execute();
		} catch (SQLException e) {
			try {
				kontsulta = "UPDATE Premium SET IraungitzeData = ? WHERE IdBezeroa = ?;";
				pstm = konexioa.prepareStatement(kontsulta);
				pstm.setDate(1, iranD);
				pstm.setInt(2, id);
				pstm.execute();
			} catch (SQLException i) {
				System.out.println("Kontsulta txarto" + e.getMessage());
			}
		}
		try {
			kontsulta = "UPDATE Bezeroa SET Mota = ? WHERE IdBezeroa = ?;";
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1, "Premium");
			pstm.setInt(2, id);
			pstm.execute();
		} catch (SQLException e) {
			System.out.println("Ezin izan da Premium ezarri " + e.getMessage());
		}
		try {
			konexioa.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Kargatu erabiltzailea premium erabiltzaile moduan.
	 * 
	 * @param id Erabiltzailearen identifikazio zenbakia
	 * @return True, baldin eta erabiltzailea kargatzea ondo joan bada. False, bestela.
	 */
	public static boolean kargatuErabiltzailePremium(int id) {
		Connection konexioa = Kone.konektatu();
		try {
			Statement stm = konexioa.createStatement();
			String kontsulta = "SELECT * FROM Bezeroa b join Premium p where b.IdBezeroa = p.IdBezeroa and b.IdBezeroa = "
					+ id;
			ResultSet rs = stm.executeQuery(kontsulta);
			while (rs.next()) {
				SesioAldagaiak.logErabiltzailea = new ErabiltzailePremium(rs.getInt("b.IdBezeroa"),
						rs.getString("b.Erabiltzailea"), rs.getString("b.Pasahitza"), rs.getString("b.Izena"),
						rs.getString("b.Abizena"), rs.getDate("JaiotzeData"), rs.getString("b.IdHizkuntza"),
						rs.getDate("p.IraungitzeData"));
			}
			konexioa.close();
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
		return true;

	}
}
