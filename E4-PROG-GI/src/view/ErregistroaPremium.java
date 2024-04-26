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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;
import java.util.Date;

import model.*;

public class ErregistroaPremium extends Erregistroa {
	
	SpinnerDateModel model;
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
        model.setStart(new Date());
        
        spinner.setEditor(editor);
        spinner.setBounds(580, 260, 200, 32);
        super.addComponents(lblPremiumMuga, spinner);
	}
	
	@Override
	protected void datuakEzarri() {
		try {
			if (!passwordField.getText().equals(passwordFieldErrepikatu.getText())) {
				throw new pasahitzaEzKointziditu();
			}
			String[] data = txtJaiotzeData.getText().split("-");
			Date jaioData = new Date(Integer.parseInt(data[0])-1900, Integer.parseInt(data[1])-1,Integer.parseInt(data[2]));
			ErabiltzailePremium erabiltzailepremium = new ErabiltzailePremium(0,txtErabiltzailea.getText(), passwordField.getText(), txtIzena.getText(),txtAbizenak.getText(), jaioData ,(String) cboHizkuntza.getSelectedItem(),
					model.getDate());
			Kone.erregistratuPremium(erabiltzailepremium);
			ViewMetodoak.comprobatuLogin(txtErabiltzailea.getText(), passwordField.getText());
			dispose();
			JFrameSortu.menuNagusiaAukeraSortu();
		} catch (pasahitzaEzKointziditu e1) {
			System.err.println(e1.getMessage());
		} 
	}
}