package view.bezeroa.podcastDeskubritu;

import model.SesioAldagaiak;
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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class PodcasterrakView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frame = this;

	public PodcasterrakView() {
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnErabiltzaile = SesioAldagaiak.jb;
		btnErabiltzaile.removeActionListener(btnErabiltzaile.getActionListeners()[0]);

		btnErabiltzaile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrameSortu.premiumErregistroAukeraSortu(frame);
			}
		});

		JButton btnAtzera = ViewMetodoak.btnAtzeraSortu();

		contentPane.add(btnErabiltzaile);
		contentPane.add(btnAtzera);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(96, 121, 686, 372);

		contentPane.add(jsp, BorderLayout.CENTER);

		JPanel artistaPane = new JPanel(new GridLayout(0, 1));
		artistaPane.setBounds(96, 121, 686, 372);
		jsp.setViewportView(artistaPane);

		ViewMetodoak.podcasterrakEntzunaldiakBotoiarentzako(artistaPane, this);

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.menuNagusiaAukeraSortu();
			}
		});

		
	}
}
