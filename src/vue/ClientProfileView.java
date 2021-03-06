package vue;

import clientSocket.SocketClientProfile;
import connexion.PoolDeConnexion;
import dao.ClientDAO;
import pojo.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Ilies
 * @version 1.0
 * This view allows user to connect throught pseudo and password to their profile
 * The user has to add his personal information, and he'll be redirected to his profile view
 */
public class ClientProfileView extends JFrame {

    private JLabel connectionText = new JLabel("Please log in to see your profile: ");
    private JLabel espada = new JLabel("PhyGit Mall");
    private Font police = new Font("Arial", Font.BOLD, 14);
    private Font policeEspada = new Font("Arial", Font.BOLD, 28);
    public JTextField jtfPseudo = new JTextField("pseudo");
    public JTextField jtfPassword = new JTextField("password");
    private boolean displayConnectionScreen = true;
    private JButton connectionButton = new JButton("Connection");
    private JPanel container = new JPanel();
    public ClientProfileView(){
        this.setTitle("PhyGit Mall: My Profile");
        this.setSize(600,600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        jtfPseudo.getFont().deriveFont(Font.ITALIC);
        jtfPseudo.setForeground(Color.gray);
        jtfPseudo.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            /**
             * mouseListener: when the user click on the form, the grey text disappears to let him add his login
             */
            public void mouseClicked(MouseEvent e) {
                JTextField t1 = ((JTextField)e.getSource());
                t1.setText("");
                t1.getFont().deriveFont(Font.PLAIN);
                t1.setForeground(Color.black);
                t1.removeMouseListener(this);
            }
        });
        jtfPassword.getFont().deriveFont(Font.ITALIC);
        jtfPassword.setForeground(Color.gray);
        jtfPassword.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            /**
             * mouseListener: when the user click on the form, the grey text disappears to let him add his login
             */
            public void mouseClicked(MouseEvent e) {
                JTextField t2 = ((JTextField)e.getSource());
                t2.setText("");
                t2.getFont().deriveFont(Font.PLAIN);
                t2.setForeground(Color.black);
                t2.removeMouseListener(this);
            }
        });
        espada.setFont(policeEspada);
        connectionButton.addActionListener(new ConnectionButton());
        JPanel top = new JPanel();
        JPanel west = new JPanel();
        JPanel east = new JPanel();
        JPanel center = new JPanel();
        JPanel bot = new JPanel();
        top.setPreferredSize(new Dimension(100,250));
        center.setPreferredSize(new Dimension(100,60));
        west.setPreferredSize(new Dimension(100,600));
        east.setPreferredSize(new Dimension(100,600));
        bot.setPreferredSize(new Dimension(100,250));
        GridLayout layoutCenter = new GridLayout(2,1);
        GridLayout layoutTop = new GridLayout(1,2);
        top.setLayout(layoutTop);
        center.setLayout(layoutCenter);
        top.add(espada);
        top.add(connectionText);
        container.setLayout(new BorderLayout());
        center.add(jtfPseudo);
        center.add(jtfPassword);
        bot.add(connectionButton);
        container.add(top, BorderLayout.NORTH);
        container.add(center, BorderLayout.CENTER);
        container.add(bot, BorderLayout.SOUTH);
        container.add(east, BorderLayout.EAST);
        container.add(west, BorderLayout.WEST);

        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setContentPane(container);
        this.setVisible(displayConnectionScreen);
    }

    /**
     * Intern class ConnectionButton. When the user clicks on the button, his login and password are send to the server.
     *
     */
    private class ConnectionButton implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String pseudo = jtfPseudo.getText();
            String password = jtfPassword.getText();
            SocketClientProfile s1 = new SocketClientProfile();
            Client c1 = s1.getClientInformation(pseudo, password);
            System.out.println("retour du serveur OK button");
            if(c1 == null){
                System.out.println("Rentré dans if");
                JFrame fenResp = new JFrame();
                JPanel containerResp = new JPanel();
                fenResp.setSize(150,150);
                fenResp.setLocationRelativeTo(null);
                JLabel jlabResp = new JLabel("Wrong pseudo/password" );
                containerResp.add(jlabResp, BorderLayout.CENTER);
                fenResp.setContentPane(containerResp);
                fenResp.setVisible(true);
                jtfPseudo.setText("pseudo");
                jtfPassword.setText("password");
            }
            else{

                ClientProfileViewConnected vc1 = new ClientProfileViewConnected(c1);
                dispose();
            }
        }
    }
}
