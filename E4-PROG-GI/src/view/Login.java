package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import model.*;
import model.metodoak.JFrameSortu;
import model.sql.Kone;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String String = null;
	private JPanel contentPane;
	private JTextField txtNAN;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Login - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin_Header = new JLabel("LOGIN");
		lblLogin_Header.setBounds(198, 11, 452, 58);
		lblLogin_Header.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin_Header.setFont(new Font("Source Sans Pro Black", Font.BOLD, 45));
		
		JLabel lblErabiltzailea = new JLabel("ERABILTZAILEA");
		lblErabiltzailea.setBounds(210, 165, 204, 23);
		lblErabiltzailea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		
		txtNAN = new JTextField();
		txtNAN.setBounds(210, 191, 433, 32);
		txtNAN.setColumns(10);
		
		JLabel lblPasahitza = new JLabel("PASAHITZA");
		lblPasahitza.setBounds(210, 254, 204, 23);
		lblPasahitza.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 281, 433, 33);
		
		JComboBox cboErabiltzaileMota = new JComboBox();
		cboErabiltzaileMota.setModel(new DefaultComboBoxModel(new String[] {"Bezeroa", "Administratzailea"}));
		cboErabiltzaileMota.setBounds(210, 350, 433, 33);
		cboErabiltzaileMota.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		
		JButton btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setBounds(342, 420, 148, 29);
		btnErregistratu.setForeground(SystemColor.text);
		btnErregistratu.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnErregistratu.setBackground(SystemColor.desktop);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(342, 460, 148, 29);
		btnLogin.setForeground(SystemColor.text);
		btnLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnLogin.setBackground(SystemColor.desktop);
		
		contentPane.add(lblLogin_Header);
		contentPane.add(lblErabiltzailea);
		contentPane.add(txtNAN);
		contentPane.add(lblPasahitza);
		contentPane.add(passwordField);
		contentPane.add(cboErabiltzaileMota);
		contentPane.add(btnErregistratu);
		contentPane.add(btnLogin);
		
	
		
		
		btnErregistratu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();		
				JFrameSortu.erregistroAukeraSortu();
			}
		});
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
}