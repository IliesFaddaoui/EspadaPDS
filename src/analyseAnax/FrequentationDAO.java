package analyseAnax;

import com.sun.rowset.CachedRowSetImpl;

import pojo.Frequentation;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Anaximandro
 * @version 2
 * This is the Dao for attendance, which allows to create, delete, update or find a attendance in the data base. 
 */

public class FrequentationDAO extends DAO<Frequentation> {

    private Connection con;

    /**
     * this is the FrequentationDAO constructor. This use a connection in the Connection pool to have access to the database
     * @param conn
     */ 
    public FrequentationDAO(Connection conn){
        super(conn);
        this.con=conn;
    }
    
    public Connection getConnection(){
        return this.con;
    }

    /**
     * this method allows to create an attendance row in the database
     * @param obj
     * @return boolean
     */ 
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
    
    /**
     * this method allows to delete an attendance row in the database
     * @param obj
     * @return
     */
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

    /**
     * this method allows to update an attendance row in the database
     * @param obj
     * @return
     */
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

 
    /**
     * this method allows to find an attendance row in the database with its id
     * @param id
     * @return Frequentation
     */
	public Frequentation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Collection<Frequentation> find(String type) {
		Collection <Frequentation> Frequentations = new ArrayList<Frequentation>();
		try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT F.frequentationDate F.idMagasin, F.niveauFrequentation FROM Frequentation as F, Magasin as M Where M.magasinType="+ type +"and M.idMagasin = F.idMagasin and DATEDIFF(month, GETDATE(), F.frequentationDate) = 1 ");
            while(result.next()){
                Frequentation freq = new Frequentation(result.getString("frequentationDate"),result.getInt("idMagasin"), result.getInt("niveauFrequentation"));
                Frequentations.add(freq);        
            }
            return Frequentations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
}