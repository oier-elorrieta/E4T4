package view.bezeroa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Audio;
import model.PlayListak;
import model.SesioAldagaiak;
import model.dao.PlayListakDao;
import model.metodoak.ImportExportMetodoak;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.salbuespenak.PlaylistSortuLimitazioa;
import model.sql.Kone;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.border.LineBorder;

public class NirePlaylista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame = this;

	public NirePlaylista() {
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);

		JButton btnErabiltzaile = SesioAldagaiak.jb;
		btnErabiltzaile.removeActionListener(btnErabiltzaile.getActionListeners()[0]);

		ArrayList<PlayListak> playlistLista = PlayListakDao.getPlaylist();
		// ArrayList<PlayListak> playlistLista = Kone.getPlaylist();
		DefaultListModel<String> modeloLista = new DefaultListModel<>();
		for (int i = 0; i < playlistLista.size(); i++) {
			modeloLista.addElement(playlistLista.get(i).getIzena());
		}

		JList<String> jListPlayList = new JList(modeloLista);
		jListPlayList.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scrollPane = new JScrollPane(jListPlayList);
		jListPlayList.setBounds(50, 150, 550, 350);

		JButton btnBerriaSortu = new JButton("Berria Sortu");
		btnBerriaSortu.setBounds(650, 150, 208, 50);
		btnBerriaSortu.setFont(new Font("SansSerif", Font.BOLD, 22));

		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setBounds(650, 225, 208, 50);
		btnEzabatu.setFont(new Font("SansSerif", Font.BOLD, 22));

		JButton btnImportatu = new JButton("Importatu");
		btnImportatu.setBounds(650, 300, 208, 50);
		btnImportatu.setFont(new Font("SansSerif", Font.BOLD, 22));

		JButton btnExportatu = new JButton("Exportatu");
		btnExportatu.setBounds(650, 375, 208, 50);
		btnExportatu.setFont(new Font("SansSerif", Font.BOLD, 22));

		JButton btnAukeratu = new JButton("Aukeratu");
		btnAukeratu.setBounds(650, 450, 208, 50);
		btnAukeratu.setFont(new Font("SansSerif", Font.BOLD, 22));

		contentPane.add(jListPlayList);
		contentPane.add(btnBerriaSortu);
		contentPane.add(btnEzabatu);
		contentPane.add(btnImportatu);
		contentPane.add(btnExportatu);
		contentPane.add(btnAukeratu);
		contentPane.add(btnAtzera);
		contentPane.add(btnErabiltzaile);

		btnBerriaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (SesioAldagaiak.logErabiltzailea.getClass().getSimpleName().equals("ErabiltzaileFree")
							&& playlistLista.size() < 4) {
						dispose();
						JFrameSortu.playListaSortuSortu();
					} else if (SesioAldagaiak.logErabiltzailea.getClass().getSimpleName()
							.equals("ErabiltzailePremium")) {
						dispose();
						JFrameSortu.playListaSortuSortu();
					} else {
						throw new PlaylistSortuLimitazioa();
					}
				} catch (PlaylistSortuLimitazioa ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (jListPlayList.getSelectedValue() == null) {
						JOptionPane.showMessageDialog(null, "Ez duzu Playlist bat aukeratu ezabatzeko", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (jListPlayList.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(null, "Ezin duzu Playlist hau ezabatu", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						int aukeraPlaylist = jListPlayList.getSelectedIndex();
						PlayListakDao.playlistEzabatu(playlistLista.get(aukeraPlaylist).getIdPlayList());
						dispose();
						JFrameSortu.nirePlaylistaSortu();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnImportatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] aux = ImportExportMetodoak.importatuPlaylist();

				JPanel pan = new JPanel(new BorderLayout());
				JTextField gg = new JTextField();
				pan.add(gg, BorderLayout.CENTER);

				int opcion = JOptionPane.showConfirmDialog(null, pan, "Mesedez, Sartu PlayListaren Izen Berria:",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				if (opcion == JOptionPane.OK_OPTION) {
					aux[0] = gg.getText();

					PlayListakDao.playlistGehitu(aux[0]);
					PlayListak p = new PlayListak();
					p = PlayListakDao.getPlayListIzenarekin(aux[0]);

					Audio a = new Audio();

					for (int i = 1; i < aux.length; i++) {
						a.setIdAudio(Integer.parseInt(aux[i]));
						PlayListakDao.playlisteanAbestiaGehitu(p, a);
					}

					dispose();
					JFrameSortu.nirePlaylistaSortu();

				} else {

					System.out.println("Importazioa kanzelatua bezeroarengatik");
				}

			}
		});

		btnExportatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PlayListak selectedPlay = playlistLista.get(jListPlayList.getSelectedIndex());

				ImportExportMetodoak.exportatuPlaylist(selectedPlay);
				JOptionPane.showMessageDialog(null, "Ondo exportatu da Playlista", "Exportatuta",
						JOptionPane.INFORMATION_MESSAGE);

			}

		});

		btnAukeratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListPlayList.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu Playlist bat aukeratu", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int aukeraPlaylist = jListPlayList.getSelectedIndex();
					PlayListak aukeraPlaylistO = playlistLista.get(aukeraPlaylist);
					dispose();
					JFrameSortu.playlistAbestiakSortu(aukeraPlaylistO);
				}
			}
		});

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.menuNagusiaAukeraSortu();
			}
		});

		btnErabiltzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrameSortu.premiumErregistroAukeraSortu(frame);
			}
		});
	}
}
