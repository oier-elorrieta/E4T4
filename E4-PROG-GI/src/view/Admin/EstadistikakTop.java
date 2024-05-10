package view.Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EstadistikakTop extends JFrame {
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
    getContentPane().add(scrollPane, BorderLayout.CENTER);
 
    JToolBar toolBar = new JToolBar();
    scrollPane.setColumnHeaderView(toolBar);
 
    JButton btnNewButton = new JButton("New button");
    scrollPane.setColumnHeaderView(btnNewButton);
 
    JToolBar toolBar_1 = new JToolBar();
    scrollPane.setColumnHeaderView(toolBar_1);
    getContentPane().add(buttonPanel, BorderLayout.SOUTH);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new  EstadistikakTop().setVisible(true);
        }
    });
}
}


