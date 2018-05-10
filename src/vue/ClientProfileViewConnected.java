package vue;

import pojo.Client;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ilies
 * @version 1.0
 * This view shows to user his profile data, after his connection
 */
public class ClientProfileViewConnected extends JFrame {

    private Font police = new Font("Arial", Font.BOLD, 14);
    private Font policeEspada = new Font("Arial", Font.BOLD, 28);

    public ClientProfileViewConnected(Client client){


        this.setTitle("PhyGit Mall: My Profile");
        this.setSize(new Dimension(600,600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        JLabel welcomeClient = new JLabel("Welcome, "+client.getClientSurname() + " "+ client.getClientName() +"!" );
        JLabel espada = new JLabel("PhyGit Mall");
        JLabel myProfile = new JLabel("MY PROFILE:");

        JLabel login = new JLabel("login:");
        JLabel address = new JLabel("address:");
        JLabel phone = new JLabel("phone :");
        JLabel gender = new JLabel("gender:");
        JLabel loginClient = new JLabel(client.getPseudo());
        JLabel addressClient = new JLabel(client.getAddress());
        JLabel phoneClient = new JLabel(client.getPhone());
        JLabel genderClient = new JLabel(client.getGender());

        JButton updateProfile = new JButton("Update My profile");
        JButton generatePath = new JButton("Generate path");
        updateProfile.setFont(police);
        generatePath.setFont(police);

        JPanel top = new JPanel();
        JPanel west = new JPanel();
        JPanel east = new JPanel();
        JPanel center = new JPanel();
        JPanel bot = new JPanel();


        top.setPreferredSize(new Dimension(100,250));
        center.setPreferredSize(new Dimension(100,60));
        center.setBorder(BorderFactory.createLineBorder(Color.black));
        west.setPreferredSize(new Dimension(100,600));
        east.setPreferredSize(new Dimension(100,600));
        bot.setPreferredSize(new Dimension(100,250));

        GridLayout layoutTop = new GridLayout(2,2);
        GridLayout layoutCenter = new GridLayout(4,2);
        GridLayout layoutEast = new GridLayout(2,4);
        GridLayout layoutWest = new GridLayout(2,4);
        top.setLayout(layoutTop);
        center.setLayout(layoutCenter);
        east.setLayout(layoutEast);
        west.setLayout(layoutWest);

        espada.setFont(policeEspada);
        myProfile.setFont(policeEspada);
        top.add(espada);
        top.add(welcomeClient);
        top.add(myProfile);

        center.add(login);
        center.add(loginClient);
        center.add(address);
        center.add(addressClient);
        center.add(phone);
        center.add(phoneClient);
        center.add(gender);
        center.add(genderClient);

        bot.add(updateProfile);
        bot.add(generatePath);

        this.add(top, BorderLayout.NORTH);
        this.add(west, BorderLayout.WEST);
        this.add(east, BorderLayout.EAST);
        this.add(bot, BorderLayout.SOUTH);
        this.add(center, BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
