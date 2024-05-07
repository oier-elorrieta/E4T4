package view;
// Hazme un test por cada una de las funciones que haya, cada uno de esos test solo puede tener un assert, las pruebas tienen que estar en Junit 4.
import java.awt.EventQueue;

import java.text.DateFormat;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.View;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.mindrot.jbcrypt.BCrypt;

import model.metodoak.JFrameSortu;
import model.metodoak.ViewMetodoak;
import model.salbuespenak.pasahitzaEzKointziditu;
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
import javax.swing.JSpinner;
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
import java.util.Iterator;
import java.util.Properties;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;
import java.util.Date;

import model.*;

public class ErregistroaPremium extends Erregistroa {

	private SpinnerDateModel model;
	JSpinner spinner;
	JSpinner.DateEditor editor;

	public ErregistroaPremium() {
		super();

		btnAtzera.removeActionListener(btnAtzera.getActionListeners()[0]);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrameSortu.menuNagusiaAukeraSortu();
				dispose();
				
			}
		});
		
		
		
<<<<<<< HEAD
		
=======
>>>>>>> 10a2f5de3a811ea7b3543010d594523d8dc07b96
		ActionListener[] actionListeners = super.btnErregistratu.getActionListeners();
		for (ActionListener listener : actionListeners) {
			btnErregistratu.removeActionListener(listener);
		}

		super.btnErregistratu.setText("Premium Buy");

		ezarriTextua();

		txtIzena.setEditable(isIdatzi());
		txtAbizenak.setEditable(isIdatzi());
		txtErabiltzailea.setEditable(isIdatzi());
		passwordField.setEditable(isIdatzi());
		passwordFieldErrepikatu.setEditable(isIdatzi());
		txtJaiotzeData.setEditable(isIdatzi());
		cboHizkuntza.setEnabled(isIdatzi());

		JLabel lblPremiumMuga = new JLabel("Premium muga:");
		lblPremiumMuga.setBounds(440, 260, 129, 23);
		lblPremiumMuga.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		Calendar calendar = Calendar.getInstance();

		if (SesioAldagaiak.erabiltzaileLogeatutaPremium != null) {
			
			calendar.setTime(SesioAldagaiak.erabiltzaileLogeatutaPremium.getPremiumMuga());
			model = new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH);
			spinner = new JSpinner(model);
			editor = new JSpinner.DateEditor(spinner, "yyyy-MM-dd");
			model.setStart(calendar.getTime());
			
		} else {
			
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			model = new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH);
			spinner = new JSpinner(model);
			editor = new JSpinner.DateEditor(spinner, "yyyy-MM-dd");
			model.setStart(new Date());
		}

		editor.getTextField().setEditable(false);

		spinner.setEditor(editor);
		spinner.setBounds(580, 260, 200, 32);

		super.addComponents(lblPremiumMuga, spinner);

		JButton btnGorde = new JButton("Aldatu datuak");
		btnGorde.setBounds(380, 462, 170, 29);
		btnGorde.setForeground(SystemColor.text);
		btnGorde.setBackground(SystemColor.desktop);
		btnGorde.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));

		contentPane.add(btnGorde);

		super.btnErregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (SesioAldagaiak.erabiltzaileLogeatutaPremium != null) {

					Date dat = SesioAldagaiak.erabiltzaileLogeatutaPremium.getPremiumMuga();
					dat = (Date) spinner.getValue();

					if (dat.after(calendar.getTime())) {
						// Premium data eguneratu (Urteak)
						gordePremium((java.util.Date) dat);
					} else {
						JOptionPane.showMessageDialog(null, "Premiuma Erosteko lehenik Premium muga Aldatu", "heyyy!!",
								JOptionPane.WARNING_MESSAGE);
					}

				} else {
					Date dat = new Date();
					dat = (Date) spinner.getValue();

					if (dat.after(calendar.getTime())) {
						// Premium data eguneratu (Urteak)
						gordePremium((java.util.Date) dat);
					} else {
						JOptionPane.showMessageDialog(null, "Premiuma Erosteko lehenik Premium muga Aldatu", "Error",
								JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});

		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnGorde.getText().equals("Aldatu datuak")) {
					btnGorde.setText("Gorde");
					setIdatzi(true);
				} else {
					if (balidatuAldaketak()) {
						// Datuak ondo daude
						btnGorde.setText("Aldatu datuak");
						setIdatzi(false);
					} else {
						if (Alerta()) {
							// Datuak aldatko ditu
						} else {
							// Datuak ez ditu aldatuko (Defektuz jarri datuak ala gorde BD)
							if (AlertaGorde()) {
								// Defektuz ezarri datuak
								btnGorde.setText("Aldatu datuak");
								ezarriTextua();
								setIdatzi(false);
							} else {
								// Konexioa datuak gordetzeko
								btnGorde.setText("Aldatu datuak");
								datuakEguneratu();
								setIdatzi(false);
							}

						}
					}

				}
				txtIzena.setEditable(isIdatzi());
				txtAbizenak.setEditable(isIdatzi());
				txtErabiltzailea.setEditable(isIdatzi());
				passwordField.setEditable(isIdatzi());
				passwordFieldErrepikatu.setEditable(isIdatzi());
				txtJaiotzeData.setEditable(isIdatzi());
				cboHizkuntza.setEnabled(isIdatzi());
				spinner.setEnabled(!isIdatzi());
			}
		});
	}

	public void ezarriTextua() {
		txtIzena.setText(SesioAldagaiak.logErabiltzailea.getIzena());
		txtAbizenak.setText(SesioAldagaiak.logErabiltzailea.getAbizena());
		txtErabiltzailea.setText(SesioAldagaiak.logErabiltzailea.getErabiltzailea());
		passwordField.setText(SesioAldagaiak.logErabiltzailea.getPasahitza());
		passwordFieldErrepikatu.setText(SesioAldagaiak.logErabiltzailea.getPasahitza());
		txtJaiotzeData.setText(AldatuData(SesioAldagaiak.logErabiltzailea.getJaiotzeData()));
		cboHizkuntza.setSelectedItem(SesioAldagaiak.logErabiltzailea.getHizkuntza());
		;
	}

	public String AldatuData(Date fecha) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(fecha);
	}

	protected void datuakEguneratu() {
		try {
			if (!passwordField.getText().equals(passwordFieldErrepikatu.getText())) {
				throw new pasahitzaEzKointziditu();
			}
			String[] data = txtJaiotzeData.getText().split("-");
			Date jaioData = new Date(Integer.parseInt(data[0]) - 1900, Integer.parseInt(data[1]) - 1,
					Integer.parseInt(data[2]));
			ErabiltzaileFree erabiltzailefree = new ErabiltzaileFree(0, txtErabiltzailea.getText(),
					passwordField.getText(), txtIzena.getText(), txtAbizenak.getText(),
					new java.sql.Date(jaioData.getTime()), (String) cboHizkuntza.getSelectedItem());
			Kone.eguneratuErabiltzailea(erabiltzailefree);
			ViewMetodoak.comprobatuLogin(txtErabiltzailea.getText(), passwordField.getText());
			dispose();
			JFrameSortu.menuNagusiaAukeraSortu();
		} catch (pasahitzaEzKointziditu e1) {
			System.err.println(e1.getMessage());
		}
	}

	private void gordePremium(Date eguna) {
		Kone.erregistratuPremium(SesioAldagaiak.logErabiltzailea.getIdErabiltzailea(),
				new java.sql.Date(eguna.getTime()));
	}

	private boolean balidatuAldaketak() {
		Erabiltzailea erabiltzailea = new Erabiltzailea();
		erabiltzailea.setIdErabiltzailea(4);
		erabiltzailea.setIzena(txtIzena.getText());
		erabiltzailea.setAbizena(txtAbizenak.getText());
		erabiltzailea.setHizkuntza((String) cboHizkuntza.getSelectedItem());
		erabiltzailea.setErabiltzailea(txtErabiltzailea.getText());

		erabiltzailea.setJaiotzeData(new java.sql.Date(balidatuData(txtJaiotzeData.getText()).getTime()));
		erabiltzailea.setPasahitza(passwordField.getText());

		return SesioAldagaiak.logErabiltzailea.equals(erabiltzailea);
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

	private boolean Alerta() {
		String[] opciones = { "Utzi", "Jarraitu" };
		int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Datuak desberdinak dira.", "Alerta",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[0]);

		if (opcionSeleccionada == JOptionPane.YES_OPTION) {
			return true;
		} else if (opcionSeleccionada == JOptionPane.NO_OPTION) {
			return false;
		}
		return false;
	}

	private boolean AlertaGorde() {
		String[] opciones = { "Berriro ezarri bezteak", "Eguneratu nire datuak" };
		int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Zer egin nahi duzu datuekin?.", "Alerta",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[0]);

		if (opcionSeleccionada == JOptionPane.YES_OPTION) {
			return true;
		} else if (opcionSeleccionada == JOptionPane.NO_OPTION) {
			return false;
		}
		return false;
	}
}
