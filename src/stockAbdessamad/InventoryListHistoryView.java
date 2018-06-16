package StockAbdessamad.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;

import StockAbdessamad.StockModel;
import connexion.PoolDeConnexion;
import dao.BonDeLivraisonDAO;
import dao.ProductDAO;
import dao.StockDAO;
import pojo.BonDeLivraison;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;

/**
 * 
 * @author aramil: This view displays the history of inventory
 *
 */

public class InventoryListHistoryView extends JFrame {

	private JPanel contentPane = new JPanel();;
	private final JPanel panel = new JPanel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryListHistoryView frame = new InventoryListHistoryView();
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
	public InventoryListHistoryView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 498);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(12, 13, 777, 414);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Historique des mouvements du stock");
		lblNewLabel.setBounds(214, 13, 325, 20);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
        // We initialize data
		List<Stock> dataToDisplay = initData();

		StockModel model = new StockModel(dataToDisplay);
		JTable table = new JTable(model);
		table.setSize(400, 300);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 67, 753, 303);
		panel.add(scrollPane);

		this.setVisible(true);

	}
    
	//Getting data from Stock's table
	private List<Stock> initData() {
		PoolDeConnexion connection = new PoolDeConnexion(5);
		Connection con = connection.getConnection();
		StockDAO stockDAO = new StockDAO(con);

		try {
			return stockDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}finally{
		  
		 if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return null;

	}

}
