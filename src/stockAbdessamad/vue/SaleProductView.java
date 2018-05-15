package stockAbdessamad.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connexion.PoolDeConnexion;
import dao.MagasinsDAO;
import dao.ProductDAO;
import dao.StockDAO;
import pojo.Magasins;
import pojo.Product;
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
import java.awt.Color;

/**
 * 
 * @author aramil: Sale product view. The application receives the bar code of
 *         the product (the bar code correponds to the Id of product) as well as
 *         the quantity of products sold
 *
 */
public class SaleProductView extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleProductView frame = new SaleProductView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SaleProductView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 478);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 13, 741, 37);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Vente de produits");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		// La quanti
		JLabel lblQuantity = new JLabel("Quantit�:");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantity.setBounds(234, 202, 87, 16);
		contentPane.add(lblQuantity);
		lblQuantity.setVerticalAlignment(SwingConstants.BOTTOM);
		lblQuantity.setHorizontalAlignment(SwingConstants.LEFT);

		textField_1 = new JTextField();
		textField_1.setBounds(377, 199, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(370, 287, 97, 25);
		contentPane.add(btnSubmit);
		// Le code barre du produit
		JLabel lblBarCode = new JLabel("Code barre:");
		lblBarCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBarCode.setBounds(234, 136, 98, 19);
		contentPane.add(lblBarCode);
		lblBarCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblBarCode.setVerticalAlignment(SwingConstants.TOP);

		textField = new JTextField();
		textField.setBounds(377, 133, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(377, 83, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblMagasin = new JLabel("Magasin:");
		lblMagasin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMagasin.setBounds(234, 86, 97, 19);
		contentPane.add(lblMagasin);

		this.setVisible(true);
		btnSubmit.addActionListener(new BoutonVente());

	}

	private class BoutonVente implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			PoolDeConnexion connection = new PoolDeConnexion(5);
			MagasinsDAO magasinDAO = new MagasinsDAO(connection.getConnection());
			ProductDAO productDAO = new ProductDAO(connection.getConnection());

			int quantity = Integer.parseInt(textField_1.getText());

			final Date date = new Date();

			int idProduct = Integer.parseInt(textField.getText());
			Product product = productDAO.find(idProduct);

			String magasinName = textField_2.getText();
			System.out.println("magasinName" + magasinName);
			Magasins magasin = magasinDAO.findMagasinByName(magasinName);
			int idMagasin = magasin.getIdMagasin();

			if (magasin != null && product != null) {
				System.out.println("Recherche du produit et du magasin associ�");

				StockDAO stockDAO = new StockDAO(connection.getConnection());
				// Updating Stock table
				Stock stockToUpdate = stockDAO.find(idProduct, idMagasin);
				stockToUpdate.setQuantite(stockToUpdate.getQuantite() - quantity);

				String dateSortie = new SimpleDateFormat("yyyy-MM-dd").format(date);
				stockToUpdate.setDateSortie(dateSortie);
				stockDAO.update(stockToUpdate);

			}

		}

	}

}
