package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
import java.awt.Color;
import java.awt.Dimension;

public class ProductDetailView extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Vue pour la vente d'un produit
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductDetailView frame = new ProductDetailView();
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
	public ProductDetailView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(12, 13, 422, 22);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Détail produit");
		lblNewLabel.setForeground(new Color(153, 0, 51));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		JLabel lblBonLivraison = new JLabel("Bon de livraison");
		lblBonLivraison.setBounds(126, 117, 47, 16);
		contentPane.add(lblBonLivraison);
		lblBonLivraison.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBonLivraison.setHorizontalAlignment(SwingConstants.LEFT);
		
		textField_1 = new JTextField();
		textField_1.setBounds(199, 114, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(197, 167, 97, 25);
		contentPane.add(btnSubmit);
		
		this.setVisible(true);
		btnSubmit.addActionListener(new BoutonLivraison());
		
	}
	
	private class BoutonLivraison implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
}
