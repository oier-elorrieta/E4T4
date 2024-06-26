package view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Album;
import model.Audio;
import model.PlayListak;
import model.Interfazeak.IAtzeraIzan;
import model.dao.PlayListakDao;
import model.metodoak.JFrameSortu;
import model.metodoak.ViewAdminMetodoak;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class KudeatuPlantilla extends JFrame implements IAtzeraIzan{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    protected JButton btnAtzera;
    protected JScrollPane scrollPane;
    protected JList list;
    protected JLabel lblArtistaKude = new JLabel();
    protected JButton btnJarraitu;
    protected JButton btnEzabatu;
    protected JButton btnGehitu;
    protected JButton btnDatuakAldatu;

    
    public KudeatuPlantilla() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 250, 906, 594);
        setTitle("Menu Nagusia - Talde 4");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 124, 840, 355);
        contentPane.add(scrollPane);

        btnAtzera = new JButton("Atzera");
		btnAtzera.setBackground(Color.LIGHT_GRAY);
		btnAtzera.setForeground(Color.BLACK);
        btnAtzera.setBounds(50, 60, 144, 50);
        btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
        btnAtzera.setFocusPainted(false);
        contentPane.add(btnAtzera);

        
        

        lblArtistaKude.setFont(new Font("SansSerif", Font.PLAIN, 37));
        lblArtistaKude.setBounds(290, 60, 370, 53);
        contentPane.add(lblArtistaKude);

        btnJarraitu = new JButton("Albumak Ikusi");
		btnJarraitu.setBackground(Color.LIGHT_GRAY);
        btnJarraitu.setForeground(Color.black);
        btnJarraitu.setFont(new Font("SansSerif", Font.BOLD, 22));
        btnJarraitu.setFocusPainted(false);
        btnJarraitu.setBounds(50, 490, 187, 50);
        contentPane.add(btnJarraitu);
        
btnEzabatu = new JButton("Ezabatu");
        btnEzabatu.setForeground(Color.black);
        btnEzabatu.setFont(new Font("SansSerif", Font.BOLD, 22));
        btnEzabatu.setFocusPainted(false);
        btnEzabatu.setBackground(Color.LIGHT_GRAY);
        btnEzabatu.setBounds(247, 490, 187, 50);
        contentPane.add(btnEzabatu);

        btnGehitu = new JButton("Gehitu Artista");

        btnGehitu.setForeground(Color.black);
        btnGehitu.setFont(new Font("SansSerif", Font.BOLD, 22));
        btnGehitu.setFocusPainted(false);
        btnGehitu.setBackground(Color.LIGHT_GRAY);
        btnGehitu.setBounds(444, 490, 206, 50);
        contentPane.add(btnGehitu);

        btnDatuakAldatu = new JButton("Datuak aldatu");

        btnDatuakAldatu.setForeground(Color.black);
        btnDatuakAldatu.setFont(new Font("SansSerif", Font.BOLD, 22));
        btnDatuakAldatu.setFocusPainted(false);
        btnDatuakAldatu.setBackground(Color.LIGHT_GRAY);
        btnDatuakAldatu.setBounds(657, 490, 206, 50);
        contentPane.add(btnDatuakAldatu);

        btnAtzera.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                JFrameSortu.menuAdminAukeraSortu();
            }
        });

    }
}
