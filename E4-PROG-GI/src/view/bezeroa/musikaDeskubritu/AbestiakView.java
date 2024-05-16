package view.bezeroa.musikaDeskubritu;

import java.awt.Font;

import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Album;
import model.Audio;
import model.Musikaria;
import model.dao.AbestiaDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;

import javax.swing.JScrollPane;

import javax.swing.JList;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextPane;

public class AbestiakView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame = this;
	private String klasea = this.getClass().getSimpleName();

	public AbestiakView(Musikaria musikaria, Album album) {
		setBounds(400, 250, 906, 594);
		setTitle("Abestiak Musikaria - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Albumaren izena
		JLabel lblIzenaAlbum = new JLabel(album.getIzenburua());
		lblIzenaAlbum.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblIzenaAlbum.setBounds(373, 63, 295, 38);

		// Albuma aukeratzeko testua
		JLabel lblAbestiaAukeratu = new JLabel("Aukeratu abestia: ");
		lblAbestiaAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAbestiaAukeratu.setBounds(111, 127, 162, 14);

		JPanel panel = new JPanel();
		panel.setBounds(10, 152, 359, 389);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		// Listaren modeloa bete albumaren abestiekin
		ArrayList<Audio> abestiak = AbestiaDao.getAbestiakByAlbum(album);
		DefaultListModel<Audio> modeloList = new DefaultListModel();
		for (int i = 0; i < abestiak.size(); i++) {
			modeloList.addElement(abestiak.get(i));
		}

		// Lista sortu eta modeloa implementatu
		JList abestiLista = new JList(modeloList);
		abestiLista.setBounds(100, 5, 0, 0);
		JScrollPane scrollPane = new JScrollPane(abestiLista);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(373, 121, 469, 223);
		JLabel lblIrudia = new JLabel("");
		panel_1.add(lblIrudia);

		// Irudia lbl-ari sartu
		ViewMetodoak.setIrudia(lblIrudia, album.getIrudia());

		// Albumaren deskripzioa atera
		JTextPane albumDeskripzioa = new JTextPane();
		JScrollPane scrollPane_1 = new JScrollPane(albumDeskripzioa);
		albumDeskripzioa.setText(album.toString());
		scrollPane_1.setBounds(373, 378, 469, 166);
		albumDeskripzioa.setEditable(false);

		// Erabiltzailearen datuak aldatzeko botoia
		JButton btnErabiltzaile = ViewMetodoak.btnErabiltzaileaSortu();

		// Aurreko pantallara joan
		JButton btnAtzera = ViewMetodoak.btnAtzeraSortu();

		contentPane.add(lblIzenaAlbum);
		contentPane.add(lblAbestiaAukeratu);
		contentPane.add(panel);
		contentPane.add(panel_1);
		contentPane.add(scrollPane_1);
		contentPane.setLayout(null);
		contentPane.add(btnErabiltzaile);
		contentPane.add(btnAtzera);

		// Listean abesti bat aukeratzean, erreprodukziora joan
		abestiLista.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					int abestiAukera = abestiLista.getSelectedIndex();
					dispose();
					JFrameSortu.erreprodukzioaSortu(klasea, musikaria, abestiak, abestiAukera, true, 1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnErabiltzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrameSortu.premiumErregistroAukeraSortu(frame);
			}
		});

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.albumakViewSortu(musikaria);
			}
		});
	}
}
