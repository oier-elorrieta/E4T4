package view;

import java.awt.EventQueue;

import java.text.DateFormat;
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

	public ErregistroaPremium() {
		super();
		JLabel lblPremiumMuga = new JLabel("Premium muga:");
		lblPremiumMuga.setBounds(440, 260, 129, 23);
		lblPremiumMuga.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		model = new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH);
		JSpinner spinner = new JSpinner(model);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
 
		editor.getTextField().setEditable(false);
		
		model.setStart(new Date());

		spinner.setEditor(editor);
		spinner.setBounds(580, 260, 200, 32);
        
		super.addComponents(lblPremiumMuga, spinner);
		
        JButton btnGorde = new JButton("Aldatu datuak");
        btnGorde.setBounds(380, 462, 170, 29);
        btnGorde.setForeground(SystemColor.text);
        btnGorde.setBackground(SystemColor.desktop);
        btnGorde.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        
        contentPane.add(btnGorde);
        
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (isIdatzi()) {
                	spinner.setValue(model.getPreviousValue());
                }
            }
        });
        
        
        btnGorde.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                if (btnGorde.getText().equals("Aldatu datuak")) {
                    btnGorde.setText("Gorde");
                    setIdatzi(true);
                } else {
                    btnGorde.setText("Aldatu datuak");
                    setIdatzi(false);
                }
                txtIzena.setEditable(isIdatzi());
                txtAbizenak.setEditable(isIdatzi());
                txtErabiltzailea.setEditable(isIdatzi());
                passwordField.setEditable(isIdatzi());
                passwordFieldErrepikatu.setEditable(isIdatzi());
                txtJaiotzeData.setEditable(isIdatzi());
                cboHizkuntza.setEnabled(isIdatzi());
        }});
	}

	@Override
	protected void datuakEzarri() {
		try {
			if (!passwordField.getText().equals(passwordFieldErrepikatu.getText())) {
				throw new pasahitzaEzKointziditu();
			}
			String[] data = txtJaiotzeData.getText().split("-");
			Date jaioData = new Date(Integer.parseInt(data[0]) - 1900, Integer.parseInt(data[1]) - 1,
					Integer.parseInt(data[2]));
			ErabiltzailePremium erabiltzailepremium = new ErabiltzailePremium(0, txtErabiltzailea.getText(),
					passwordField.getText(), txtIzena.getText(), txtAbizenak.getText(), jaioData,
					(String) cboHizkuntza.getSelectedItem(), model.getDate());

			Kone.erregistratuPremium(erabiltzailepremium);
			ViewMetodoak.comprobatuLogin(txtErabiltzailea.getText(), passwordField.getText());
			dispose();
			JFrameSortu.menuNagusiaAukeraSortu();
		} catch (pasahitzaEzKointziditu e1) {
			System.err.println(e1.getMessage());
		}
	}
}