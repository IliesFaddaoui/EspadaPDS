package dao;

import com.sun.rowset.CachedRowSetImpl;
import pojo.Frequentation;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FrequentationDAO extends DAO<Frequentation> {

    private Connection con;

    public FrequentationDAO(Connection conn){
        super(conn);
        this.con=conn;
    }

    public Connection getConnection(){
        return this.con;
    }

    @Override
    public boolean create(Frequentation obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Frequentation(frequentationDate, idMagasin, niveauFrequentation) values ("+obj.getFrequentationDate()+",'"+obj.getIdMagasin()+"','"+obj.getNiveauFrequentation()+"')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Frequentation obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from Frequentation WHERE frequentationDate=" + obj.getFrequentationDate());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Frequentation obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Client SET frequentationDate='" + obj.getFrequentationDate() + "',idMagasin='" + obj.getIdMagasin() +"',niveauFrequentation='" + obj.getNiveauFrequentation());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /*public Frequentation find(String type, int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT frequentationDate, idMagasin, niveauFrequentation FROM Frequentation, Magasin Where Magasin.type="+ type);
            while(result.next()){
                Frequentation freq = new Frequentation (result.getDate("frequentationDate"),result.getInt("idMagasin"), result.getInt("niveauFrequentation"));
                return freq;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

	public Frequentation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}