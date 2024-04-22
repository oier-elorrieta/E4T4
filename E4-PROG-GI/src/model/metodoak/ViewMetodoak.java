package model.metodoak;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import model.ErabiltzaileFree;
import model.SesioAldagaiak;
import model.sql.Kone;

public class ViewMetodoak {

	public static DefaultComboBoxModel cboHizkuntzaModeloaSortu(DefaultComboBoxModel modeloa) {
		try {
			Kone.konektatu();
			ResultSet hizkuntzaLista = Kone.hizkuntzakAtera();
			while (hizkuntzaLista.next()) {
				modeloa.addElement(hizkuntzaLista.getString("IdHizkuntza"));
			}
			Kone.itxiConexioa();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modeloa;
	}

	public static boolean comprobatuLogin(String erabiltzailea, String pasahitza) {
		boolean loginOK = false;
		try {
			Kone.konektatu();
			ResultSet erabiltzaileInfo = Kone.isLoginaOk(erabiltzailea);
			while (erabiltzaileInfo.next()) {
				if (erabiltzaileInfo.getString("Pasahitza").equals(pasahitza)) {
					loginOK = true;
					erabiltzaileaKargatu(erabiltzaileInfo.getInt("IdBezeroa"), erabiltzaileInfo.getString("Mota"));
				}
			}
			Kone.itxiConexioa();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginOK;
	}

	public static void erabiltzaileaKargatu(int id, String mota) {
		switch (mota) {
		case "free":
			Kone.kargatuErabiltzaileFree(id);
			SesioAldagaiak.erabiltzailePremium = false;
			break;
		case "premium":
			Kone.kargatuErabiltzailePremium(id);
			SesioAldagaiak.erabiltzailePremium = true;
			break;
		}
	}

	public static JButton btnErabiltzaileaSortu() {
		JButton btnErabiltzaile = null;
		if (!SesioAldagaiak.erabiltzailePremium) {
			btnErabiltzaile = new JButton(SesioAldagaiak.erabiltzaileLogeatutaFree.getIzena());
			btnErabiltzaile.setBackground(Color.BLACK);
			btnErabiltzaile.setForeground(Color.RED);
			btnErabiltzaile.setBounds(700, 60, 144, 50);
			btnErabiltzaile.setFont(new Font("SansSerif", Font.BOLD, 22));
			btnErabiltzaile.setFocusPainted(false);
		} else {
			btnErabiltzaile = new JButton(SesioAldagaiak.erabiltzaileLogeatutaPremium.getIzena());
			btnErabiltzaile.setBackground(Color.BLACK);
			btnErabiltzaile.setForeground(Color.RED);
			btnErabiltzaile.setBounds(700, 60, 144, 50);
			btnErabiltzaile.setFont(new Font("SansSerif", Font.BOLD, 22));
			btnErabiltzaile.setFocusPainted(false);
		}
		return btnErabiltzaile;
	}
}
