package vue;

import clientSocket.SocketCreateEmplacement;
import clientSocket.SocketDeleteEmplacement;
import clientSocket.SocketFindEmplacement;
import com.google.gson.*;
import pojo.Emplacements;
import pojo.Magasins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author ilies, axel
 * @version 1.2
 * This class with GUI, and the operations made through socket to send requests to server
 */
public class View extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel container = new JPanel();
    public JTextField jtf = new JTextField();
    public JTextField jtf2 = new JTextField();
    public JTextField jtf3 = new JTextField();
    public JTextField jtf4 = new JTextField();
    public JTextField jtf5 = new JTextField();
    public JTextField jtfFind = new JTextField();
    public JTextField jtfDelete = new JTextField();

    private JLabel label = new JLabel("idEmplacement :");
    private JLabel label2 = new JLabel("Localisation :");
    private JLabel label3 = new JLabel ("Superficie: ");
    private JLabel label4 = new JLabel ("categorie:");
    private JLabel label5 = new JLabel ("taux occupation:");
    private JLabel labelAdd = new JLabel("Ajouter un emplacement:");
    private JLabel labelFind = new JLabel ("Chercher un emplacement:");
    private JLabel labelDelete = new JLabel("Supprimer un emplacement");

    /**
     * Constructor with main frame code
     */
    public View(){
        this.setTitle("PhyGit Mall: Gestion du référentiel Emplacement ");
        this.setSize(600, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);
        container.setLayout(new GridLayout(2,10));

        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JPanel middle = new JPanel();
        Font police = new Font("Arial", Font.BOLD, 14);

        jtf.setFont(police);
        jtf.setPreferredSize(new Dimension(150, 30));
        jtf.setForeground(Color.BLUE);
        jtf2.setFont(police);
        jtf2.setPreferredSize(new Dimension(150, 30));
        jtf2.setForeground(Color.BLUE);
        jtf3.setFont(police);
        jtf3.setPreferredSize(new Dimension(150, 30));
        jtf3.setForeground(Color.BLUE);
        jtf4.setFont(police);
        jtf4.setPreferredSize(new Dimension(150, 30));
        jtf4.setForeground(Color.BLUE);
        jtf5.setFont(police);
        jtf5.setPreferredSize(new Dimension(150, 30));
        jtf5.setForeground(Color.BLUE);
        jtfFind.setFont(police);
        jtfFind.setPreferredSize(new Dimension(150, 30));
        jtfFind.setForeground(Color.BLUE);
        jtfDelete.setFont(police);
        jtfDelete.setPreferredSize(new Dimension(150, 30));
        jtfDelete.setForeground(Color.BLUE);

        JButton buttonAdd = new JButton("Valider");
        JButton buttonDisplay  = new JButton("Afficher Emplacement");
        JButton buttonDelete = new JButton("Supprimer Emplacement");

        buttonAdd.addActionListener(new BoutonAjout());
        buttonDisplay.addActionListener(new BoutonAfficher());
        buttonDelete.addActionListener(new BoutonSupprimer());

        top.add(labelAdd);
        top.add(label);
        top.add(jtf);
        top.add(label2);
        top.add(jtf2);
        top.add(label3);
        top.add(jtf3);
        top.add(label4);
        top.add(jtf4);
        top.add(label5);
        top.add(jtf5);
        top.add(buttonAdd);

        middle.add(labelFind);
        middle.add(jtfFind);
        middle.add(buttonDisplay);


        bottom.add(labelDelete);
        bottom.add(jtfDelete);
        bottom.add(buttonDelete);

        container.add(top, BorderLayout.NORTH);
        container.add(middle, BorderLayout.CENTER);
        container.add(bottom, BorderLayout.SOUTH);


        this.setContentPane(container);
        this.setVisible(true);
    }

    /**
     * Class which defines the action when someone click on "Bouton ajouter"
     * This control the input made by users, and return error messages in new temporal frame if
     * any problems is find
     * This send to server the kind of action wanted (add element in database here),
     * the information from the users are then processed into json file, which is send to server
     * Then, the client wait for server response, and show the operation result on a new temporal frame
     */
    private class BoutonAjout implements ActionListener {

        public void actionPerformed(ActionEvent e){
            try{

                int txt = Integer.parseInt(jtf.getText());
                String txt2 = jtf2.getText();
                int txt3 = Integer.parseInt(jtf3.getText());
                String txt4 = jtf4.getText();
                float txt5 = Float.parseFloat(jtf5.getText());
                Emplacements p = new Emplacements(txt, txt2, txt3, txt4, txt5);
                SocketCreateEmplacement s1 = new SocketCreateEmplacement(p);
                jtf.setText("");
                jtf2.setText("");
                jtf3.setText("");
                jtf4.setText("");
                jtf5.setText("");
            }
            catch (Exception e4) {
                JFrame fenResp = new JFrame();
                JPanel containerResp = new JPanel();
                fenResp.setSize(600,300);
                fenResp.setLocationRelativeTo(null);
                JLabel jlabResp = new JLabel(e4.getMessage());
                containerResp.add(jlabResp, BorderLayout.CENTER);
                fenResp.setContentPane(containerResp);
                fenResp.setVisible(true);
                jtf.setText("");
                jtf2.setText("");
                jtf3.setText("");
                jtf4.setText("");
                jtf5.setText("");

            }
        }
    }
    /**
     * Class which defines the action when someone click on "Bouton afficher"
     * This control the input made by users, and return error messages in new temporal frame if
     * any problems is find
     * This send to server the kind of action wanted (find element in database here),
     * the information from the users are then processed into json file, which is send to server
     * Then, the client wait for server response, and show the operation result on a new temporal frame.
     * If succeed, the information about the asked emplacement are displayed on a temporal frame, if
     * the asked emplacement doesn't exist, a error message is displayed instead
     */
    private class BoutonAfficher implements ActionListener{
        public void actionPerformed(ActionEvent event){
            try{
                int nbr = Integer.parseInt(jtfFind.getText());
                Emplacements e1 = new Emplacements( nbr, "", 0, "", 0);
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                String data = gson.toJson(e1);
                try {
                    SocketFindEmplacement s1 = new SocketFindEmplacement(e1);
                    jtfFind.setText("");
                }
                catch (Exception e4) {
                    JFrame fenResp = new JFrame();
                    JPanel containerResp = new JPanel();
                    fenResp.setSize(600,300);
                    fenResp.setLocationRelativeTo(null);
                    JLabel jlabResp = new JLabel(e4.getMessage());
                    containerResp.add(jlabResp, BorderLayout.CENTER);
                    fenResp.setContentPane(containerResp);
                    fenResp.setVisible(true);
                    jtfFind.setText("");
                }
            }catch(NumberFormatException en){
                JFrame fenResp = new JFrame();
                JPanel containerResp = new JPanel();
                fenResp.setSize(600,300);
                fenResp.setLocationRelativeTo(null);
                JLabel jlabResp = new JLabel("Problème avec les infos entrées: " + en.getMessage());
                containerResp.add(jlabResp, BorderLayout.CENTER);
                fenResp.setContentPane(containerResp);
                fenResp.setVisible(true);
                jtfFind.setText("");
            }
        }
    }
    /**
     * Class which defines the action when someone click on "Bouton supprimer"
     * This control the input made by users, and return error messages in new temporal frame if
     * any problems is find
     * This send to server the kind of action wanted (delete element in database here),
     * the information from the users are then processed into json file, which is send to server
     * Then, the client wait for server response, and show the operation result on a new temporal frame.
     * If succeed,a new temporal frame said that the emplacement has been deleted, else the message on the temporal
     * frame says that the elements doesn't exist, and cannot be deleted them
     */
    private class BoutonSupprimer implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try{
                int nbr = Integer.parseInt(jtfDelete.getText());
                Emplacements e1 = new Emplacements( nbr, "", 0, "", 0);

                try {

                    jtfDelete.setText("");
                    SocketDeleteEmplacement s1 = new SocketDeleteEmplacement(e1);
                }
                catch (Exception e4) {
                    JFrame fenResp = new JFrame();
                    JPanel containerResp = new JPanel();
                    fenResp.setSize(600,300);
                    fenResp.setLocationRelativeTo(null);
                    JLabel jlabResp = new JLabel(e4.getMessage());
                    containerResp.add(jlabResp, BorderLayout.CENTER);
                    fenResp.setContentPane(containerResp);
                    fenResp.setVisible(true);
                    jtfDelete.setText("");
                }
            }catch(NumberFormatException en){
                JFrame fenResp = new JFrame();
                JPanel containerResp = new JPanel();
                fenResp.setSize(600,300);
                fenResp.setLocationRelativeTo(null);
                JLabel jlabResp = new JLabel("Problème avec les infos entrées: " + en.getMessage());
                containerResp.add(jlabResp, BorderLayout.CENTER);
                fenResp.setContentPane(containerResp);
                fenResp.setVisible(true);
                jtfFind.setText("");
            }
        }
    }

    /**
     * Private method which read the data send by the server to the client, and return it
     * into string.
     * @param reader
     * @return Strign
     * @throws IOException
     */

    private String read(BufferedInputStream reader) throws IOException{

        String response = "";

        int stream;

        byte[] b = new byte[4096];

        stream = reader.read(b);

        response = new String(b, 0, stream);

        return response;

    }

}
