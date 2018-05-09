package vue;

import javax.swing.*;
import java.awt.*;

public class ClientProfileView extends JFrame {

    private JLabel connectionText = new JLabel("Please log in to see your profile: ");
    private JLabel espada = new JLabel("PhyGit Mall");
    private Font police = new Font("Arial", Font.BOLD, 14);
    private JLabel labelConnection;
    public JTextField jtfPseudo = new JTextField("pseudo");
    public JTextField jtfPassword = new JTextField("password");
    private boolean isConnected = false;
    private int idClientConnected = 0;
    private JButton connectionButton = new JButton("Connection");
    private JPanel container = new JPanel();

    public ClientProfileView(){
        this.setTitle("PhyGit Mall: My Profile");
        this.setSize(600,600);

        JPanel top = new JPanel();
        JPanel west = new JPanel();
        JPanel center = new JPanel();
        JPanel bot = new JPanel();
        GridLayout layoutCenter = new GridLayout(2,1);
        center.setLayout(layoutCenter);
        top.add(connectionText);
        container.setLayout(new BorderLayout());
        center.add(jtfPseudo);
        center.add(jtfPassword);

        bot.add(connectionButton);

        container.add(top, BorderLayout.NORTH);
        container.add(center, BorderLayout.CENTER);
        container.add(bot, BorderLayout.SOUTH);
        this.setContentPane(container);
        this.pack();
        this.setVisible(true);


    }
    public static void main(String[] args){
        ClientProfileView p1 = new ClientProfileView();
    }
}
