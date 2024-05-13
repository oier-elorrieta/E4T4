package view.bezeroa;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mysql.cj.Session;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import model.*;
import model.dao.AbestiaDao;
import model.dao.AlbumDao;
import model.dao.AudioDao;
import model.dao.MusikariaDao;
import model.dao.PlayListakDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AbestiaPlayListeanSartu extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String String = null;
	private JPanel contentPane;
	private JFrame frame = this;

	public AbestiaPlayListeanSartu(Audio audio) throws SQLException {
		setBounds(400, 250, 600, 425);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInfo = new JLabel("Abesti Informazioa:");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 15));
		lblInfo.setBounds(50, 125, 200, 75);

		JLabel lblIzena = new JLabel(audio.getIzena());
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblIzena.setBounds(50, 150, 200, 75);

		JLabel lblIraupena = new JLabel(audio.getIraupena() + "");
		lblIraupena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIraupena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblIraupena.setBounds(50, 175, 200, 75);

		JLabel lblAlbumIzena = new JLabel(AlbumDao.getAlbumByAbesti(audio).getIzenburua());
		lblAlbumIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbumIzena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblAlbumIzena.setBounds(50, 200, 200, 75);

		JLabel lblMusikariIzena = new JLabel(MusikariaDao.getMusikariaByAudio(audio).getIzena());
		lblMusikariIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusikariIzena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		lblMusikariIzena.setBounds(50, 225, 200, 75);

		ArrayList<PlayListak> playlistLista = PlayListakDao.getPlaylist();
		DefaultListModel<String> modeloLista = new DefaultListModel<>();
		for (int i = 0; i < playlistLista.size(); i++) {
			modeloLista.addElement(playlistLista.get(i).getIzena());
		}
		JList<String> jListPlayList = new JList(modeloLista);
		jListPlayList.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scrollPane = new JScrollPane(jListPlayList);
		jListPlayList.setBounds(300, 150, 250, 200);

		JButton btnSartu = new JButton("Sartu");
		btnSartu.setBackground(Color.BLACK);
		btnSartu.setForeground(Color.RED);
		btnSartu.setBounds(100, 300, 100, 50);
		btnSartu.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnSartu.setFocusPainted(false);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);

		JButton btnErabiltzaile = new JButton(SesioAldagaiak.logErabiltzailea.getIzena());
				
		/*JButton btnErabiltzaile = null;
		if (!SesioAldagaiak.erabiltzailePremium) {
			btnErabiltzaile = new JButton(SesioAldagaiak.erabiltzaileLogeatutaFree.getIzena());
			SesioAldagaiak.logErabiltzailea = SesioAldagaiak.erabiltzaileLogeatutaFree;
		} else {
			btnErabiltzaile = new JButton(SesioAldagaiak.erabiltzaileLogeatutaPremium.getIzena());
			SesioAldagaiak.logErabiltzailea = SesioAldagaiak.erabiltzaileLogeatutaPremium;
		}*/
		btnErabiltzaile.setBackground(Color.LIGHT_GRAY);
		btnErabiltzaile.setForeground(Color.BLACK);
		btnErabiltzaile.setBounds(400, 60, 144, 50);
		btnErabiltzaile.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnErabiltzaile.setFocusPainted(false);

		contentPane.add(lblInfo);
		contentPane.add(lblIzena);
		contentPane.add(lblIraupena);
		contentPane.add(lblAlbumIzena);
		contentPane.add(lblMusikariIzena);
		contentPane.add(jListPlayList);
		contentPane.add(btnSartu);
		contentPane.add(btnAtzera);
		contentPane.add(btnErabiltzaile);

		btnSartu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (jListPlayList.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu ezer aukeratu.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					int index = jListPlayList.getSelectedIndex();
					if (index == 0) {
						try {
							if (AbestiaDao.gustukoaKomprobatu(audio)) {
								JOptionPane.showMessageDialog(null, "Ezin da sartu abestia, zerrendan baitago.",
										"Error", JOptionPane.ERROR_MESSAGE);
							} else {
								AbestiaDao.abestiGustokoaGehitu(audio);
								JOptionPane.showMessageDialog(null, "Abestia ondo sartu da Playlistean.", "Eginda!",
										JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						if (!PlayListakDao.komprobatuAbestiaBadago(playlistLista.get(index), audio)) {
							PlayListakDao.playlisteanAbestiaGehitu(playlistLista.get(index), audio);
							JOptionPane.showMessageDialog(null, "Abestia ondo sartu da Playlistean.", "Eginda!",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Ezin da sartu abestia, zerrendan baitago.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}

					}
				}
			}
		});

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

		btnErabiltzaile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				JFrameSortu.premiumErregistroAukeraSortu(frame);
			}
		});
	}
}