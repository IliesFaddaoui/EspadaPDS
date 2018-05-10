package dao;

import com.sun.rowset.CachedRowSetImpl;
import pojo.KeyWord;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ilies
 * @version 1
 * this is the Dao class for KeyWord database table. This class allows to create, delete, update or find a KeyWord in the data base
 */
public class KeyWordDAO extends DAO<KeyWord> {
    private Connection conn;
    /**
     * this is the KeyWord constructor. This use a connection in the Connection pool to have access to the database
     * @param conn
     */
    public KeyWordDAO(Connection conn){
        super(conn);
        this.conn=conn;
    }
    /**
     * this method allows to create a KeyWord row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean create(KeyWord obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO KeyWord(idKeyWord ,nameKeyWord) values ("+obj.getIdKeyword()+",'"+obj.getNameKeyWord()+"')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to delete a KeyWord row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean delete(KeyWord obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from KeyWord WHERE idKeyWord=" + obj.getIdKeyword());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to update a KeyWord row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean update(KeyWord obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE KeyWord SET nameKeyWord='" + obj.getNameKeyWord() + "'" + " where idKeyWord=" + obj.getIdKeyword());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to find a KeyWord row in the database with its id
     * @param id
     * @return KeyWord
     */
    @Override
    public KeyWord find(int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idKeyWord, nameKeyWord FROM KeyWord Where idKeyWord="+ id);
            while(result.next()){
                KeyWord keyWord = new KeyWord(result.getInt("idKeyWord"),result.getString("nameKeyWord"));
                return keyWord;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<String> listClientKeyword(int id){
        try{
            List<String> clientsList = new ArrayList<String>();
            String sql = "SELECT k.nameKeyWord FROM client c, purchaseHistory ph, KeyWord k";
            CachedRowSet rs = new CachedRowSetImpl();
            rs.setCommand(sql);
            rs.execute(this.connect);
            this.connect.close();
            while (rs.next()) {
                clientsList.add(rs.getString("idClient"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
