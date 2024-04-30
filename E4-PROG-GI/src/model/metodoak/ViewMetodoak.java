package model.metodoak;

import model.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import model.ErabiltzaileFree;
import model.SesioAldagaiak;
import model.sql.Kone;
import view.MusikariView;
import view.PodcastView;

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
			SesioAldagaiak.logErabiltzailea = SesioAldagaiak.erabiltzaileLogeatutaFree;
		} else {
			btnErabiltzaile = new JButton(SesioAldagaiak.erabiltzaileLogeatutaPremium.getIzena());
			SesioAldagaiak.logErabiltzailea = SesioAldagaiak.erabiltzaileLogeatutaPremium;
		}
		btnErabiltzaile.setBackground(Color.LIGHT_GRAY);
		btnErabiltzaile.setForeground(Color.BLACK);
		btnErabiltzaile.setBounds(700, 60, 144, 50);
		btnErabiltzaile.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnErabiltzaile.setFocusPainted(false);
		return btnErabiltzaile;
	}

	public static boolean komprobatuAdmin(String user, String pass) {
		return Kone.konektatuAdmin(user, pass);
	}

	public static void btnGeneratu(JPanel pane, Blob irudia, String izena, String entzunaldiak,JFrame jf) {
		JButton newButton = new JButton();
		newButton.setText(izena + " Entzunaldiak: " + entzunaldiak);
		
		try {
		ImageIcon icono = new ImageIcon(irudia.getBytes(1, (int) irudia.length()));
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
		
		}catch(SQLException e) {
			e.getMessage();
		}
		
		

	}

	public static void musikariakEntzunaldiakBotoiarentzako(JPanel pane, JFrame jf) {

		ResultSet rs = Kone.getMusikariakEntzunaldiak();
		try {
			while (rs.next()) {

				String izena = rs.getString("Izena");
				String entzunaldiak = rs.getString("Totala");
				Blob irudia = rs.getBlob("Irudia");
				btnGeneratu(pane,irudia,izena, entzunaldiak, jf);
			}
		} catch (SQLException e) {

		}
	}

	public static void podcasterrakEntzunaldiakBotoiarentzako(JPanel pane, JFrame jf) {

		ResultSet rs = Kone.getPodcasterEntzunaldiak();
		try {
			while (rs.next()) {

				String izena = rs.getString("Izena");
				String entzunaldiak = rs.getString("Totala");
				btnGeneratuPodcaster(pane,
						"C:\\Users\\in1dm3-d\\Desktop\\4.Erronka\\E4T4\\E4-PROG-GI\\src\\img\\acdc.png", izena,
						entzunaldiak, jf);
			}
		} catch (SQLException e) {

		}
	}

	public static void btnGeneratuPodcaster(JPanel pane, String ruta, String izena, String entzunaldiak, JFrame jf) {
		JButton newButton = new JButton();
		newButton.setText(izena + " Entzunaldiak: " + entzunaldiak);
		ImageIcon icono = new ImageIcon(ruta);
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PodcastView mv = new PodcastView(izena);
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

	public static DefaultListModel<Album> getMusikariAlbumak(String izena) {

		DefaultListModel<Album> lm = new DefaultListModel();
		Musikaria musikari = Kone.getMusikaria(izena);
		ArrayList<Album> albumak = Kone.getAlbumak(musikari);
		Kone.beteAlbumakKantaKop(albumak);

		for (Album i : albumak) {
			lm.addElement(i);
		}

		return lm;
	}
	
	public static DefaultListModel<Audio> getMusikariAbestiak(int idAlbum) {

		DefaultListModel<Audio> lm = new DefaultListModel();
		
		ArrayList<Audio> abestiak = Kone.getAbestiak(idAlbum);
	
		for (Audio i : abestiak) {
			lm.addElement(i);
		}

		return lm;
	}
	
	
	
	

	public static void setIrudia(JLabel lbl, Blob m) {

		try {
			ImageIcon icon = new ImageIcon(m.getBytes(1, (int) m.length()));
			Image imagen = icon.getImage().getScaledInstance(550, 500, Image.SCALE_SMOOTH);
			ImageIcon iconoEscalado = new ImageIcon(imagen);
			lbl.setIcon(icon);
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public static ArrayList<Audio> getPodcastList(String izena) {
		ArrayList<Audio> podcastList = new ArrayList<Audio>();
		Podcasterra podcaster = Kone.getPodcasterra(izena);
		podcastList = Kone.getPodcastak(podcaster);
		return podcastList;

	}

}
