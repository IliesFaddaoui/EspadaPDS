package analyseAnaxVue;

import connexion.Database;
import connexion.PoolDeConnexion;
import dao.FrequentationDAO;
import dao.MagasinsDAO;
import pojo.Frequentation;
import pojo.Magasins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;



/**
 * @author Anaximandro
 * @version 1.0 This view allows to see the attendance of the differents stores of
 *          a category
 */
public class FrequentationView extends JFrame {
	PoolDeConnexion connection= new PoolDeConnexion(10);
	
	private JLabel rechercheText = new JLabel("Please enter the category attendance you want to see: ");
	private JLabel espada = new JLabel("PhyGit Mall");
	private Font police = new Font("Arial", Font.BOLD, 14);
	private Font policeEspada = new Font("Arial", Font.BOLD, 28);
	public JTextField jtfType = new JTextField("category");
	private boolean displayConnectionScreen = true;
	private JButton rechercheButton = new JButton("Rechecher");
	private JPanel container = new JPanel();

	public FrequentationView() {
		this.setLocationRelativeTo(null);
		this.setTitle("PhyGit Mall: Mall activity indicators");
		this.setSize(600, 600);
		this.setResizable(false);

		jtfType.getFont().deriveFont(Font.ITALIC);
		jtfType.setForeground(Color.gray);
		jtfType.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			/**
			 * mouseListener: when the user click on the form, the grey text disappears to
			 * let him write the category
			 */
			public void mouseClicked(MouseEvent e) {
				JTextField t1 = ((JTextField) e.getSource());
				t1.setText("");
				t1.getFont().deriveFont(Font.PLAIN);
				t1.setForeground(Color.black);
				t1.removeMouseListener(this);
			}
		});

		espada.setFont(policeEspada);
		rechercheButton.addActionListener(new RechercheButton());
		JPanel top = new JPanel();
		JPanel west = new JPanel();
		JPanel east = new JPanel();
		JPanel center = new JPanel();
		JPanel bot = new JPanel();
		top.setPreferredSize(new Dimension(100, 250));
		center.setPreferredSize(new Dimension(100, 60));
		west.setPreferredSize(new Dimension(100, 600));
		east.setPreferredSize(new Dimension(100, 600));
		bot.setPreferredSize(new Dimension(100, 250));
		GridLayout layoutCenter = new GridLayout(2, 1);
		GridLayout layoutTop = new GridLayout(1, 2);
		top.setLayout(layoutTop);
		center.setLayout(layoutCenter);
		top.add(espada);
		top.add(rechercheText);
		container.setLayout(new BorderLayout());
		center.add(jtfType);
		bot.add(rechercheButton);
		container.add(top, BorderLayout.NORTH);
		container.add(center, BorderLayout.CENTER);
		container.add(bot, BorderLayout.SOUTH);
		container.add(east, BorderLayout.EAST);
		container.add(west, BorderLayout.WEST);

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setContentPane(container);
		this.setVisible(displayConnectionScreen);
	}

	/**
	 * Intern class RechrcheButton. When the user clicks on the button the category is sent to server.
	 *
	 */
	private class RechercheButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String type = jtfType.getText();
			FrequentationDAO fdo = new FrequentationDAO(BDD());
			Collection<Frequentation> fs = fdo.find(type);
			MagasinsDAO md = new MagasinsDAO(BDD());
			if (fs == null) {
				JFrame fenResp = new JFrame();
				JPanel containerResp = new JPanel();
				fenResp.setSize(150, 150);
				fenResp.setLocationRelativeTo(null);
				JLabel jlabResp = new JLabel("Wrong category");
				containerResp.add(jlabResp, BorderLayout.CENTER);
				fenResp.setContentPane(containerResp);
				fenResp.setVisible(true);
				jtfType.setText("category");
			} else {
				System.out.println("Niveau de fréquentation du mois précédent pour les magasins de la catégorie " + type);

				for (Frequentation freq : fs) {
					Magasins m = md.find(freq.getIdMagasin());
					System.out.println("Magasin :" + m.getMagasinName() + " | Niveau de frequentation :" + freq.getNiveauFrequentation());
				}
			}
		}
	}
	public static Connection BDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK");
			String url="jdbc:mysql://localhost/pds";
			String user="root";
			String password="";
			Connection con=DriverManager.getConnection(url, user, password);
			System.out.println("Connexion Ã©tablie");
			return con;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
