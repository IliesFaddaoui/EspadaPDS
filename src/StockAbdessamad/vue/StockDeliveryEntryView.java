package StockAbdessamad.vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connexion.PoolDeConnexion;
import dao.BonDeLivraisonDAO;

import dao.StockDAO;
import pojo.BonDeLivraison;
import pojo.Stock;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Dimension;

/**
 * 
 * @author aramil: View for delivery notes management. The application receives
 *         the number of the delivery note and updates the inventory
 *
 */

public class StockDeliveryEntryView extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockDeliveryEntryView frame = new StockDeliveryEntryView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creating the frame.
	 */

	public StockDeliveryEntryView() {

		// Container's design
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 13, 434, 22);
		contentPane.add(panel);

		// Components's design
		JLabel lblNewLabel = new JLabel("Gestion des bons de livraison");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		JLabel lblBonLivraison = new JLabel("Numero du bon de livraison");
		lblBonLivraison.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBonLivraison.setBounds(100, 117, 150, 16);
		contentPane.add(lblBonLivraison);
		lblBonLivraison.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBonLivraison.setHorizontalAlignment(SwingConstants.LEFT);

		textField_1 = new JTextField();
		textField_1.setBounds(214, 113, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.LIGHT_GRAY);
		btnSubmit.setBounds(203, 170, 97, 25);
		contentPane.add(btnSubmit);

		this.setVisible(true);
		btnSubmit.addActionListener(new BoutonLivraison());

	}

	/**
	 * 
	 * @author aramil Class for data Processing
	 *
	 */
	private class BoutonLivraison implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			PoolDeConnexion connection = new PoolDeConnexion(5);
			BonDeLivraisonDAO bonDeLivraisonDAO = new BonDeLivraisonDAO(connection.getConnection());

			final Date date = new Date();
			System.out.println("date" + date);
			String dateEntree = new SimpleDateFormat("yyyy-MM-dd").format(date);

			String motifEntree = "Livraison";

			int numeroBonToSearch = Integer.parseInt(textField_1.getText());
			BonDeLivraison bonLivraison = bonDeLivraisonDAO.find(numeroBonToSearch);
			//
			if (bonLivraison != null) {
				System.out.println("Bon de livraison trouve... Recherche des produits associés");
				String[] listProduits = bonLivraison.getListProduits().split(",");
				int idMagasin = bonLivraison.getIdMagasin();

				StockDAO stockDAO = new StockDAO(connection.getConnection());
				// Updating Stock table with the new delivery data
				for (int i = 0; i < listProduits.length; ++i) {
					Stock stockToUpdate = stockDAO.find(Integer.parseInt(listProduits[i]), idMagasin);
					stockToUpdate.setDateEntree(dateEntree);
					stockToUpdate.setMotifEntree(motifEntree);

					stockToUpdate.setQuantite(stockToUpdate.getQuantite() + 1);

					stockDAO.update(stockToUpdate);
					System.out.println("date" + stockToUpdate.getDateEntree());
					System.out.println("motif" + stockToUpdate.getMotifEntree());

				}

			}

		}

	}

}
