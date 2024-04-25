package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class probaButton extends JFrame {
    private JPanel buttonPanel;

    public probaButton() {
        setTitle("Button Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1)); // GridLayout con una sola columna y filas automáticas

        getContentPane().add(buttonPanel, BorderLayout.CENTER);

        JButton addButton = new JButton("Añadir Botón");
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuando se hace clic en el botón "Añadir Botón", se agrega un nuevo botón al panel
                JButton newButton = new JButton();
                newButton.setText("Fito y los fitipaldis");
                ImageIcon icono = new ImageIcon("C:\\Users\\in1dm3-d\\Desktop\\4.Erronka\\E4T4\\E4-PROG-GI\\src\\img\\acdc.png");

                // Escala la imagen al tamaño deseado
                Image imagen = icono.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);

                // Crea un nuevo ImageIcon con la imagen escalada
                ImageIcon iconoEscalado = new ImageIcon(imagen);
                newButton.setIcon(iconoEscalado);
                

                
                buttonPanel.add(newButton);

                // Se actualiza el layout del panel para que se ajuste automáticamente
                buttonPanel.revalidate();
                buttonPanel.repaint();
            }
        });
        getContentPane().add(addButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	probaButton buttonGenerator = new probaButton();
                buttonGenerator.setVisible(true);
            }
        });
    }
}

