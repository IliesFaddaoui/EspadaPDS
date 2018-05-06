package dao;

import pojo.PurchaseHistory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Ilies
 * @version 1
 * this is the Dao class for PurchaseHistory database table. This class allows to create, delete, update or find PurchaseHistory row in the data base
 */
public class PurchaseHistoryDAO extends DAO<PurchaseHistory> {

    private Connection con;
    /**
     * this is the PurchaseHistory constructor. This use a connection in the Connection pool to have access to the database
     * @param conn
     */
    public PurchaseHistoryDAO(Connection conn){
        super(conn);
        this.con=conn;
    }
    /**
     * this method allows to create a PurchaseHistory row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean create(PurchaseHistory obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO PurchaseHistory (idPurchase,idProduct,idClient,PurchaseDate,Quantity) values ("+obj.getIdPurchase()+",\""+obj.getIdProduct()+"\","+obj.getIdClient()+",\""+obj.getPurchaseDate()+"\","+obj.getQuantity()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to delete a PurchaseHistory row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean delete(PurchaseHistory obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from PurchaseHistory WHERE idPurchase=" + obj.getIdPurchase());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to update a PurchaseHistory row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean update(PurchaseHistory obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE PurchaseHistory SET idProduct='" + obj.getIdProduct() + "', idClient=" + obj.getIdClient() + ",PurchaseDate='" + obj.getPurchaseDate() + "',Quantity=" + obj.getQuantity() + "where idPurchase=" + obj.getIdPurchase());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to find a PurchaseHistory row in the database with its id
     * @param id
     * @return PurchaseHistory
     */
    @Override
    public PurchaseHistory find(int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idPurchase,idProduct,idClient,PurchaseDate,Quantity FROM PurchaseHistory Where idPurchase="+ id);
            while(result.next()){
                PurchaseHistory pHistory = new PurchaseHistory(result.getInt("idPurchase"),result.getInt("idProduct"), result.getInt("idClient"), result.getDate("PurchaseDate"), result.getInt("Quantity"));
                return pHistory;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
