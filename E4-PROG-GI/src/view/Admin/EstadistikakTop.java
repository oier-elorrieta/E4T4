package view.Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
<<<<<<< HEAD
=======

>>>>>>> 237ab0f8450cae3371db81e02f3bd32dbe755367
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EstadistikakTop extends JFrame {
<<<<<<< HEAD
	private DefaultTableModel model;
	private int selectedRow = -1;
	private int idnumber = 1;
	int denborafinala =0 ;
	
	private int[] generohautaketa = {0,0,0,0};
	 public static ArrayList<String> dramap = new ArrayList<String>(List.of("La lista de Schrindler", "Cadena Perpetua", "Milion Dollar Baybe", "Handia"));
	   public static ArrayList<String> komediap = new ArrayList<String>(List.of("El gran Lebowski", "La vida de Brian", "Scary movie", "Aterriza como puedas"));
	   public static ArrayList<String> zfp = new ArrayList<String>(List.of("2001: Odisea en el espacio", "Alien, el octavo pasajero", "El planeta de los simios", "La novia de Frankenstein"));
	   public static ArrayList<String> beldurrap = new ArrayList<String>(List.of("Dracula", "El resplandor", "Cisne negro", "Psicosis"));
	   private static ArrayList<String> dramad = new ArrayList<String>(List.of("195", "142", "132", "114"));
	   public static ArrayList<String> komediad = new ArrayList<String>(List.of("117", "93", "88", "88"));
	   public static ArrayList<String> beldurrad = new ArrayList<String>(List.of("130", "146", "109", "108"));
	   public static ArrayList<String> zfd = new ArrayList<String>(List.of("139", "116", "112", "75"));
	
	private int denboraS = 480;
	private int denboraI= 360;
	
	
public  EstadistikakTop() {
	
    // Configurar la ventana principal
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Custom JTable Example");
    setSize(500, 300);
    // Crear el modelo de la tabla
    model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Pelikula");
    model.addColumn("Kategoria");
    model.addColumn("Denbora");
    model.addColumn("Aukera");
    // Crear la tabla con el modelo personalizado
 
    JTable table = new JTable(model);
    // Agregar un ActionListener al radio button para gestionar la selección única
    table.getColumnModel().getColumn(4).setCellEditor(new RadioButtonEditor());
    table.getColumnModel().getColumn(4).setCellRenderer(new RadioButtonRenderer());
 
    // Agregar la tabla a un JScrollPane
    JScrollPane scrollPane = new JScrollPane(table);
  
    //AQUI ES DONDE CREO QUE ESTA EL ERROR, LO QUE COMENTAMOS CON KOLDO EL VIERNES Y DEBUGEAMOS Y TAL
    // model aldagaian filmnak kargatzen ditu.
   // Modelo.ezarrikat(aukeratutako_generoa, denboraS, denboraI, model, zenbatFilma);
     // Crear un botón para agregar nuevas filas
    JButton addButton = new JButton("Gehitu aukerarutako filma");
    addButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    		
 	
    }
    });
 
    // Agregar componentes a la ventana
    getContentPane().setLayout(new BorderLayout());
    JPanel buttonPanel = new JPanel();
 
    JButton btnBueltagenero = new JButton("CANCELAR");
    btnBueltagenero.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    	 GeneroAutaketaMenua genero_lehioa = new GeneroAutaketaMenua();
      genero_lehioa.setVisible(true);
   
    	}
    });
    buttonPanel.add(btnBueltagenero);
    buttonPanel.add(addButton);
=======
	protected DefaultTableModel model = new DefaultTableModel();

public  EstadistikakTop() {

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Estadistikak");
    setBounds(400, 250, 906, 594);
    
    
    //model.addColumn("ID");
 
    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);
 
    getContentPane().setLayout(new BorderLayout());
    JPanel buttonPanel = new JPanel();
 
    JButton btnBueltagenero = new JButton("EstadistikaMenua");
    
    btnBueltagenero.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		EstadistikaMenua genero_lehioa = new EstadistikaMenua();
    		dispose();
    		genero_lehioa.setVisible(true);
    	}
    });
    
    buttonPanel.add(btnBueltagenero);
>>>>>>> 237ab0f8450cae3371db81e02f3bd32dbe755367
    getContentPane().add(scrollPane, BorderLayout.CENTER);
 
    JToolBar toolBar = new JToolBar();
    scrollPane.setColumnHeaderView(toolBar);
 
    JButton btnNewButton = new JButton("New button");
    scrollPane.setColumnHeaderView(btnNewButton);
 
    JToolBar toolBar_1 = new JToolBar();
    scrollPane.setColumnHeaderView(toolBar_1);
    getContentPane().add(buttonPanel, BorderLayout.SOUTH);
}
<<<<<<< HEAD
 /**
 *
 * @param denboraBerria
 */
public void setdenboraS(int denboraBerria) {
		this.denboraS = denboraBerria;
	}
// Clase interna para gestionar el renderizado de los radio buttons
/**
 *
 */
class RadioButtonRenderer implements TableCellRenderer {
    private JRadioButton button;
    public RadioButtonRenderer() {
        button = new JRadioButton();
        button.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        button.setSelected((value != null && (Boolean) value));
        return button;
    }
}
// Clase interna para gestionar la edición de los radio buttons
class RadioButtonEditor extends DefaultCellEditor implements ActionListener {
    private JRadioButton button;
    public RadioButtonEditor() {
        super(new JCheckBox());
        this.button = new JRadioButton();
        this.button.setHorizontalAlignment(SwingConstants.CENTER);
        button.addActionListener(this);
    }
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        selectedRow = row;
        button.setSelected((value != null && (Boolean) value));
        return button;
    }
    //Komprobatu bakarrik RB bat aukeratuta dagoela
    public Object getCellEditorValue() {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (i == selectedRow) {
                model.setValueAt(true, i, 4);
            } else {
                model.setValueAt(false, i, 4);
            }
        }
        return true;
    }
    public void actionPerformed(ActionEvent e) {
        super.fireEditingStopped();
    }
}
public void aukeratutafila (JTable table) {
        // Obtener la fila seleccionada
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) { // Verificar si se ha seleccionado alguna fila
            // Obtener el valor del idnumber de la fila seleccionada
            Object idObject = table.getValueAt(selectedRow, 0); // Suponiendo que la columna del ID es la primera
            if (idObject != null) {
                int selectedIdNumber = (int) idObject; // Suponiendo que el ID es un entero
                System.out.println("ID Number: " + selectedIdNumber); // Imprimir el ID en la consola
                // Aquí puedes hacer lo que necesites con el ID obtenido
          
            }
        }
}
public void pelikuladenbora (JTable table, int selectedRow) {
	    // Obtén el valor de la celda como un objeto
	    String value = (String)table.getValueAt(selectedRow, 3);
	 
	    // Intenta convertir el objeto a un entero
	        int filmdenbora = Integer.parseInt(value);
	        // Ahora, filmdenbora contiene el valor como un entero
	        System.out.println("Hau da filmaren denbora " + filmdenbora);
	}
public void denborakenketa(JTable table, int selectedRow, int denboratotalaL, int denboratotalaI ) {
	   String denborakendu = (String)table.getValueAt(selectedRow, 3);
	
	   if(denboratotalaL > 0) {
		  denboratotalaL -= Integer.parseInt(denborakendu);
	   }
	   setdenboraS(denboratotalaL);
	
}
=======

>>>>>>> 237ab0f8450cae3371db81e02f3bd32dbe755367
public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new  EstadistikakTop().setVisible(true);
        }
    });
}
}


