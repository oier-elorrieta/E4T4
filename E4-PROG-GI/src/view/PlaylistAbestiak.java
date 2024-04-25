package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Abestia;
import model.PlayListak;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

public class PlaylistAbestiak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PlaylistAbestiak(PlayListak aukeraPlaylist) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<Abestia> abestiakList = Kone.getPlayListAbestiak(aukeraPlaylist);
		
		DefaultListModel<Abestia> modeloLista = new DefaultListModel<>();
		for (int i = 0; i < abestiakList.size(); i++) {
			modeloLista.addElement(abestiakList.get(i));
		}
		JList<Abestia> jListAbestiak = new JList(modeloLista);
		jListAbestiak.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scrollPane = new JScrollPane(jListAbestiak);
		jListAbestiak.setBounds(50, 150, 550, 350);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);
		
		JButton btnErabiltzaile = ViewMetodoak.btnErabiltzaileaSortu();
		
		contentPane.add(jListAbestiak);
		contentPane.add(btnAtzera);
		contentPane.add(btnErabiltzaile);

	}

}
