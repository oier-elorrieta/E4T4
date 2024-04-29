package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Album;
import model.metodoak.ViewMetodoak;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;

public class MusikariView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	public MusikariView(String izena) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnErabiltzaile = model.SesioAldagaiak.jb;

		JButton btnAtzera = new JButton("Atzera");

		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);

		contentPane.add(btnErabiltzaile);
		contentPane.setLayout(null);
		contentPane.add(btnAtzera);

		JPanel panel = new JPanel();
		panel.setBounds(10, 121, 870, 423);
		contentPane.add(panel);

		DefaultListModel<Album> modeloList = ViewMetodoak.getMusikariAlbumak(izena);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JList list = new JList(modeloList);
		
		list.setBounds(50, 150, 550, 350);

		JScrollPane scrollPane = new JScrollPane(list);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		textField = new JTextField();
		textField.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		panel_1.add(textField);
		textField.setColumns(10);
		
		
		textField.setText("ssssssssssssssssssssssssssssssssssssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaa"
				+ "aaaaaa");;

	

	}
}
