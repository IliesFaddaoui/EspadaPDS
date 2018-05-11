package StockAbdessamad;

import pojo.PurchaseHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;

/**
 * @author Ilies
 * @version 1 this is the Dao class for PurchaseHistory database table. This
 *          class allows to create, delete, update or find PurchaseHistory row
 *          in the data base
 */
public class PurchaseHistoryDAO extends DAO<PurchaseHistory> {

	private Connection con;

	/**
	 * this is the PurchaseHistory constructor. This use a connection in the
	 * Connection pool to have access to the database
	 * 
	 * @param conn
	 */
	public PurchaseHistoryDAO(Connection conn) {
		super(conn);
		this.con = conn;
	}

	/**
	 * this method allows to create a PurchaseHistory row in the database
	 * 
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean create(PurchaseHistory obj) {
		try {
			int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(
							"INSERT INTO PurchaseHistory (idPurchaseHistory,idProduct,idClient,PurchaseDate,Quantity) values ("
									+ obj.getIdPurchase() + ",\"" + obj.getIdProduct() + "\"," + obj.getIdClient()
									+ ",\"" + obj.getPurchaseDate() + "\"," + obj.getQuantity() + ")");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * this method allows to delete a PurchaseHistory row in the database
	 * 
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean delete(PurchaseHistory obj) {
		try {
			int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE from PurchaseHistory WHERE idPurchaseHistory=" + obj.getIdPurchase());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * this method allows to update a PurchaseHistory row in the database
	 * 
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean update(PurchaseHistory obj) {
		try {
			int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("UPDATE PurchaseHistory SET idProduct='" + obj.getIdProduct() + "', idClient="
							+ obj.getIdClient() + ",PurchaseDate='" + obj.getPurchaseDate() + "',Quantity="
							+ obj.getQuantity() + "where idPurchaseHistory=" + obj.getIdPurchase());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * this method allows to find a PurchaseHistory row in the database with its id
	 * 
	 * @param id
	 * @return PurchaseHistory
	 */
	@Override
	public PurchaseHistory find(int id) {
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT idPurchaseHistory,idProduct,idClient,PurchaseDate,Quantity FROM PurchaseHistory Where idPurchaseHistory="
									+ id);
			while (result.next()) {
				PurchaseHistory pHistory = new PurchaseHistory(result.getInt("idPurchaseHistory"),
						result.getInt("idProduct"), result.getInt("idClient"), result.getString("PurchaseDate"),
						result.getInt("Quantity"));
				return pHistory;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<PurchaseHistory> findByIdProduct(int idProduct) {

		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT idPurchaseHistory,idProduct,idClient,PurchaseDate,Quantity FROM PurchaseHistory Where idProduct=?";
		List<PurchaseHistory> purchaseHistoryList = new ArrayList<>();
		try {
			preparedStatement = con.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idProduct);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {

				PurchaseHistory purchaseHistory = new PurchaseHistory(result.getInt("idPurchaseHistory"),
						result.getInt("idProduct"), result.getInt("idClient"), result.getString("purchaseDate"),
						result.getInt("quantity"));

				purchaseHistoryList.add(purchaseHistory);

			}
			return purchaseHistoryList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}
}
