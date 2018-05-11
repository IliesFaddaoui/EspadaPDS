package MappingAxel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MappingView extends JFrame {
	private JLabel connectionText = new JLabel("Please log in to see your profile: ");
    private JLabel espada = new JLabel("PhyGit Mall");
	private Font police = new Font("Arial", Font.BOLD, 14);
	private Font policeEspada = new Font("Arial", Font.BOLD, 28);
	private JLabel labelConnection;
	private boolean isConnected = false;
	private boolean displayConnectionScreen = true;
	private int idClientConnected = 0;
	
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
	    }
}