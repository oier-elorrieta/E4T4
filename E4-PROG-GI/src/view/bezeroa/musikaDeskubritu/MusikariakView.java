package view.bezeroa.musikaDeskubritu;

import model.metodoak.*;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MusikariakView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame = this;

	public MusikariakView() {
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(96, 121, 686, 372);

		JPanel artistaPane = new JPanel(new GridLayout(0, 1));
		artistaPane.setBounds(96, 121, 686, 372);
		jsp.setViewportView(artistaPane);

		// Musikarien botoiak atera
		ViewMetodoak.musikariakEntzunaldiakBotoiarentzako(artistaPane, this);

		// Erabiltzailearen datuak aldatzeko botoia
		JButton btnErabiltzaile = ViewMetodoak.btnErabiltzaileaSortu();

		// Aurreko pantallara joan
		JButton btnAtzera = ViewMetodoak.btnAtzeraSortu();

		contentPane.add(jsp, BorderLayout.CENTER);
		contentPane.add(btnErabiltzaile);
		contentPane.add(btnAtzera);

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
				JFrameSortu.menuNagusiaAukeraSortu();
			}
		});
	}
}
