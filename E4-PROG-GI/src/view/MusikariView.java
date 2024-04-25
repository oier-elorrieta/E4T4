package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.metodoak.ViewMetodoak;

public class MusikariView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	
	public MusikariView(String izena) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel(new BorderLayout());
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
		contentPane.add(btnAtzera);
		
		setContentPane(contentPane);
	}

}
