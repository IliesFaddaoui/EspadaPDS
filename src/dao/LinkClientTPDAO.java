package dao;

import pojo.LinkClientTP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LinkClientTPDAO extends DAO<LinkClientTP> {

    private Connection con;

    public LinkClientTPDAO(Connection conn){
        super(conn);
        this.con=conn;
    }

    public Connection getConnection(){
        return this.con;
    }

    @Override
    public boolean create(LinkClientTP obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO LinkClientTP(idLinkClientTP,idTypicalProfile, idClient) values ("+obj.getIdLinkClientTP()+",\""+obj.getIdTypicalProfile()+"\","+obj.getIdClient()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(LinkClientTP obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from LinkClientTP WHERE idLinkClientTP=" + obj.getIdLinkClientTP());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(LinkClientTP obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE LinkClientTP SET idClient='" + obj.getIdClient() + "', idTypicalProfile=" + obj.getIdTypicalProfile()+" where idLinkClientTP=" + obj.getIdLinkClientTP());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public LinkClientTP find(int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idLinkClientTP,idTypicalProfile, idClient FROM LinkClientTP Where idEtablishedProfile="+ id);
            while(result.next()){
                LinkClientTP linkClientTP = new LinkClientTP(result.getInt("idLinkClientTP"),result.getInt("idTypicalProfile"), result.getInt("idClient"));
                return linkClientTP;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
