package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Espada
 * @version 1
 *
 */
public class Insert {
	private String id;
	private String nom;

	/**
	 * This constructor creates a connection with the mysql database and insert into
	 * test table a name and an id, which are on the constructor parameters.
	 * 
	 * @param id2
	 * @param nom
	 */
	public Insert(String id2, String nom) {
		this.id = id2;
		this.nom = nom;
		Connection connection = null;
		Statement statement = null;
		System.out.println("Connect ...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost/test";
			connection = DriverManager.getConnection(connectionUrl, "root", "root");
			statement = connection.createStatement();
			String requete = "INSERT INTO test1(id,nom) VALUES (" + this.id + ",'" + this.nom + "');";
			statement.executeUpdate(requete);

		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.toString());
		} catch (ClassNotFoundException cE) {
			System.out.println("Class Not Found Exception: " + cE.toString());
		}
	}
}