package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import javax.swing.JList;
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
		
		ArrayList<PlayListak> p = new ArrayList<PlayListak>();
		Date d = new Date();
		PlayListak pprueba = new PlayListak(1,"Boutnout Sindromes",d);
		p.add(pprueba);
		
		
		DefaultListModel<PlayListak> modeloLista = new DefaultListModel<>();
		modeloLista.addElement(p.get(0));	
		
		JList<String> jListPlayList = new JList(modeloLista);
		jListPlayList.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scrollPane = new JScrollPane(jListPlayList);	
		jListPlayList.setBounds(50, 150, 550, 350);
		
		JButton btnBerriaSortu = new JButton("Berria Sortu");
		btnBerriaSortu.setBounds(650, 175, 208, 50);
		btnBerriaSortu.setFont(new Font("SansSerif", Font.BOLD, 22));
		
		JButton btnEzabatu = new JButton("Berria Sortu");
		btnEzabatu.setBounds(650, 250, 208, 50);
		btnEzabatu.setFont(new Font("SansSerif", Font.BOLD, 22));
		
		JButton btnImportatu = new JButton("Importatu");
		btnImportatu.setBounds(650, 325, 208, 50);
		btnImportatu.setFont(new Font("SansSerif", Font.BOLD, 22));
		
		JButton btnExportatu = new JButton("Exportatu");
		btnExportatu.setBounds(650, 400, 208, 50);
		btnExportatu.setFont(new Font("SansSerif", Font.BOLD, 22));
		
		contentPane.add(jListPlayList);
		contentPane.add(btnBerriaSortu);
		contentPane.add(btnEzabatu);
		contentPane.add(btnImportatu);
		contentPane.add(btnExportatu);
		contentPane.add(btnAtzera);
		contentPane.add(btnErabiltzaile);

		btnBerriaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.loginAukeraSortu();
			}
		});

		btnErabiltzaile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SesioAldagaiak.erabiltzaileLogeatutaFree = null;
				SesioAldagaiak.erabiltzaileLogeatutaPremium = null;
				dispose();
				JFrameSortu.loginAukeraSortu();
			}
		});
	}
}
