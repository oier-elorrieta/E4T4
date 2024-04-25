package view;

import model.metodoak.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.metodoak.ViewMetodoak;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MusikaDeskubritu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MusikaDeskubritu(JButton btn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnErabiltzaile = btn;

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);

		contentPane.add(btnErabiltzaile);
		contentPane.add(btnAtzera);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(96, 121, 686, 372);

		contentPane.add(jsp, BorderLayout.CENTER);

		JPanel artistaPane = new JPanel(new GridLayout(0, 1));
		artistaPane.setBounds(96, 121, 686, 372);
		jsp.setViewportView(artistaPane);

		ViewMetodoak.musikariakEntzunaldiakBotoiarentzako(artistaPane);

		
		//Aqui los añado manualmente para ver que funciona la scrollvar porque en la db solo hay 2 musikaris metidos
		ViewMetodoak.btnGeneratu(artistaPane,"C:\\Users\\aitzo\\Desktop\\4.erronka\\E4T4\\E4-PROG-GI\\src\\img\\acdc.png","asdas");
		ViewMetodoak.btnGeneratu(artistaPane,"C:\\Users\\aitzo\\Desktop\\4.erronka\\E4T4\\E4-PROG-GI\\src\\img\\acdc.png","sdasdas");
		ViewMetodoak.btnGeneratu(artistaPane,"C:\\Users\\aitzo\\Desktop\\4.erronka\\E4T4\\E4-PROG-GI\\src\\img\\acdc.png","asdasd");
	}
}
