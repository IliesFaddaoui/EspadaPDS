import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
// Création d'une IHM test ,  à supprimer
public class Fenetre extends JFrame implements MouseListener {
			  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			private JPanel container = new JPanel();
			  public JTextField jtf = new JTextField();
			  public JTextField jtf2 = new JTextField();
			  private JLabel label = new JLabel("Nom :");
			  private JLabel label2 = new JLabel("Prénom :");
				GsonBuilder builder = new GsonBuilder();
			  Gson gson = builder.create();
			    
			  public Fenetre(){
			    this.setTitle("Nouveau client");
			    this.setSize(800, 800);
			    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    this.setLocationRelativeTo(null);
			    container.setBackground(Color.white);
			    container.setLayout(new BorderLayout());
			    JPanel top = new JPanel();
			    JPanel bot = new JPanel();
			    Font police = new Font("Arial", Font.BOLD, 14);
			    jtf.setFont(police);			    
			    jtf.setPreferredSize(new Dimension(150, 30));
			    jtf.setForeground(Color.BLUE);
			    jtf2.setFont(police);
			    jtf2.setPreferredSize(new Dimension(150, 30));
			    jtf2.setForeground(Color.BLUE);
			    JButton button = new JButton("Valider");
			    button.addMouseListener(this);
			    top.add(label);
			    top.add(jtf);
			    top.add(label2);
			    top.add(jtf2);
			    top.add(button);
			    container.add(top, BorderLayout.NORTH);
			    container.add(bot, BorderLayout.EAST);
			    
			    
			    			    	    
				    this.setContentPane(container);
			    //this.setVisible(true);            
			  }

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub				
				String txt = this.jtf.getText();
				String txt2 = this.jtf2.getText();
				Client p = new Client(txt, txt2);
				
				//Récupération des champs textes de l'IHM. 
				//A modifier selon TextFiled de notre IHM
				// Puis conversion sous le format JSON
				String json = gson.toJson(p);
				System.out.print(json);
				
				// Création du fichier 
				// avec le texte en format JSON
				File resultFile = new File("Client.json");
			
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
				
				// Envoi du fichier généré par l'IHM vers le serveur
				// Ici 127.0.0.1 correspond à l'adresse du serveur a modifier avec adresse VM
				// 5000 correspond au numéro de port utilisé par le serveur
				Socket s = new Socket("127.0.0.1",5000);
				FileInputStream inf=new FileInputStream(resultFile);
				ObjectOutputStream out=new ObjectOutputStream(s.getOutputStream());               
				byte buf[] = new byte[1024];
				int n;                   
				while((n=inf.read(buf))!=-1){
					out.write(buf,0,n);                   
				}           
				inf.close();
				out.close();   
				s.close();
				}
				catch (Exception e) {
					e.printStackTrace();
					return;
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			}
