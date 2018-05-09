package vue;

import pojo.Client;

import javax.swing.*;
import java.awt.*;

public class ClientProfileViewConnected extends JFrame {

    public ClientProfileViewConnected(Client client){
        this.setSize(new Dimension(600,600));
        JLabel connected = new JLabel("connected ! client n°" + client.getIdClient());
        JPanel container = new JPanel();
        container.add(connected, BorderLayout.CENTER);
        this.add(container);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
