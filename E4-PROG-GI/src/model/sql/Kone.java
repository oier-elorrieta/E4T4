package model.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Random;

public class Kone {
	

	private static String url = "jdbc:mysql://10.5.6.111:3306/Sphea";
	private static String user = "admin";
    private static String pass = "headmin";
    private static Connection konexioa = null;
    private static String kontsulta;
    private static Statement stm;
    private static PreparedStatement pstm;
    private static ResultSet rs;
   

	// Datu-basearekin konexioa egiteko metodoa
    public static void konektatu() {
    	try {
            // Konexioa sortu, oraindik ez badago
            if (konexioa == null || konexioa.isClosed()) {
                konexioa = DriverManager.getConnection(url, user, pass);
                System.out.println("Konektatuta!!!");
            }
        } catch (SQLException e) {
            System.out.println("Errorea datu-basearekin konexioa egiten: " + e.getMessage());
        }
    	//return konexioa;
    }
    
    public static void itxiConexioa() {
		try {
			stm.close();
			konexioa.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	
	/*public ResultSet hizkuntzaHartu() {
		try {
			kontsulta = "SELECT Deskribapena FROM Hizkuntza JOIN Bezeroa using(IdHizkuntza)";
			stm = this.konexioa.createStatement();
			rs = stm.executeQuery(kontsulta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}*/
			
public static void erregistratu(String izena,String abizena,String erabiltzailea,String pasahitza,String data,String hizk) {
		konektatu();
		kontsulta = "INSERT into Bezeroa(Izena,Abizena,Erabiltzailea,Pasahitza,JaiotzeData,IdHizkuntza) VALUES(?,?,?,?,?,?)";
		try {
			pstm = konexioa.prepareStatement(kontsulta);
			pstm.setString(1,izena);
			pstm.setString(2,abizena);
			pstm.setString(3,erabiltzailea);
			pstm.setString(4,pasahitza);
			pstm.setString(5,data);
			pstm.setString(6,hizk);
			pstm.execute();
		} catch (SQLException e) {
			System.out.println("Kontsulta txarto" + e.getMessage());
		}	
		itxiConexioa();
		
	}
}
