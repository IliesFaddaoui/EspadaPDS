package dao;

import pojo.TypeProfile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Ilies
 * @version 1
 * this is the Dao class for TypeProfile database table. This class allows to create, delete, update or find TypeProfile row in the data base
 */
public class TypeProfileDAO extends DAO<TypeProfile> {

    private Connection con;
    /**
     * this is the TypeProfile constructor. This use a connection in the Connection pool to have access to the database
     * @param conn
     */
    public TypeProfileDAO(Connection conn){
        super(conn);
        this.con=conn;
    }
    /**
     * this method allows to create a TypeProfile row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean create(TypeProfile obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO TypeProfile (idTypeProfile,profileName) values ("+obj.getIdTypeProfile()+",\""+obj.getProfilName()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to delete a TypeProfile row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean delete(TypeProfile obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from TypeProfile WHERE idTypeProfile=" + obj.getIdTypeProfile());
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
    public boolean update(TypeProfile obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE TypeProfile SET profileName='" + obj.getProfilName() + "where idTypeProfile=" + obj.getProfilName());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to find a TypeProfile row in the database with its id
     * @param id
     * @return TypicalProfile
     */
    @Override
    public TypeProfile find(int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idTypeProfile,profileName FROM TypeProfile Where idTypeProfile="+ id);
            while(result.next()){
                TypeProfile typeProfile = new TypeProfile(result.getInt("idTypeProfile"),result.getString("profileName"));
                return typeProfile;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
