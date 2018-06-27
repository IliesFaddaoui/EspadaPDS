package analyseAnax;

import com.sun.rowset.CachedRowSetImpl;
import analyseAnax.ChiffreDaffaires;
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
import java.util.Collection;
import java.util.List;
import dao.DAO;

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
	
	/**
     * this method allows to find a turnover list in the database with the sector of store
     * @param type
     * @return ChiffresDaffaires
     */
	public Collection<ChiffreDaffaires> find(String type) {
		Collection <ChiffreDaffaires> ChiffresDaffaires = new ArrayList<ChiffreDaffaires>();
		try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT C.chiffreDate, C.idMagasin, C.montant FROM ChiffreDaffaires as C, Magasin as M Where M.magasinType='"+ type +"'and M.idMagasin = C.idMagasin and (month(now()) - month(C.chiffreDate)) = 1 ");
            while(result.next()){
                ChiffreDaffaires chiffre = new ChiffreDaffaires(result.getString("chiffreDate"),result.getInt("idMagasin"), result.getInt("montant"));
                ChiffresDaffaires.add(chiffre);        
            }
            return ChiffresDaffaires;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	public Collection<ChiffreDaffaires> findHistory(int idMagasin) throws SQLException{
		Collection <ChiffreDaffaires> ChiffresDaffaires = new ArrayList<ChiffreDaffaires>();
		ResultSet compteur = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT Count DISTINCT (chiffreDate) as count FROM ChiffreDaifaires");
		int cpt = compteur.getInt("count");
		try {
			for(int i = 1; i<cpt; i++) {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT C.chiffreDate C.idMagasin, C.montant FROM ChiffreDaffaires as C, Magasin as M Where M.idMagasin="+ idMagasin +"and M.idMagasin = C.idMagasin and DATEDIFF(month, GETDATE(), C.chiffreDate) = " + i);
            while(result.next()){
                ChiffreDaffaires chiffre = new ChiffreDaffaires(result.getString("chiffreDate"),result.getInt("idMagasin"), result.getInt("montant"));
                ChiffresDaffaires.add(chiffre);        
            }
			}
			return ChiffresDaffaires;
		}
		catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
}
