package model.metodoak;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.ErabiltzaileFree;
import model.SesioAldagaiak;
import model.sql.Kone;
import view.MusikariView;

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
	
	public static void btnGeneratu(JPanel pane,String ruta,String izena,String entzunaldiak,JFrame jf) {
		
		JButton newButton = new JButton();
        newButton.setText(izena + " Entzunaldiak: " + entzunaldiak);
        ImageIcon icono = new ImageIcon(ruta);
        newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusikariView mv = new MusikariView(izena);
				mv.setVisible(true);
				jf.dispose();
			}
		});
        
        // Escala la imagen al tamaño deseado
        Image imagen = icono.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);

        // Crea un nuevo ImageIcon con la imagen escalada
        ImageIcon iconoEscalado = new ImageIcon(imagen);
        newButton.setIcon(iconoEscalado);
         
        pane.add(newButton);

        // Se actualiza el layout del panel para que se ajuste automáticamente
        pane.revalidate();
        pane.repaint();
		
	}
	
	public static void musikariakEntzunaldiakBotoiarentzako(JPanel pane,JFrame jf) {
		
		ResultSet rs = Kone.getMusikariakEntzunaldiak();
		try {
		while(rs.next()) {
			
			String izena = rs.getString("Izena");
			String entzunaldiak =  rs.getString("Totala");
			btnGeneratu(pane,"C:\\Users\\in1dm3-d\\Desktop\\4.Erronka\\E4T4\\E4-PROG-GI\\src\\img\\acdc.png",izena,entzunaldiak,jf);
		}
		}catch(SQLException e){
			
		}	
				
	
	}
	
	public static void sortuErabiltzaileaIzenarekin(String izena) {
		
		
		
	}
	
	
}
