package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import model.metodoak.JFrameSortu;


public class AdminMenuNagusia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	
	public AdminMenuNagusia() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Menu Nagusia - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblaukeratu = new JLabel("Aukeratu");
		lblaukeratu.setBounds(198, 11, 452, 58);
		lblaukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblaukeratu.setFont(new Font("Source Sans Pro Black", Font.BOLD, 45));

		JButton btnMusikaKudeatu = new JButton("Musika Kudeatu");

		btnMusikaKudeatu.setBounds(150, 175, 550, 54);
		btnMusikaKudeatu.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnMusikaKudeatu.setFocusPainted(false);

		JButton btnPodcastKudeatu = new JButton("Podcast Kudeatu");
		btnPodcastKudeatu.setBounds(150, 275, 550, 54);
		btnPodcastKudeatu.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnPodcastKudeatu.setFocusPainted(false);

		JButton btnEstadistikak = new JButton("Estadistikak");
		btnEstadistikak.setBounds(150, 375, 550, 54);
		btnEstadistikak.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnEstadistikak.setFocusPainted(false);

		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.BLACK);
		btnAtzera.setForeground(Color.RED);
		btnAtzera.setBounds(50, 60, 144, 50);
		btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAtzera.setFocusPainted(false);

		

	
		contentPane.add(lblaukeratu);
		contentPane.add(btnMusikaKudeatu);
		contentPane.add(btnPodcastKudeatu);
		contentPane.add(btnEstadistikak);
		contentPane.add(btnAtzera);
		

		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.loginAukeraSortu();
			}
		});

		
		
		btnMusikaKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});

		btnPodcastKudeatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnEstadistikak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		
		
	}

}
