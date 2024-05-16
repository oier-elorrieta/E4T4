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
import model.Musikaria;
import model.Interfazeak.IAtzeraIzan;
import model.Interfazeak.IProfilaIzan;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;

import javax.swing.JScrollPane;

import javax.swing.JList;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextPane;

public class AlbumakView extends JFrame implements IAtzeraIzan, IProfilaIzan{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIzena;
	private JFrame frame = this;

	public AlbumakView(Musikaria musikaria) {
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Musikariaren izena atera
		lblIzena = new JLabel(musikaria.getIzena());
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblIzena.setBounds(373, 63, 295, 38);

		JLabel lblAlbumaAukeratu = new JLabel("Aukeratu Albuma: ");
		lblAlbumaAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlbumaAukeratu.setBounds(111, 127, 162, 14);

		JPanel panel = new JPanel();
		panel.setBounds(10, 152, 359, 389);

		// //Listaren modeloa bete musikariaren albumekin
		DefaultListModel<Album> modeloList = ViewMetodoak.getMusikariAlbumak(musikaria.getIzena());
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		// Modeloa Listan implementatu
		JList list = new JList(modeloList);
		list.setBounds(100, 5, 0, 0);
		JScrollPane scrollPane = new JScrollPane(list);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(373, 121, 469, 223);

		// Musikariaren irudia atera
		JLabel lblIrudia = new JLabel("");
		panel_1.add(lblIrudia);
		ViewMetodoak.setIrudia(lblIrudia, musikaria.getIrudia());

		// Musikariaren deskripzioa
		JTextPane txtMusikariDeskripzioa = new JTextPane();
		txtMusikariDeskripzioa.setEditable(false);
		JScrollPane scrollPane_1 = new JScrollPane(txtMusikariDeskripzioa);
		txtMusikariDeskripzioa.setText(musikaria.getDeskription());
		scrollPane_1.setBounds(373, 378, 469, 166);

		// Erabiltzailearen datuak aldatzeko botoia
		JButton btnErabiltzaile = ViewMetodoak.btnErabiltzaileaSortu();

		// Aurreko pantallara joan
		JButton btnAtzera = ViewMetodoak.btnAtzeraSortu();

		contentPane.add(lblIzena);
		contentPane.add(lblAlbumaAukeratu);
		contentPane.add(panel);
		contentPane.add(panel_1);
		contentPane.add(scrollPane_1);
		contentPane.add(btnErabiltzaile);
		contentPane.setLayout(null);
		contentPane.add(btnAtzera);

		// Listean album bat aukeratzean, albumaren abestiak jframera joan
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Album selectedValue = (Album) list.getSelectedValue();
				dispose();
				JFrameSortu.abestiakViewSortu(musikaria, selectedValue);
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
				JFrameSortu.musikariakViewSortu();
			}
		});

	}
}
