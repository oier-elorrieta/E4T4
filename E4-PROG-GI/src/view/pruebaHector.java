package view;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class pruebaHector {


	    public static JPanel createDatePickerPanel() {
	        JPanel panel = new JPanel();
	        panel.setLayout(new BorderLayout());
	        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

	        JLabel label = new JLabel("Seleccione una fecha:");
	        panel.add(label, BorderLayout.NORTH);

	        // Creamos un SpinnerDateModel con la fecha actual como valor inicial
	        SpinnerDateModel model = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
	        JSpinner spinner = new JSpinner(model);

	        // Personalizamos el formato de visualización del JSpinner
	        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
	        spinner.setEditor(editor);

	        panel.add(spinner, BorderLayout.CENTER);

	        return panel;
	    }

	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Test DatePicker");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(300, 200);

	        JPanel mainPanel = new JPanel();
	        mainPanel.setLayout(new BorderLayout());
	        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

	        JPanel datePickerPanel = createDatePickerPanel();
	        mainPanel.add(datePickerPanel, BorderLayout.CENTER);

	        JButton btnAceptar = new JButton("Aceptar");
	        btnAceptar.addActionListener(e -> {
	            JSpinner spinner = (JSpinner) ((JPanel) mainPanel.getComponent(0)).getComponent(1);
	            Date selectedDate = (Date) spinner.getValue();
	            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	            JOptionPane.showMessageDialog(frame, "Fecha seleccionada: " + sdf.format(selectedDate));
	        });
	        mainPanel.add(btnAceptar, BorderLayout.SOUTH);

	        frame.add(mainPanel);
	        frame.setVisible(true);
	    }
	}
