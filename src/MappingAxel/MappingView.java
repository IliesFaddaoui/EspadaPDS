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
	
	  private JTextField jtf = new JTextField();
	private JTextField jtf2 = new JTextField();
	  private JLabel label = new JLabel("");
	  private JButton b = new JButton ("OK");
	  
	  private connecterDB conDB;
	
	private JPanel container = new JPanel();
	
	    public MappingView(connecterDB con){
	    	this.conDB = con;
	    	
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
	    	            	String magasin = jtf.getText();
	    	            	String emplacement = jtf2.getText();
	    	            	conDB.newStore(magasin, emplacement);
	    	            }
	    	    });
	    }

	    public String getMagasin() {
	    	return jtf.getText();
	    }
	    
	    public String getEmplacement() {
	    	return jtf2.getText();
	    }
}