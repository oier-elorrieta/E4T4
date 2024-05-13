package view.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class EstadistikakTop extends JFrame {
    protected DefaultTableModel model = new DefaultTableModel();
    protected JScrollPane scrollPane;
    JButton btnAstea;
    JButton btnHilabetea;
    JButton btnUrtea;

    public EstadistikakTop() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Estadistikak");
        setBounds(400, 250, 906, 594);

        model.addColumn("Pos");

        JTable table = new JTable(model);
        scrollPane = new JScrollPane(table);

        getContentPane().setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();

        JButton btnAtzera = new JButton("Atzera");

        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EstadistikaMenua genero_lehioa = new EstadistikaMenua();
                dispose();
                genero_lehioa.setVisible(true);
            }
        });

        btnAstea = new JButton("Egunekoa");
        btnHilabetea = new JButton("Hilabetekoa");
        btnUrtea = new JButton("Urtekoa");

        buttonPanel.add(btnAtzera);
        buttonPanel.add(btnAstea);
        buttonPanel.add(btnHilabetea);
        buttonPanel.add(btnUrtea);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JToolBar toolBar = new JToolBar();
        scrollPane.setColumnHeaderView(toolBar);

        JToolBar toolBar_1 = new JToolBar();
        scrollPane.setColumnHeaderView(toolBar_1);
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
    }
}