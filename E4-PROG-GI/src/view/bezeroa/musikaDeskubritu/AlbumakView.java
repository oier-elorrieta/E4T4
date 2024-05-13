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

import model.Album;
import model.Musikaria;
import model.dao.MusikariaDao;
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
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class AlbumakView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Musikaria musikari;
	private JLabel lblIzena;
	private JFrame frame = this;
	
	public AlbumakView(Musikaria musikaria) {
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnErabiltzaile = model.SesioAldagaiak.jb;
		btnErabiltzaile.removeActionListener(btnErabiltzaile.getActionListeners()[0]);

		btnErabiltzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrameSortu.premiumErregistroAukeraSortu(frame);
			}
		});

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(50, 60, 144, 50);

		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);

		contentPane.add(btnErabiltzaile);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.add(btnAtzera);

		JPanel panel = new JPanel();
		panel.setBounds(10, 152, 359, 389);
		contentPane.add(panel);

		DefaultListModel<Album> modeloList = ViewMetodoak.getMusikariAlbumak(musikaria.getIzena());
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

		// Aukeratutako musikaria
		musikari = MusikariaDao.getMusikaria(musikaria.getIzena());

		// irudia seteatu lbl-ari
		ViewMetodoak.setIrudia(lblNewLabel, musikari.getIrudia());

		// Deskripzioa
		JTextPane textPane = new JTextPane();
		JScrollPane scrollPane_1 = new JScrollPane(textPane);
		textPane.setText(musikari.getDeskription());
		scrollPane_1.setBounds(373, 378, 469, 166);
		contentPane.add(scrollPane_1);

		// Izena lbl
		lblIzena = new JLabel("");
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblIzena.setText(musikari.getIzena());
		lblIzena.setBounds(373, 63, 295, 38);
		contentPane.add(lblIzena);

		JLabel lblLista = new JLabel("Aukeratu Albuma: ");
		lblLista.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLista.setBounds(111, 127, 162, 14);
		contentPane.add(lblLista);

		
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Album selectedValue = (Album) list.getSelectedValue();
				dispose();
				JFrameSortu.abestiakViewSortu(musikaria, selectedValue);
			}
		});

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.musikariakViewSortu();
			}
		});

	}
}
