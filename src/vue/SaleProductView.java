package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import connexion.PoolDeConnexion;
import dao.BonDeLivraisonDAO;
import dao.MagasinsDAO;
import dao.ProductDAO;
import dao.StockDAO;
import pojo.BonDeLivraison;
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
import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.Color;
import java.awt.Dimension;

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
		setBounds(100, 100, 594, 394);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 13, 538, 22);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Vente de produits");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		// La quanti
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantity.setBounds(156, 172, 71, 16);
		contentPane.add(lblQuantity);
		lblQuantity.setVerticalAlignment(SwingConstants.BOTTOM);
		lblQuantity.setHorizontalAlignment(SwingConstants.LEFT);

		textField_1 = new JTextField();
		textField_1.setBounds(250, 169, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnSubmit = new JButton("Submit:");
		btnSubmit.setBounds(256, 257, 97, 25);
		contentPane.add(btnSubmit);
		// Le code barre du produit
		JLabel lblBarCode = new JLabel("Bar Code:");
		lblBarCode.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBarCode.setBounds(156, 119, 82, 16);
		contentPane.add(lblBarCode);
		lblBarCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblBarCode.setVerticalAlignment(SwingConstants.TOP);

		textField = new JTextField();
		textField.setBounds(250, 116, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(250, 63, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblMagasin = new JLabel("Magasin:");
		lblMagasin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMagasin.setBounds(156, 66, 82, 16);
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

			int idProduct = Integer.parseInt(textField.getText());
			Product product = productDAO.find(idProduct);

			String magasinName = textField_2.getText();
			System.out.println("magasinName"+ magasinName);
			Magasins magasin = magasinDAO.findMagasinByName(magasinName);
			int idMagasin = magasin.getIdMagasin();

			if (magasin != null && product != null) {
				System.out.println("Recherche du produit et du magasin associé");

				StockDAO stockDAO = new StockDAO(connection.getConnection());
				// Updating Stock table with the new delivery data
				Stock stockToUpdate = stockDAO.find(idProduct, idMagasin);
				stockToUpdate.setQuantite(stockToUpdate.getQuantite() - quantity);
				
				final Date date = new Date();
				System.out.println("date"+ date);
			    String dateSortie = new SimpleDateFormat("yyyy-MM-dd").format(date);
				   
				
				System.out.println(dateSortie);
				stockToUpdate.setDateSortie(dateSortie);

				
				stockDAO.update(stockToUpdate);

			}

		}

	}

}
