package view;

import java.awt.EventQueue;

import java.text.DateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.View;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.mindrot.jbcrypt.BCrypt;

import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.sql.Kone;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class Erregistroa extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String String = null;
	private JPanel contentPane;
	private JTextField txtIzena;
	private JTextField txtAbizenak;
	private JTextField txtErabiltzailea;
	private JTextField txtJaiotzeData;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldErrepikatu;
	private DefaultComboBoxModel<String> cboModelHizkuntza = new DefaultComboBoxModel<>(); 

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {	
			
			public void run() {
				try {
					Erregistroa frame = new Erregistroa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Erregistroa() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 906, 594);
		setTitle("Erregistroa - Talde 4");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErregistroa_Header = new JLabel("ERREGISTROA");
		lblErregistroa_Header.setBounds(325, 11, 190, 27);
		lblErregistroa_Header.setHorizontalAlignment(SwingConstants.CENTER);
		lblErregistroa_Header.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));

		JLabel lblIzena = new JLabel("Izena: ");
		lblIzena.setBounds(80, 80, 69, 23);
		lblIzena.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		txtIzena = new JTextField();
		txtIzena.setBounds(220, 80, 174, 29);
		txtIzena.setToolTipText("Sartu izen bat...");
		txtIzena.setColumns(10);
		txtIzena.setBorder(new LineBorder(Color.GRAY, 1, true));
		
		JLabel lblAbizenak = new JLabel("Abizenak:");
		lblAbizenak.setBounds(480, 80, 94, 23);
		lblAbizenak.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		txtAbizenak = new JTextField();
		txtAbizenak.setBounds(600, 80, 174, 29);
		txtAbizenak.setToolTipText("Sartu abizenak...");
		txtAbizenak.setColumns(10);
		txtAbizenak.setBorder(new LineBorder(Color.GRAY, 1, true));
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setBounds(80, 140, 94, 23);
		lblErabiltzailea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		txtErabiltzailea = new JTextField();
		txtErabiltzailea.setBounds(220, 140, 300, 29);
		txtErabiltzailea.setToolTipText("Sartu erabiltzailea...");
		txtErabiltzailea.setColumns(10);
		txtErabiltzailea.setBorder(new LineBorder(Color.GRAY, 1, true));
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(80, 200, 94, 23);
		lblPasahitza.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		passwordField = new JPasswordField();
		passwordField.setBounds(220, 200, 174, 29);
		passwordField.setToolTipText("Sartu pasahitza...");
		passwordField.setBorder(new LineBorder(Color.GRAY, 1, true));
		
		JLabel lblPasahitzaErrepikatu = new JLabel("Konfirmatu:");
		lblPasahitzaErrepikatu.setBounds(480, 200, 103, 23);
		lblPasahitzaErrepikatu.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		passwordFieldErrepikatu = new JPasswordField();
		passwordFieldErrepikatu.setBounds(600, 200, 174, 29);
		passwordFieldErrepikatu.setToolTipText("Sartu pasahitza berriz...");
		passwordFieldErrepikatu.setBorder(new LineBorder(Color.GRAY, 1, true));
		
		JLabel lblJaiotzeData = new JLabel("Jaiotze Data:");
		lblJaiotzeData.setBounds(80, 260, 129, 23);
		lblJaiotzeData.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		txtJaiotzeData = new JTextField();
		txtJaiotzeData.setBounds(220, 260, 300, 32);
		txtJaiotzeData.setToolTipText("Sartu Jaiotze Data...");
		txtJaiotzeData.setColumns(10);
		txtJaiotzeData.setBorder(new LineBorder(Color.GRAY, 1, true));
		
		JLabel lblHizkuntza = new JLabel("Hizkuntza:");
		lblHizkuntza.setBounds(80, 340, 129, 23);
		lblHizkuntza.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		
		JComboBox cboHizkuntza = new JComboBox();
		cboModelHizkuntza = ViewMetodoak.cboHizkuntzaModeloaSortu(cboModelHizkuntza);
		cboHizkuntza.setModel(cboModelHizkuntza);
		cboHizkuntza.setBounds(220, 340, 136, 29);
		contentPane.add(cboHizkuntza);
		
		
		/*JComboBox<String> cboHiz = new JComboBox();
		String[] hiz = {"ES","EU","EN","FR","DE","CA","GA","AR"};
		for (String i: hiz) {
			cboHiz.addItem(i);
		}
		cboHiz.setBounds(220, 340, 136, 29);*/
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(269, 462, 136, 29);
		btnAtzera.setForeground(SystemColor.text);
		btnAtzera.setBackground(SystemColor.desktop);
		btnAtzera.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		
		JButton btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setBounds(480, 462, 136, 29);
		btnErregistratu.setForeground(SystemColor.text);
		btnErregistratu.setBackground(SystemColor.desktop);
		btnErregistratu.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		
		contentPane.add(lblErregistroa_Header);
		contentPane.add(lblIzena);
		contentPane.add(txtIzena);
		contentPane.add(lblAbizenak);
		contentPane.add(txtAbizenak);
		contentPane.add(lblErabiltzailea);
		contentPane.add(txtErabiltzailea);
		contentPane.add(lblPasahitza);
		contentPane.add(passwordField);
		contentPane.add(lblPasahitzaErrepikatu);
		contentPane.add(passwordFieldErrepikatu);
		contentPane.add(lblJaiotzeData);
		contentPane.add(txtJaiotzeData);
		contentPane.add(lblHizkuntza);
	//	contentPane.add(cboHiz);
		contentPane.add(cboHizkuntza);
		contentPane.add(btnAtzera);
		contentPane.add(btnErregistratu);
		
		btnErregistratu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				Kone.erregistratu(txtIzena.getText().trim(),txtAbizenak.getText().trim(),txtErabiltzailea.getText().trim(),passwordField.getText(), txtJaiotzeData.getText() ,(String)cboHizkuntza.getSelectedItem());	
				dispose();
				JFrameSortu.menuNagusiaAukeraSortu();
			}
		});
		
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				JFrameSortu.loginAukeraSortu();
			}
		});
	}
}