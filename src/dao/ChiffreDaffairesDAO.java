package dao;

import com.sun.rowset.CachedRowSetImpl;
import pojo.ChiffreDaffaires;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiffreDaffairesDAO extends DAO<ChiffreDaffaires> {

    private Connection con;

    public ChiffreDaffairesDAO(Connection conn){
        super(conn);
        this.con=conn;
    }

    public Connection getConnection(){
        return this.con;
    }

    @Override
    public boolean create(ChiffreDaffaires obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO ChiffreDaffaires(chiffreDate, idMagasin, montant) values ("+obj.getChiffreDate()+",'"+obj.getIdMagasin()+"','"+obj.getMontant()+"')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(ChiffreDaffaires obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from ChiffreDaffaires WHERE chiffreDate=" + obj.getChiffreDate());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ChiffreDaffaires obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Client SET chiffreDate='" + obj.getChiffreDate() + "',idMagasin='" + obj.getIdMagasin() +"',montant='" + obj.getMontant());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /*public ChiffreDaffaires find(String type, int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT chiffreDate, idMagasin, montant FROM ChiffreDaffaires, Magasin Where Magasin.type="+ type);
            while(result.next()){
                ChiffreDaffaires chiffre = new ChiffreDaffaires (result.getDate("chiffreDate"),result.getInt("idMagasin"), result.getInt("montant"));
                return chiffre;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

	public ChiffreDaffaires find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
