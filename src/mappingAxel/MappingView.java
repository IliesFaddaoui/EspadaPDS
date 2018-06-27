package mappingAxel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MappingView extends JFrame {
	
	  private JTextField jtf = new JTextField();
	  private JTextField jtf2 = new JTextField();
	  private JLabel label = new JLabel("");
	  private JButton b = new JButton ("OK");
	  private JPanel container = new JPanel();
	
	    public MappingView(){

	    	
	    	
	    	    this.setTitle("Phygit : Store Location");
	    	    this.setSize(600, 600);
	    	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	    this.setLocationRelativeTo(null);
	    	    container.setBackground(Color.white);
	    	    container.setLayout(new BorderLayout());
	    	    JPanel top = new JPanel();        
	    	   
	    	    jtf.setPreferredSize(new Dimension(150, 30));
	  
	    	    jtf2.setPreferredSize(new Dimension(150, 30));
	    	    jtf.setText("Magasin");
	    	   jtf2.setText("Emplacement");
	    	    top.add(label);
	    	    top.add(jtf);
	    	    top.add(jtf2);
	    	    top.add(b);
	    	    this.setContentPane(top);
	    	    this.setVisible(true);    
	    	    
	    	    jtf2.addMouseListener(new MouseListener() {
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
	    	              
	    	                jtf2.setText("");
	    	         
	    	            }
	    	});
	    	    jtf.addMouseListener(new MouseListener() {
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
	    	              
	    	                jtf.setText("");
	    	         
	    	            }
	    	});
	    	    
	    	    b.addMouseListener(new MouseListener() {
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
	    	b.             * mouseListener: when the user click on the form, the grey text disappears to let him add his login
	    	             */
	    	            public void mouseClicked(MouseEvent e) {
	    	            	GsonBuilder builder = new GsonBuilder();
	    	                Gson gson = builder.create();

	    	            	try {
	    	            	String magasin = jtf.getText();
	    	            	String emplacement = jtf2.getText();
	    	            	
	    			            Socket socket = new Socket("127.0.0.1", 5001);
	    			       
	    			            BufferedReader plec = new BufferedReader(
	    			                    new InputStreamReader(socket.getInputStream())
	    			            );

	    			            PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

	    			        	Occupation obj = new Occupation();
	    			        	String json = gson.toJson(obj);
	    			            String str = magasin;
	    			            String str2 = emplacement;
	    			         
	    			            String json1 = gson.toJson(str);
	    			            System.out.println(json);
	    			            String json2 = gson.toJson(str2);
	    			           pred.println(json);          
	    			           // envoi d'un message
	    			            json = plec.readLine(); 
	    			            // lecture de l'écho
	    			            // message de terminaison
	    			            pred.println("END") ;
	    			            plec.close();
	    			            pred.close();
	    			            socket.close();
	    			            JOptionPane jop1;
	    						jop1 = new JOptionPane();
	    						jop1.showMessageDialog(null, "Envoyé", "Information", JOptionPane.INFORMATION_MESSAGE);
	    			            }catch(Exception ex) {
	    			        	JOptionPane jop2;
	    						jop2 = new JOptionPane();
	    						jop2.showMessageDialog(null, "Impossible de se connecter au serveur", "Information", JOptionPane.INFORMATION_MESSAGE);
	    			        
	    			        }
	    	            }
	    	    });
	    }

	    class Occupation {
	    	 String magasin = jtf.getText();
	    	 String emplacement = jtf2.getText();
	   
	    	Occupation(){
	    }
	    }
	    public String getMagasin() {
	    	return jtf.getText();
	    }
	    
	    public String getEmplacement() {
	    	return jtf2.getText();
	    }
	    
	    
}
