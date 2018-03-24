package dao;
import pojo.Emplacements;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ilies
 * DAO class for emplacement
 */
public class EmplacementsDAO extends DAO<Emplacements> {

    public EmplacementsDAO(Connection conn){
        super(conn);
    }


    public boolean create(Emplacements obj) {

        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Emplacements(idEmplacement,localisation, superficieE,categorie, tauxOccupation) values ("+obj.getIdEmplacement()+",\""+obj.getLocalisation()+"\","+obj.getSuperficieE()+",\""+obj.getCategorie()+"\","+obj.getTauxOccupation()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(Emplacements obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from Emplacements WHERE idEmplacement=" + obj.getIdEmplacement());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean update(Emplacements obj){
            try {
                int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Emplacements SET localisation='" + obj.getLocalisation() + "', superficieE=" + obj.getSuperficieE() + ",categorie='" + obj.getCategorie() + "',tauxOccupation=" + obj.getTauxOccupation() + " where idEmplacement=" + obj.getIdEmplacement());
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
    public Emplacements find(int idEmplacement) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idEmplacement, localisation, superficieE, categorie, tauxOccupation FROM Emplacements Where idEmplacement="+ idEmplacement);
            while(result.next()){
                Emplacements mag = new Emplacements(result.getInt("idEmplacement"),result.getString("localisation"), result.getInt("superficieE"), result.getString("categorie"), result.getFloat("tauxOccupation"));
                return mag;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
