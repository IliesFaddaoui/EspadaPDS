package dao;

import pojo.PurchaseHistory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseHistoryDAO extends DAO<PurchaseHistory> {

    private Connection con;

    public PurchaseHistoryDAO(Connection conn){
        super(conn);
        this.con=conn;
    }

    public Connection getConnection(){
        return this.con;
    }

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
