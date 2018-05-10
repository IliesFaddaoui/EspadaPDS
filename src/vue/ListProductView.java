/**package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import connexion.PoolDeConnexion;
import dao.BonDeLivraisonDAO;
import dao.ProductDAO;
import model.ProductModel;
import pojo.BonDeLivraison;
import pojo.Product;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;

public class ListProductView extends JFrame {

	private JPanel contentPane =  new JPanel();;
	private final JPanel panel = new JPanel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListProductView frame = new ListProductView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 
	public ListProductView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(12, 13, 422, 22);
		contentPane.add(panel);
		
		panel.setSize(450, 300);
		
		JLabel lblNewLabel = new JLabel("List produits");
		lblNewLabel.setForeground(new Color(153, 0, 51));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		
		List<Product> dataToDisplay = initData();
		
		
		ProductModel model = new ProductModel(dataToDisplay);
		JTable table = new JTable(model);
		table.setSize(400, 300);

		panel.add(new JScrollPane(table));
		
		this.setVisible(true);
		
	}
	
	private List<Product> initData() {
		PoolDeConnexion connection= new PoolDeConnexion(5);
		ProductDAO productDAO = new ProductDAO(connection.getConnection());
		
		return productDAO.getAll();
		
	}

}
*/