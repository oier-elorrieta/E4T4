package view.admin;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import model.metodoak.JFrameSortu;


public class EstadistikaMenua extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    
    
    public EstadistikaMenua() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 250, 906, 594);
        setTitle("Estadistikak");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblaukeratu = new JLabel("Estadistikak");
        lblaukeratu.setBounds(198, 11, 452, 58);
        lblaukeratu.setHorizontalAlignment(SwingConstants.CENTER);
        lblaukeratu.setFont(new Font("Source Sans Pro Black", Font.BOLD, 45));

        JButton btnGustokoAbesti = new JButton("Top Gustoko Abestiak");

        btnGustokoAbesti.setBounds(150, 175, 550, 54);
        btnGustokoAbesti.setFont(new Font("Segoe UI", Font.BOLD, 21));
        btnGustokoAbesti.setFocusPainted(false);
        
        btnGustokoAbesti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EstadistikakAbestiak ea = new EstadistikakAbestiak();
                dispose();
                ea.setVisible(true);
            }
        });

        JButton btnGustokoPodcast = new JButton("Top Gustoko Podcast");
        btnGustokoPodcast.setBounds(150, 275, 550, 54);
        btnGustokoPodcast.setFont(new Font("Segoe UI", Font.BOLD, 21));
        btnGustokoPodcast.setFocusPainted(false);
        
        btnGustokoPodcast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EstadistikakPodcast ep = new EstadistikakPodcast();
                dispose();
                ep.setVisible(true);
            }
        });
        
        JButton btnEntzunda = new JButton("Top Entzundakoak");
        btnEntzunda.setBounds(150, 375, 550, 54);
        btnEntzunda.setFont(new Font("Segoe UI", Font.BOLD, 21));
        btnEntzunda.setFocusPainted(false);
        btnEntzunda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	EstadistikakEntzunda ee = new EstadistikakEntzunda();
                dispose();
                ee.setVisible(true);
            }
        });
        
        JButton btnPlaylist = new JButton("Top Playlist");
        btnPlaylist.setBounds(150, 475, 550, 54);
        btnPlaylist.setFont(new Font("Segoe UI", Font.BOLD, 21));
        btnPlaylist.setFocusPainted(false);

        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.setBackground(Color.BLACK);
        btnAtzera.setForeground(Color.RED);
        btnAtzera.setBounds(50, 60, 144, 50);
        btnAtzera.setFont(new Font("SansSerif", Font.BOLD, 22));
        btnAtzera.setFocusPainted(false);

        

    
        contentPane.add(lblaukeratu);
        contentPane.add(btnGustokoAbesti);
        contentPane.add(btnGustokoPodcast);
        contentPane.add(btnEntzunda);
        contentPane.add(btnPlaylist);
        contentPane.add(btnAtzera);
        

        btnAtzera.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                JFrameSortu.loginSortu();
            }
        });

        
        
        btnGustokoAbesti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                
                
            }
        });

        btnGustokoPodcast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        btnEntzunda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        btnPlaylist.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        
        
        
    }

}