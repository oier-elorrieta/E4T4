package view.bezeroa;

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
import model.metodoak.ViewMetodoak;
import model.sql.Kone;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String String = null;
	private JPanel contentPane;
	private JTextField txtErabiltzaile;
	private JPasswordField passwordField;

	public Login() {
		setBounds(400, 250, 906, 594);
		setTitle("Login - Talde 4");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Login izena sortu
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(198, 60, 452, 58);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Source Sans Pro Black", Font.BOLD, 45));

		// Erabiltzailea lbl sortu
		JLabel lblErabiltzailea = new JLabel("ERABILTZAILEA");
		lblErabiltzailea.setBounds(210, 165, 204, 23);
		lblErabiltzailea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		// Sortu erabiltzailea jartzeko field-a
		txtErabiltzaile = new JTextField();
		txtErabiltzaile.setBounds(210, 191, 433, 32);
		txtErabiltzaile.setColumns(10);

		// lbl Pasahitza sortu
		JLabel lblPasahitza = new JLabel("PASAHITZA");
		lblPasahitza.setBounds(210, 254, 204, 23);
		lblPasahitza.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		// Pasahitza jartzeko field-a egin
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 281, 433, 33);

		// Hizkuntza aukeratzeko combobox-a sortu
		JComboBox cboErabiltzaileMota = new JComboBox();
		cboErabiltzaileMota.setModel(new DefaultComboBoxModel(new String[] { "Bezeroa", "Administratzailea" }));
		cboErabiltzaileMota.setBounds(210, 350, 433, 33);
		cboErabiltzaileMota.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		// Erregistratzeko botoia sortu
		JButton btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setBounds(342, 420, 148, 29);
		btnErregistratu.setForeground(SystemColor.text);
		btnErregistratu.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnErregistratu.setBackground(SystemColor.desktop);

		// Logeatzeko botoia sortu
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(342, 460, 148, 29);
		btnLogin.setForeground(SystemColor.text);
		btnLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnLogin.setBackground(SystemColor.desktop);

		contentPane.add(lblLogin);
		contentPane.add(lblErabiltzailea);
		contentPane.add(txtErabiltzaile);
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
				if (cboErabiltzaileMota.getSelectedItem().equals("Bezeroa")) {
					if (ViewMetodoak.comprobatuLogin(txtErabiltzaile.getText(), passwordField.getText())) {
						dispose();
						JFrameSortu.menuNagusiaAukeraSortu();
					} else {
						JOptionPane.showMessageDialog(null, "Pasahitza edo erabiltzailea txarto!!", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (Kone.konektatuAdminKomprobatu(txtErabiltzaile.getText(), passwordField.getText())) {
					JFrameSortu.menuAdminAukeraSortu();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Pasahitza edo erabiltzailea txarto!!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}