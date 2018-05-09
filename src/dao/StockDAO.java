package dao;

import com.sun.rowset.CachedRowSetImpl;
import pojo.ChiffreDaffaires;
import pojo.Stock;

/**
 * @author Anaximandro
 * @version 2
 * This is the Dao for turnover, which allows to create, delete, update or find a turnover in the data base. 
 */
import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockDAO extends DAO<Stock> {

    private Connection con;

    /**
     * this is the StockDAO constructor. This use a connection in the Connection pool to have access to the database
     * @param conn
     */ 
    public StockDAO(Connection conn){
        super(conn);
        this.con=conn;
    }

    public Connection getConnection(){
        return this.con;
    }

    /**
     * this method allows to create a stock row in the database
     * @param obj
     * @return boolean
     */ 
    @Override
    public boolean create(Stock obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Stock(idMagasin, idProduct, Quantite, dateEntree, dateSortie, motifSortie) values ("+obj.getIdMagasin()+",'"+obj.getIdProduct()+"','"+obj.getQuantite()+"','"+obj.getDateEntree()+"','"+obj.getDateSortie()+"','"+obj.getMotifSortie()+"')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * this method allows to delete a stock row in the database
     * @param obj
     * @return
     */
    @Override
    public boolean delete(Stock obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from Stock WHERE idMagasin=" + obj.getIdMagasin()+"and idProduct =" + obj.getIdProduct());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * this method allows to update a stock row in the database
     * @param obj
     * @return
     */
    @Override
    public boolean update(Stock obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Stock SET Quantite='" + obj.getQuantite() + "'WHERE idMagasin ='" + obj.getIdMagasin() +"' and idProduct ='" + obj.getIdProduct());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * this method allows to find a stock row in the database with its id
     * @param id
     * @return Stock
     */
	public Stock find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
