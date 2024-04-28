package view;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.PlayListak;
import model.SesioAldagaiak;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.border.LineBorder;

public class NirePlaylista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public NirePlaylista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JButton btnErabiltzaile = ViewMetodoak.btnErabiltzaileaSortu();

		ArrayList<PlayListak> playlistLista = Kone.getPlaylist();
		
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
				dispose();
				JFrameSortu.playListaSortuSortu();
			}
		});

		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (jListPlayList.getSelectedValue() == null) {
						JOptionPane.showMessageDialog(null, "Ez duzu Playlist bat aukeratu ezabatzeko", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						int aukeraPlaylist = jListPlayList.getSelectedIndex();
						Kone.playlistEzabatu(playlistLista.get(aukeraPlaylist).getIdPlayList());
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
			}
		});

		btnExportatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnAukeratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListPlayList.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Ez duzu Playlist bat aukeratu", "Error", JOptionPane.ERROR_MESSAGE);
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

		btnErabiltzaile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SesioAldagaiak.erabiltzaileLogeatutaFree = null;
				SesioAldagaiak.erabiltzaileLogeatutaPremium = null;
				SesioAldagaiak.erabiltzailePremium = false;
				dispose();
				JFrameSortu.loginAukeraSortu();
			}
		});
	}
}
