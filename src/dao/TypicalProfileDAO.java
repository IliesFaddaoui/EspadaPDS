package dao;

import pojo.TypicalProfile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypicalProfileDAO extends DAO<TypicalProfile> {

    private Connection con;

    public TypicalProfileDAO(Connection conn){
        super(conn);
        this.con=conn;
    }

    public Connection getConnection(){
        return this.con;
    }

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
