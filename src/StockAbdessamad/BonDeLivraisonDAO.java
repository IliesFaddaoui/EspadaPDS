package dao;
/**
 * 
 * @author aramil
 *
 */

import pojo.BonDeLivraison;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1
 * this is the Dao class for BondeLivraison database table. This class allows to create, delete, update or find a BonDeLivraison in the data base
 */
public class BonDeLivraisonDAO extends DAO<BonDeLivraison> {

    private Connection con;
    /**
     * this is the BonDeLivraison constructor. This use a connection in the Connection pool to have access to the database
     * @param conn
     */
    public BonDeLivraisonDAO(Connection conn){
        super(conn);
        this.con=conn;
    }
    /**
     * this method allows to create a BonDeLivraison row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean create(BonDeLivraison obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO BonDeLivraison(numeroBon ,listProduits) values ("+obj.getNumeroBon()+",'"+obj.getListProduits()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to delete a BonDeLivraison row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean delete(BonDeLivraison obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from BonDeLivraison WHERE numeroBon=" + obj.getNumeroBon());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to update a BonDeLivraison row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean update(BonDeLivraison obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE BonDeLivraison SET listProduits='" + obj.getListProduits());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to find a BonDeLivraison row in the database with its id
     * @param id
     * @return BonDeLivraison
     */
    @Override
    public BonDeLivraison find(int numeroBon) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT numeroBon, listProduits, idMagasin FROM BonDeLivraison Where numeroBon="+ numeroBon);
            while(result.next()){
                BonDeLivraison bonDeLivraison = new BonDeLivraison(result.getInt("numeroBon"),result.getString("listProduits"), result.getInt("idMagasin"));
                return bonDeLivraison;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
