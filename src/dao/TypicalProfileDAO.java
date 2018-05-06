package dao;

import pojo.TypicalProfile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Ilies
 * @version 1
 * this is the Dao class for TypicalProfile database table. This class allows to create, delete, update or find TypicalProfile row in the data base
 */
public class TypicalProfileDAO extends DAO<TypicalProfile> {

    private Connection con;
    /**
     * this is the TypicalProfile constructor. This use a connection in the Connection pool to have access to the database
     * @param conn
     */
    public TypicalProfileDAO(Connection conn){
        super(conn);
        this.con=conn;
    }
    /**
     * this method allows to create a TypicalProfile row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean create(TypicalProfile obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO TypicalProfile (idTypicalProfile,profileName) values ("+obj.getIdTypicalProfile()+",\""+obj.getProfilName()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to delete a TypicalProfile row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean delete(TypicalProfile obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from TypicalProfile WHERE idTypicalProfile=" + obj.getIdTypicalProfile());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to update a TypicalProfile row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean update(TypicalProfile obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE TypicalProfile SET profileName='" + obj.getProfilName() + "where idTypicalProfile=" + obj.getProfilName());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to find a TypicalProfile row in the database with its id
     * @param id
     * @return TypicalProfile
     */
    @Override
    public TypicalProfile find(int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idTypicalProfile,profileName FROM TypicalProfile Where idTypicalProfile="+ id);
            while(result.next()){
                TypicalProfile typicalProfile = new TypicalProfile(result.getInt("idTypicalProfile"),result.getString("profileName"));
                return typicalProfile;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
