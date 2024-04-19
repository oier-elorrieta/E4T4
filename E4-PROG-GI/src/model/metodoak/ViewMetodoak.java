package model.metodoak;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;

import model.sql.Kone;

public class ViewMetodoak {

	public static DefaultComboBoxModel cboHizkuntzaModeloaSortu(DefaultComboBoxModel modeloa) {
		try {
			Kone.konektatu();
			ResultSet hizkuntzaLista = Kone.hizkuntzakAtera();
			while (hizkuntzaLista.next()) {
				modeloa.addElement(hizkuntzaLista.getString("Deskribapena"));
			}
			Kone.itxiConexioa();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modeloa;
	}

}
