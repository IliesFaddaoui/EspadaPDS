package stockAbdessamad.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import stockAbdessamad.StockModel;
import connexion.PoolDeConnexion;
import dao.StockDAO;
import pojo.Stock;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.List;
import java.awt.Color;

/**
 * 
 * @author aramil: This view displays the history of inventory
 *
 */
/*
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
/*	public InventoryListHistoryView() {
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
		StockDAO stockDAO = new StockDAO(connection.getConnection());

		return stockDAO.getAll();

	}

}*/
