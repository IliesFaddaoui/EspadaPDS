package analyseAnax;

import connexion.Database;
import connexion.PoolDeConnexion;
import dao.ChiffreDaffairesDAO;
import dao.ClientDAO;
import dao.MagasinsDAO;
import pojo.ChiffreDaffaires;
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
 * @version 1.0 This view allows to see the turnover of the differents stores of
 *          a category
 */
public class ChiffreDaffairesView extends JFrame {
	PoolDeConnexion connection= new PoolDeConnexion(10);
	
	private JLabel rechercheText = new JLabel("Please enter the category turnover you want to see: ");
	private JLabel espada = new JLabel("PhyGit Mall");
	private Font police = new Font("Arial", Font.BOLD, 14);
	private Font policeEspada = new Font("Arial", Font.BOLD, 28);
	private JLabel labelConnection;
	public JTextField jtfType = new JTextField("category");
	private boolean isConnected = false;
	private boolean displayConnectionScreen = true;
	private int idClientConnected = 0;
	private JButton rechercheButton = new JButton("Rechecher");
	private JPanel container = new JPanel();

	public ChiffreDaffairesView() {
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
			ChiffreDaffairesDAO cdo = new ChiffreDaffairesDAO(connection.getConnection());
			Collection<ChiffreDaffaires> cds = cdo.find(type);
			MagasinsDAO md = new MagasinsDAO(connection.getConnection());
			if (cds == null) {
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
				System.out.println("Chiffre d'affaires du mois précédent pour les magasins de la catégorie " + type);

				for (ChiffreDaffaires cd : cds) {
					Magasins m = md.find(cd.getIdMagasin());
					System.out.println(m.getMagasinName() + " | " + cd.getMontant());
				}
			}
		}
	}
}
