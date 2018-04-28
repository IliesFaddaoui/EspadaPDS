package dao;

import pojo.EtablishedProfile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EtablishedProfileDAO extends DAO<EtablishedProfile> {

    private Connection con;

    public EtablishedProfileDAO(Connection conn){
        super(conn);
        this.con=conn;
    }

    public Connection getConnection(){
        return this.con;
    }

    @Override
    public boolean create(EtablishedProfile obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO EtablishedProfile(idEtablishedProfile,idTypicalProfile, idClient) values ("+obj.getIdEtablishedProfile()+",\""+obj.getIdTypicalProfile()+"\","+obj.getIdClient()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(EtablishedProfile obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from EtablishedProfile WHERE idEtablishedProfile=" + obj.getIdTypicalProfile());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(EtablishedProfile obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE EtablishedProfile SET idClient='" + obj.getIdClient() + "', idTypicalProfile=" + obj.getIdTypicalProfile()+" where idEtablishedProfile=" + obj.getIdEtablishedProfile());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public EtablishedProfile find(int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idEtablishedProfile,idTypicalProfile, idClient FROM EtablishedProfile Where idEtablishedProfile="+ id);
            while(result.next()){
                EtablishedProfile etablishedProfile = new EtablishedProfile(result.getInt("idEtablishedProfile"),result.getInt("idTypicalProfile"), result.getInt("idClient"));
                return etablishedProfile;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
