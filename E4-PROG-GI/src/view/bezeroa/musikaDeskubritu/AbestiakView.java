package view.bezeroa.musikaDeskubritu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mysql.cj.jdbc.Blob;

import model.Abestia;
import model.Album;
import model.Audio;
import model.Musikaria;
import model.dao.AbestiaDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class AbestiakView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Musikaria musikari;
	private JLabel lblIzena;
	private JFrame frame = this;
	private String klasea = this.getClass().getSimpleName();
	
	public AbestiakView(Musikaria musikaria, Album album) {			
		setBounds(400, 250, 906, 594);
		setTitle("Abestiak Musikaria - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		//JButton btnErabiltzaile = model.SesioAldagaiak.jb;
		//btnErabiltzaile.removeActionListener(btnErabiltzaile.getActionListeners()[0]);
		
		JButton btnErabiltzaile = ViewMetodoak.btnErabiltzaileaSortu();
		btnErabiltzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrameSortu.premiumErregistroAukeraSortu(frame);
			}
		});

		JButton btnAtzera = ViewMetodoak.btnAtzeraSortu();

		contentPane.add(btnErabiltzaile);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.add(btnAtzera);

		JPanel panel = new JPanel();
		panel.setBounds(10, 152, 359, 389);
		contentPane.add(panel);
		
		ArrayList<Audio> abestiak = AbestiaDao.getAbestiakByAlbum(album);
		DefaultListModel<Audio> modeloList = new DefaultListModel();
		for (int i = 0; i < abestiak.size(); i++) {
			modeloList.addElement(abestiak.get(i));
		}
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JList list = new JList(modeloList);

		list.setBounds(100, 5, 0, 0);

		JScrollPane scrollPane = new JScrollPane(list);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(373, 121, 469, 223);
		contentPane.add(panel_1);

		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);

		// irudia seteatu lbl-ari
		ViewMetodoak.setIrudia(lblNewLabel, album.getIrudia());

		// Deskripzioa
		JTextPane textPane = new JTextPane();
		JScrollPane scrollPane_1 = new JScrollPane(textPane);
		textPane.setText(album.toString());
		scrollPane_1.setBounds(373, 378, 469, 166);
		contentPane.add(scrollPane_1);

		// Izena lbl
		lblIzena = new JLabel("");
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblIzena.setText(album.getIzenburua());
		lblIzena.setBounds(373, 63, 295, 38);
		contentPane.add(lblIzena);

		JLabel lblLista = new JLabel("Aukeratu Albuma: ");
		lblLista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLista.setBounds(111, 127, 162, 14);
		contentPane.add(lblLista);
		
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					int abestiAukera = list.getSelectedIndex();
					dispose();
					JFrameSortu.erreprodukzioaSortu(klasea,musikaria, abestiak, abestiAukera, true, 1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

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
