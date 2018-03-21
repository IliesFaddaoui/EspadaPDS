package gui;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 
 * @author Espada
 * @version 1
 *
 */
public class Select {

	/**
	 * this constructor makes a connection with the mysql database and extract all
	 * the data from the test table, ordered by the id All the data are set into a 2
	 * columns tables, in a JFrame
	 */
	public Select() {
		Connection connection = null;
		System.out.println("Connect ...");
		try {

			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost/test";
			connection = DriverManager.getConnection(connectionUrl, "root", "root");
			String select = "SELECT * FROM TEST1 ORDER BY ID;";
			PreparedStatement ordre = connection.prepareStatement(select);

			ResultSet rs = ordre.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			Object[] column = new Object[meta.getColumnCount()];
			for (int i = 1; i <= meta.getColumnCount(); i++)
				column[i - 1] = meta.getColumnName(i);
			rs.last();
			int rowCount = rs.getRow();
			Object[][] data = new Object[rs.getRow()][meta.getColumnCount()];
			rs.beforeFirst();
			int j = 1;
			while (rs.next()) {
				for (int i = 1; i <= meta.getColumnCount(); i++)
					data[j - 1][i - 1] = rs.getObject(i);

				j++;
			}
			rs.close();

			JTable table = new JTable(data, column);
			JScrollPane scrollPane = new JScrollPane(table);
			JFrame dataWindows = new JFrame();
//			dataWindows.setDefaultCloseOperation(dataWindows.Exit_on_close);
			dataWindows.setTitle("Contenu de la table test1");
			dataWindows.add(scrollPane, BorderLayout.CENTER);
			dataWindows.setSize(500, 1000);
			dataWindows.setVisible(true);
		} catch (SQLException e2) {
			System.out.println("SQL Exception: " + e2.toString());
		} catch (ClassNotFoundException cE) {
			System.out.println("Class Not Found Exception: " + cE.toString());
		}
	}
}
