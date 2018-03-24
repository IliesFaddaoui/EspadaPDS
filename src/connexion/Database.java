package connexion;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * @author ilies
 * @version 1.2
 * Database connection class. Used by the connection pool
 */
public class Database {
	private static final String DRIVER_NAME ="com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/PDS";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	/**
	 * static methods with create an instance of the jdbc driver.
	 * In case of failure, an exception is rised
	 */
	static {
		try {
			Class.forName(DRIVER_NAME).newInstance();
			System.out.println("*** Driver loaded.");
		}
		catch (ClassNotFoundException e) {
			System.err.println("*** ERROR: Driver " + DRIVER_NAME + "not found");
		}
		catch (InstantiationException e) {
			System.err.println("*** ERROR: Impossible to create an instance of " + DRIVER_NAME);
			System.err.println(e.getMessage());
		}
		catch (IllegalAccessException e) {
			System.err.println("*** ERROR: Impossible to create an instance of " + DRIVER_NAME);
			System.err.println(e.getMessage());
		}
	}

	/**
	 * this method create a connection with the setting on Database's class
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
		