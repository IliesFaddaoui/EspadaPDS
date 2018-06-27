package analyseAnax;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import analyseAnax.Magasins;
import analyseAnax.Stock;
import dao.DAO;

/**
 * @author anaximandro
 * @version 2 this is the Dao class for Magasin database table This class allows
 *          to create, delete, update or find an magasin in the data base
 */
public class MagasinsDAO extends DAO<Magasins> {

	private Connection con;

	/**
	 * this is the Magasins constructor. This use a connection in the Connection
	 * pool to have access to the database
	 * 
	 * @param conn
	 */
	public MagasinsDAO(Connection conn) {
		super(conn);
		this.con = conn;
	}

	/**
	 * this method allows to create a Magasin row in the database
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Magasins obj) {

		try {
			int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(
							"INSERT INTO Magasins(idMagasin, magasinName, magasinType, magasinSuperficie) values ("
									+ obj.getIdMagasin() + ",\"" + obj.getMagasinName() + "\"," + obj.getMagasinType()
									+ "," + obj.getMagasinSuperficie() + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * this method allows to delete a Magasin row in the database
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean delete(Magasins obj) {

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("DELETE FROM 'Magasins' WHERE idMagasins=" + obj.getIdMagasin());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * this method allows to update a Magasin row in the database
	 * 
	 * @param obj
	 * @return boolean
	 */
	public boolean update(Magasins obj) {
		return false;
	}

	/**
	 * this method allows to find a Magasin row in the database
	 * 
	 * @param idMagasins
	 * @return Magasins
	 */
	public Magasins find(int idMagasins) {
		;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT idMagasin, magasinName, magasinType, magasinSuperficie FROM Magasins Where idMagasin="
									+ idMagasins);
			while (result.next()) {
				Magasins mag = new Magasins(result.getInt("idMagasin"), result.getString("magasinName"),
						result.getString("magasinType"), result.getInt("magasinSuperficie"));
				return mag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * aramil: Find magasin by name
	 */

	public Magasins findMagasinByName(String magasinName) {

		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT idMagasin, magasinName, magasinType, magasinSuperficie FROM Magasin Where MagasinName=?";
		try {
			preparedStatement = con.prepareStatement(selectSQL);
			preparedStatement.setString(1, magasinName);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {

				Magasins mag = new Magasins(result.getInt("idMagasin"), result.getString("magasinName"),
						result.getString("magasinType"), result.getInt("magasinSuperficie"));
				return mag;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

}
