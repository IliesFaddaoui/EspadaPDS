package vue;

import javax.swing.*;
import java.awt.*;

public class ClientProfileViewConnected extends JFrame {

    public ClientProfileViewConnected(int idClient){
        this.setSize(new Dimension(600,600));
        JLabel connected = new JLabel("connected ! client n°" + idClient);
        JPanel container = new JPanel();
        container.add(connected, BorderLayout.CENTER);
        this.add(container);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
