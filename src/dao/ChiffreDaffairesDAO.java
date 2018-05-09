package dao;

import com.sun.rowset.CachedRowSetImpl;
import pojo.ChiffreDaffaires;

/**
 * @author Anaximandro
 * @version 2
 * This is the Dao for turnover, which allows to create, delete, update or find a turnover in the data base. 
 */
import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiffreDaffairesDAO extends DAO<ChiffreDaffaires> {

    private Connection con;

    /**
     * this is the ChiffreDaffairesDAO constructor. This use a connection in the Connection pool to have access to the database
     * @param conn
     */ 
    public ChiffreDaffairesDAO(Connection conn){
        super(conn);
        this.con=conn;
    }

    public Connection getConnection(){
        return this.con;
    }

    /**
     * this method allows to create a turnover row in the database
     * @param obj
     * @return boolean
     */ 
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
    
    /**
     * this method allows to delete a turnover row in the database
     * @param obj
     * @return
     */
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

    /**
     * this method allows to update a turnover row in the database
     * @param obj
     * @return
     */
    @Override
    public boolean update(ChiffreDaffaires obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE ChiffreDaffaires SET chiffreDate='" + obj.getChiffreDate() + "',idMagasin='" + obj.getIdMagasin() +"',montant='" + obj.getMontant());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * this method allows to find a turnover row in the database with its id
     * @param id
     * @return ChiffreDaffaires
     */
	public ChiffreDaffaires find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
