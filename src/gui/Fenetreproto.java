package gui;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

/**
 * 
 * @author Espada
 * @version 1
 */
public class Fenetreproto extends JFrame {

	private JFormattedTextField jtf = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JTextField jtf2 = new JTextField();
	private JLabel label = new JLabel("Insérer des données dans la table test1:");
	private JLabel labelInst1 = new JLabel("Id de l'individu");
	private JLabel labelInst2 = new JLabel("nom de l'individu");
	private JButton bInsert = new JButton("OK");
	private JButton bSelect = new JButton("Affiche les données de la bd");
	private JPanel labelSelect = new JPanel();

	/**
	 * Here is the main gui windows constructor.
	 * 
	 */
	public Fenetreproto() {

		this.setTitle("Espada 1.0");
		this.setSize(900, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// Insert
		JPanel insert = new JPanel();
		Font police = new Font("Arial", Font.BOLD, 14);
		jtf.setFont(police);
		jtf.setPreferredSize(new Dimension(150, 30));
		jtf.setForeground(Color.BLUE);
		jtf2.setPreferredSize(new Dimension(150, 30));
		bInsert.addActionListener(new BoutonListenerInsert());
		insert.add(labelInst1);
		insert.add(jtf);
		insert.add(labelInst2);
		insert.add(jtf2);
		insert.add(bInsert);

		// Select
		JPanel select = new JPanel();
		bSelect.addActionListener(new BoutonListenerSelect());
		labelSelect.add(bSelect);
		select.add(label);

		// Window
		this.getContentPane().add(select, BorderLayout.NORTH);
		this.getContentPane().add(insert, BorderLayout.CENTER);
		this.getContentPane().add(labelSelect, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	/**
	 * 
	 * The two button listener. The first allows to create a new line on the "test1"
	 * DB table The second allows to open a window with all the data from the test1
	 * DB table on a 2 column array. Each of them call constructors to make the link
	 * with the database and the operation
	 *
	 */
	// Insert Button Listener
	class BoutonListenerInsert implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("TEXT : jtf " + jtf.getText());
			System.out.println("TEXT : jtf2 " + jtf2.getText());
			String nom = jtf2.getText();
			String id = jtf.getText();
			Insert insert = new Insert(id, nom);
		}
	}

	// Select Button Listener
	class BoutonListenerSelect implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Select sel = new Select();
		}
	}
}
