package vue;

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


//import static sun.plugin2.util.PojoUtil.toJson;

public class View extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel container = new JPanel();
    public JTextField jtf = new JTextField();
    public JTextField jtf2 = new JTextField();
    public JTextField jtf3 = new JTextField();
    public JTextField jtf4 = new JTextField();
    public JTextField jtf5 = new JTextField();
    private JLabel label = new JLabel("idEmplacement :");
    private JLabel label2 = new JLabel("Localisation :");
    private JLabel label3 = new JLabel ("Superficie: ");
    private JLabel label4 = new JLabel ("categorie:");
    private JLabel label5 = new JLabel ("taux occupation:");
    public View(){
        this.setTitle("Nouveau client");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        container.setBackground(Color.white);
        container.setLayout(new GridLayout(2,10));

        JPanel top = new JPanel();
        JPanel bot = new JPanel();
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
        JButton button = new JButton("Valider");
        button.addActionListener(new BoutonAjout());
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
        top.add(button);
        container.add(top, BorderLayout.WEST);
        container.add(bot, BorderLayout.EAST);



        this.setContentPane(container);
        this.setVisible(true);
    }




    class BoutonAjout implements ActionListener {

        public void actionPerformed(ActionEvent e){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            int txt = Integer.parseInt(jtf.getText());
            String txt2 = jtf2.getText();
            int txt3 = Integer.parseInt(jtf3.getText());
            String txt4 = jtf4.getText();
            float txt5 = Float.parseFloat(jtf5.getText());
            Emplacements p = new Emplacements(txt, txt2, txt3, txt4, txt5);


            String json = gson.toJson(p);
            System.out.print(json);
            File resultFile = new File("Emplacement.json");
            try {
                Socket s = new Socket(InetAddress.getLocalHost(),5000);
                PrintWriter w1 = new PrintWriter(s.getOutputStream(), true);
                w1.write(json);
                w1.flush();
                BufferedInputStream b2 = new BufferedInputStream(s.getInputStream());


            }
            catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

}
