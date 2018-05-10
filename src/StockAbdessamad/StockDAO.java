package StockAbdessamad;

import com.sun.rowset.CachedRowSetImpl;

import dao.DAO;
import pojo.ChiffreDaffaires;
import pojo.Product;
import pojo.Stock;

/**
 * @author Anaximandro
 * @version 2
 * This is the Dao for turnover, which allows to create, delete, update or find a turnover in the data base. 
 */
import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockDAO extends DAO<Stock> {

	private Connection con;

	/**
	 * this is the StockDAO constructor. This use a connection in the Connection
	 * pool to have access to the database
	 * 
	 * @param conn
	 */
	public StockDAO(Connection conn) {
		super(conn);
		this.con = conn;
	}

	public Connection getConnection() {
		return this.con;
	}

	/**
	 * this method allows to create a stock row in the database
	 * 
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean create(Stock obj) {
		try {
			int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(
							"INSERT INTO Stock(idMagasin, idProduct, Quantite, dateEntree, dateSortie, motifSortie) values ("
									+ obj.getIdMagasin() + ",'" + obj.getIdProduct() + "','" + obj.getQuantite() + "','"
									+ obj.getDateEntree() + "','" + obj.getDateSortie() + "','" + obj.getMotifEntree()
									+ "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * this method allows to delete a stock row in the database
	 * 
	 * @param obj
	 * @return
	 */
	@Override
	public boolean delete(Stock obj) {
		try {
			int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE from Stock WHERE idMagasin=" + obj.getIdMagasin() + "and idProduct ="
							+ obj.getIdProduct());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * this method allows to update a stock row in the database
	 * 
	 * @param obj
	 * @return
	 */
	@Override
	public boolean update(Stock obj) {
		try {
			int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("UPDATE Stock SET Quantite= " + obj.getQuantite() + " WHERE idMagasin = "
							+ obj.getIdMagasin() + " and idProduct =" + obj.getIdProduct());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * this method allows to find a stock row in the database with its id
	 * 
	 * @param id
	 * @return Stock
	 */
	public Stock find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * this method allows to find stock's product from its id and id of magasin
	 * 
	 * @param idProduct,
	 *            idMagasin
	 * @return Product
	 */

	public Stock find(int idProduct, int idMagasin) {
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT idMagasin, idProduct, Quantite, dateEntree, dateSortie, motifEntree FROM Stock Where idProduct= ? and idMagasin= ?";
		try {
			preparedStatement = con.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idProduct);
			preparedStatement.setInt(2, idMagasin);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {

				Stock stock = new Stock(result.getInt("idMagasin"), result.getInt("idProduct"),
						result.getInt("Quantite"), result.getString("dateEntree"), result.getString("dateSortie"),
						result.getString("motifEntree"));
				return stock;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
