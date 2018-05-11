package vue;

import javax.swing.*;
import java.awt.*;

public class ServerAnswerView extends JFrame{
    public ServerAnswerView(String message) {
        JLabel containerResp = new JLabel();
        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        JLabel jlabResp = new JLabel("Client not found");
        if (message.equals("NOEXIST")) {
            this.setTitle("Error...");
            jlabResp.setText("Client not found ");
        }
        else if (message.equals("EMPTY")) {
            this.setTitle("Error...");
            jlabResp.setText("You don't have any purchase ! Service unavailable ");
        }
        else if (message.equals("NPERTINENT")) {
            this.setTitle("Error...");
            jlabResp.setText("You don't have enough purchase to use this service !");
        }
        else if (message.equals("NOTPLINKED")) {
            this.setTitle("Error...");
            jlabResp.setText("You don't have enough purchase to use this service !");
        }
        else if(message.equals("SUCCESS")) {
            this.setTitle("Success !");
            jlabResp.setText("<html>You profile has been updated !</br> Click on Generate path to have a personalize path </br> according to your purchase habit !</html>");
        }
        else{
            this.setTitle("Error !");
            jlabResp.setText("Something seems wrong on the server, please try again !");
        }
        this.setContentPane(jlabResp);
        this.setVisible(true);
    }
}
