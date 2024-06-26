package view.bezeroa;

import java.awt.EventQueue;

import java.text.DateFormat;
import java.text.ParseException;

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
import model.salbuespenak.PasahitzaEzKointziditu;
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import model.*;
import model.dao.ErabiltzaileFreeDao;
import model.dao.ErabiltzaileaDao;
import model.dao.HizkuntzaDao;

public class Erregistroa extends JFrame {

	protected static final long serialVersionUID = 1L;
	protected static final String String = null;
	protected JPanel contentPane;
	protected JComboBox cboHizkuntza = new JComboBox();
	protected JTextField txtIzena;
	protected JTextField txtAbizenak;
	protected JTextField txtErabiltzailea;
	protected JTextField txtJaiotzeData;
	protected JPasswordField passwordField;
	protected JPasswordField passwordFieldErrepikatu;
	protected DefaultComboBoxModel<String> cboModelHizkuntza = new DefaultComboBoxModel<>();
	private boolean idatzi = true;
	protected JButton btnErregistratu;
	protected JButton btnAtzera;
	protected Date jaioData;

	public boolean isIdatzi() {
		return idatzi;
	}

	public void setIdatzi(boolean idatzi) {
		this.idatzi = idatzi;
	}

	/**
	 * Create the frame.
	 */
	public Erregistroa() {
		setBackground(Color.WHITE);
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
		txtIzena.setEditable(idatzi);

		JLabel lblAbizenak = new JLabel("Abizenak:");
		lblAbizenak.setBounds(480, 80, 94, 23);
		lblAbizenak.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		txtAbizenak = new JTextField();
		txtAbizenak.setBounds(600, 80, 174, 29);
		txtAbizenak.setToolTipText("Sartu abizenak...");
		txtAbizenak.setColumns(10);
		txtAbizenak.setBorder(new LineBorder(Color.GRAY, 1, true));

		txtAbizenak.setEditable(idatzi);

		JLabel lblErabiltzailea = new JLabel("Erabiltzailea:");
		lblErabiltzailea.setBounds(80, 140, 94, 23);
		lblErabiltzailea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		txtErabiltzailea = new JTextField();
		txtErabiltzailea.setBounds(220, 140, 300, 29);
		txtErabiltzailea.setToolTipText("Sartu erabiltzailea...");
		txtErabiltzailea.setColumns(10);
		txtErabiltzailea.setBorder(new LineBorder(Color.GRAY, 1, true));

		txtErabiltzailea.setEditable(idatzi);

		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(80, 200, 94, 23);
		lblPasahitza.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		passwordField = new JPasswordField();
		passwordField.setBounds(220, 200, 174, 29);
		passwordField.setToolTipText("Sartu pasahitza...");
		passwordField.setBorder(new LineBorder(Color.GRAY, 1, true));

		passwordField.setEditable(idatzi);

		JLabel lblPasahitzaErrepikatu = new JLabel("Konfirmatu:");
		lblPasahitzaErrepikatu.setBounds(480, 200, 103, 23);
		lblPasahitzaErrepikatu.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		passwordFieldErrepikatu = new JPasswordField();
		passwordFieldErrepikatu.setBounds(600, 200, 174, 29);
		passwordFieldErrepikatu.setToolTipText("Sartu pasahitza berriz...");
		passwordFieldErrepikatu.setBorder(new LineBorder(Color.GRAY, 1, true));

		passwordFieldErrepikatu.setEditable(idatzi);

		JLabel lblJaiotzeData = new JLabel("Jaiotze Data:");
		lblJaiotzeData.setBounds(80, 260, 129, 23);
		lblJaiotzeData.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		txtJaiotzeData = new JTextField();
		txtJaiotzeData.setBounds(220, 260, 200, 32);
		txtJaiotzeData.setToolTipText("yyyy-MM-dd");
		txtJaiotzeData.setColumns(10);
		txtJaiotzeData.setBorder(new LineBorder(Color.GRAY, 1, true));

		txtJaiotzeData.setEditable(idatzi);

		JLabel lblHizkuntza = new JLabel("Hizkuntza:");
		lblHizkuntza.setBounds(80, 340, 129, 23);
		lblHizkuntza.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
		
		ArrayList<Hizkuntza> hizkuntzak = HizkuntzaDao.getHizkuntzak();
		for (int i = 0; i<hizkuntzak.size();i++) {
			cboModelHizkuntza.addElement(hizkuntzak.get(i).getIdHizkuntza());
		}
		cboHizkuntza.setModel(cboModelHizkuntza);
		cboHizkuntza.setBounds(220, 340, 136, 29);
		contentPane.add(cboHizkuntza);

		cboHizkuntza.setEnabled(idatzi);

		btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(200, 462, 136, 29);
		btnAtzera.setForeground(SystemColor.text);
		btnAtzera.setBackground(SystemColor.desktop);
		btnAtzera.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));

		btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setBounds(600, 462, 136, 29);
		btnErregistratu.setForeground(SystemColor.text);
		btnErregistratu.setBackground(SystemColor.desktop);
		btnErregistratu.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));

		addComponents(lblErregistroa_Header, lblIzena, txtIzena, lblAbizenak, txtAbizenak, lblErabiltzailea,
				txtErabiltzailea, lblPasahitza, passwordField, lblPasahitzaErrepikatu, passwordFieldErrepikatu,
				lblJaiotzeData, txtJaiotzeData, lblHizkuntza, cboHizkuntza, btnAtzera, btnErregistratu);

		btnErregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datuakEzarri();
			}
		});

		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameSortu.loginSortu();
				dispose();
			}
		});
	}

	protected void datuakEzarri() {
		try {

			if (!balidatu()) {
				JOptionPane.showMessageDialog(null, "Data txarto edo Daturen Bat bete gabe", "heyyy!!",
						JOptionPane.WARNING_MESSAGE);
			} else {
				jaioData = balidatuData(txtJaiotzeData.getText());

				if (!passwordField.getText().equals(passwordFieldErrepikatu.getText())) {
					throw new PasahitzaEzKointziditu();
				}

				if (jaioData.after(new Date())) {
					JOptionPane.showMessageDialog(null, "Data oso handia!!!", "heyyy!!", JOptionPane.WARNING_MESSAGE);
				} else {

					ErabiltzaileFree erabiltzaileFree = new ErabiltzaileFree(0, txtErabiltzailea.getText(),
							passwordField.getText(), txtIzena.getText(), txtAbizenak.getText(),
							new java.sql.Date(jaioData.getTime()), (String) cboHizkuntza.getSelectedItem());

					if (!ErabiltzaileFreeDao.erregistratuErabiltzailea(erabiltzaileFree)) {
						JOptionPane.showMessageDialog(null, "Erabiltzaile hori badago ya sortuta", "heyyy!!",
								JOptionPane.WARNING_MESSAGE);
					} else {

						ViewMetodoak.comprobatuLogin(txtErabiltzailea.getText(), passwordField.getText());
						dispose();
						JFrameSortu.menuNagusiaAukeraSortu();
					}
				}

			}

		} catch (PasahitzaEzKointziditu e1) {
			JOptionPane.showMessageDialog(null, "Pasahitzak ez dira berdinak", "heyyy!!", JOptionPane.WARNING_MESSAGE);

		}
	}

	protected void atzeraEraman() {
		dispose();
		JFrameSortu.loginSortu();
	}

	protected void addComponents(Component... components) {
		for (Component component : components) {
			contentPane.add(component);
		}
	}

	public static Date balidatuData(String fechaString) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);

		try {
			return dateFormat.parse(fechaString);
		} catch (ParseException e) {
			return null;
		}
	}

	public boolean balidatu() {
		boolean beteta = true;
		if (txtErabiltzailea.getText().equals("") || passwordField.getText().equals("") || txtIzena.getText().equals("")
				|| txtAbizenak.getText().equals("") || balidatuData(txtJaiotzeData.getText()) == null) {
			beteta = false;
		}
		return beteta;

	}
}