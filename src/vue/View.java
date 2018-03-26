package vue;

import com.google.gson.Gson;
import pojo.Emplacements;
import pojo.Magasins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


//import static sun.plugin2.util.PojoUtil.toJson;

public class View extends JFrame implements MouseListener {

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
        button.addMouseListener(this);
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


    public void mouseClicked(MouseEvent arg0) {
        int txt = Integer.parseInt(this.jtf.getText());
        String txt2 = this.jtf2.getText();
        int txt3 = Integer.parseInt(this.jtf3.getText());
        String txt4 = this.jtf4.getText();
        float txt5 = Float.parseFloat(this.jtf5.getText());


        Emplacements mag = new Emplacements(txt,txt2,txt3, txt4, txt5);
        Gson gson = new Gson();
        String json = gson.toJson(mag);
        System.out.print(json);

        File resultFile = new File("Emplacement.json");
        try {
            if (!resultFile.exists())
                resultFile.createNewFile();
            FileWriter writer = new FileWriter(resultFile);
            writer.write(json);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur");
        }


        try {
            Socket s = new Socket(InetAddress.getLocalHost(),5000);
            FileInputStream inf=new FileInputStream(resultFile);
            PrintStream out=new PrintStream(s.getOutputStream());
            String thisLine = null;
            
            try {
            	BufferedReader br = new BufferedReader(new FileReader("Emplacement.json"));
			       while ((thisLine = br.readLine()) != null) { // while loop begins here
			         out.println(thisLine);
			       } // end while 
			     } // end try
            	catch (IOException e) {
			       System.err.println("Error: " + e);
			     }
    	}
		catch (Exception e) {
			e.printStackTrace();    
        }
     
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
