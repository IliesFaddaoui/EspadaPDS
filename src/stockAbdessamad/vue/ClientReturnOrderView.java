package stockAbdessamad.vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connexion.PoolDeConnexion;
import dao.MagasinsDAO;
import dao.PurchaseHistoryDAO;
import dao.StockDAO;
import pojo.PurchaseHistory;
import pojo.Stock;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.Color;

/**
 * 
 * @author aramil: Return's product view. The application receives the bar code of
 *         the product (the bar code correponds to the Id of product) as well as
 *         the id of the store
 *
 *
 */

public class ClientReturnOrderView extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textField_1;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientReturnOrderView frame = new ClientReturnOrderView();
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

	public ClientReturnOrderView() {

		// Container's design
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 419);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 13, 552, 29);
		contentPane.add(panel);

		// Components's design
		JLabel lblNewLabel = new JLabel("Gestion des retours clients");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		JLabel lblBonLivraison = new JLabel("Code barre du produit:");
		lblBonLivraison.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBonLivraison.setBounds(105, 163, 150, 16);
		contentPane.add(lblBonLivraison);
		lblBonLivraison.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBonLivraison.setHorizontalAlignment(SwingConstants.LEFT);

		textField_1 = new JTextField();
		textField_1.setBounds(275, 159, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.LIGHT_GRAY);
		btnSubmit.setBounds(236, 229, 97, 25);
		contentPane.add(btnSubmit);

		JLabel lblMagasin = new JLabel("Magasin:");
		lblMagasin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMagasin.setBounds(105, 108, 150, 22);
		contentPane.add(lblMagasin);

		textField = new JTextField();
		textField.setBounds(275, 108, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);

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
			MagasinsDAO magasinDAO = new MagasinsDAO(connection.getConnection());

			StockDAO stockDao = new StockDAO(connection.getConnection());
			PurchaseHistoryDAO purchaseHistoryDao = new PurchaseHistoryDAO(connection.getConnection());
			// the date of the action
			final Date date = new Date();
			String dateEntree = new SimpleDateFormat("yyyy-MM-dd").format(date);
			// Client order's return
			String motifEntree = "Retour";
			// id of the product return to the store
			int idProduct = Integer.parseInt(textField_1.getText());
			int idMagasin = Integer.parseInt(textField.getText());
			// The product must be recorded in the stock and the purchaseHistory tables
			// We search the product in the purchaseHistory table
			List<PurchaseHistory> purchaseHistory = purchaseHistoryDao.findByIdProduct(idProduct);
			// We search the product in the stock table
			Stock stock = stockDao.find(idProduct, idMagasin);
			boolean updated = false;
			if (purchaseHistory != null && stock != null) {

				for (int i = 0; i < purchaseHistory.size(); i++) {

					if ((purchaseHistory.get(i).getIdProduct() == stock.getIdProduct()
							&& purchaseHistory.get(i).getPurchaseDate().equals(stock.getDateSortie()))) {

						stock.setDateEntree(dateEntree);
						stock.setMotifEntree(motifEntree);

						stock.setQuantite(stock.getQuantite() + 1);

						updated = stockDao.update(stock);
					}

				}

			}
			if (updated == false) {

				System.out.println("Aucun produit ne correspond � votre saisie");
			}
		}

	}

}
