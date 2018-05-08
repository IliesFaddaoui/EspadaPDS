package dao;
import pojo.Emplacements;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ilies
 * this is the Dao for emplacements, which allows to create, delete, update or find an emplacement in the data base
 */
public class EmplacementsDAO extends DAO<Emplacements> {

    private Connection con;
    /**
     * this is the EmplacementDAO constructor. This use a connection in the Connection pool to have access to the database
     * @param conn
     */
    public EmplacementsDAO(Connection conn){
        super(conn);
        this.con=conn;
    }


    public Connection getConnection(){
        return this.con;
    }

    /**
     * this method allows to create an emplacement row in the database
     * @param obj
     * @return boolean
     */
    public boolean create(Emplacements obj) {

        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Emplacements(idEmplacement,localisation, superficie,categorie, tauxOccupation) values ("+obj.getIdEmplacement()+",\""+obj.getLocalisation()+"\","+obj.getSuperficie()+",\""+obj.getCategorie()+"\","+obj.getTauxOccupation()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to delete an emplacement row in the database
     * @param obj
     * @return
     */
    public boolean delete(Emplacements obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from Emplacements WHERE idEmplacement=" + obj.getIdEmplacement());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to update an emplacement row in the database
     * @param obj
     * @return
     */
    public boolean update(Emplacements obj){
            try {
                int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Emplacements SET localisation='" + obj.getLocalisation() + "', superficie=" + obj.getSuperficie() + ",categorie='" + obj.getCategorie() + "',tauxOccupation=" + obj.getTauxOccupation() + " where idEmplacement=" + obj.getIdEmplacement());
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
    /**
     * this method allows to find an emplacement row in the database with its id
     * @param idEmplacement
     * @return Emplacements
     */
    public Emplacements find(int idEmplacement) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idEmplacement, localisation, superficie, categorie, tauxOccupation FROM Emplacements Where idEmplacement="+ idEmplacement);
            while(result.next()){
                Emplacements mag = new Emplacements(result.getInt("idEmplacement"),result.getString("localisation"), result.getInt("superficie"), result.getString("categorie"), result.getFloat("tauxOccupation"));
                return mag;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
