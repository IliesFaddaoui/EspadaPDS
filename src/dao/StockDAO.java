package dao;

import com.sun.rowset.CachedRowSetImpl;
import pojo.ChiffreDaffaires;
import pojo.Frequentation;
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
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class StockDAO extends DAO<Stock> {

	private Connection con;

	/**
	 * @author Anaximandro
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
	 * aramil: this method allows updating stock's row in the database
	 * 
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean update(Stock obj) {

		PreparedStatement preparedStatement = null;
		String updateSQL = "UPDATE Stock SET Quantite= ?, dateEntree= ?, dateSortie= ?, motifEntree= ? Where idProduct= ? and idMagasin= ?";
		try {
			preparedStatement = con.prepareStatement(updateSQL);
			preparedStatement.setInt(1, obj.getQuantite());
			preparedStatement.setString(2, obj.getDateEntree());
			preparedStatement.setString(3, obj.getDateSortie());
			preparedStatement.setString(4, obj.getMotifEntree());
			preparedStatement.setInt(5, obj.getIdProduct());
			preparedStatement.setInt(6, obj.getIdMagasin());

			preparedStatement.executeUpdate();

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
	 * aramil: this method allows to find stock's product from its id and id of
	 * magasin
	 * 
	 * @param idProduct,
	 *            idMagasin
	 * @return Stock
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

	/**
	 * aramil: Getting stock table's data
	 * 
	 * @return List<Stock>
	 */
	public List<Stock> getAll() {
		List<Stock> resultStock = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * FROM Stock";
		try {
			preparedStatement = con.prepareStatement(selectSQL);
			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Stock stock = new Stock(result.getInt("idMagasin"), result.getInt("idProduct"),
						result.getInt("Quantite"), result.getString("dateEntree"), result.getString("dateSortie"),
						result.getString("motifEntree"));
				resultStock.add(stock);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultStock;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public Collection<Stock> find(String type) {
		Collection <Stock> Stocks = new ArrayList<Stock>();
		try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT S.idMagasin S.idProduct, S.Quantite, S.dateEntree, S.dateSortie, S.motifEntree FROM Stock as C, Magasin as M Where M.magasinType="+ type +"and M.idMagasin = S.idMagasin and motifEntree = 'retourclient' and DATEDIFF(month, GETDATE(), S.dateEntree) = 1 ");
            while(result.next()){
                Stock stock = new Stock(result.getInt("idMagasin"),result.getInt("idProduct"), result.getInt("Quantite"), result.getString("dateEntree"), result.getString("dateSortie"), result.getString("motifEntree"));
                Stocks.add(stock);        
            }
            return Stocks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

}
