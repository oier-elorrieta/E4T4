package model.metodoak;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;

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
				}
			}
			Kone.itxiConexioa();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginOK;
	}
}
