package analyseAnax;

import connexion.Database;
import connexion.PoolDeConnexion;
import dao.StockDAO;
import dao.MagasinsDAO;
import dao.ProductDAO;
import pojo.Stock;
import pojo.Magasins;
import pojo.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;



/**
 * @author Anaximandro
 * @version 1.0 This view allows to see the evolution of the occupation of the mall
 */
public class OccupationView extends JFrame {
	PoolDeConnexion connection= new PoolDeConnexion(10);
	
	private JLabel rechercheText = new JLabel("Please click to see the evolution of mall occupation: ");
	private JLabel espada = new JLabel("PhyGit Mall");
	private Font police = new Font("Arial", Font.BOLD, 14);
	private Font policeEspada = new Font("Arial", Font.BOLD, 28);
	private boolean displayConnectionScreen = true;
	private JButton rechercheButton = new JButton("Afficher");
	private JPanel container = new JPanel();

	public OccupationView() {
		this.setLocationRelativeTo(null);
		this.setTitle("PhyGit Mall: Mall activity indicators");
		this.setSize(600, 600);
		this.setResizable(false);

		

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
		center.add(rechercheButton);
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
	 * Intern class RechrcheButton. When the user clicks on the button the server search the historical.
	 *
	 */
	private class RechercheButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			OccupationDAO odo = new OccupationDAO(connection.getConnection());
			Collection<Integer> os = new ArrayList<Integer>();
			try {
				os = odo.findOccupation();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			EmplacementsDAO edo = new EmplacementsDAO(connection.getConnection());

				System.out.println("Evolution de l'occupation");

				for (Integer o : os) {
					int nbE = edo.nbEmplacement();
					float pourcentage = ((o*100)/nbE);
					System.out.println("Nombre d'emplacement :" + nbE + " |  Nombre d'emplacement occupés :" + o + " |  Pourcentage du centre commercial occupé :" + pourcentage);
				}
		}
	}
}
