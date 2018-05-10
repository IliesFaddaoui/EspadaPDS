package dao;

import com.sun.rowset.CachedRowSetImpl;
import pojo.KeyWord;
import pojo.LinkClientTP;
import pojo.TypeProfile;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ilies
 * @version 1
 * this is the Dao class for LinkClientTP database table. This table creates link between client profile, and type profile. This class allows to create, delete, update or find an link in the data base
 */
public class LinkClientTPDAO extends DAO<LinkClientTP> {

    private Connection con;
    /**
     * this is the LinkClientTPDAO constructor. This use a connection in the Connection pool to have access to the database
     * @param conn
     */
    public LinkClientTPDAO(Connection conn){
        super(conn);
        this.con=conn;
    }

    public Connection getConnection(){
        return this.con;
    }
    /**
     * this method allows to create an LinkClientTP row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean create(LinkClientTP obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO LinkClientTP(idLinkClientTP,idTypeProfile, idClient) values ("+obj.getIdLinkClientTP()+",\""+obj.getIdTypeProfile()+"\","+obj.getIdClient()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to delete an LinkClientTP row in the database
     * @param obj
     * @return boolean
     */
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
    /**
     * this method allows to update an LinkClientTP row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean update(LinkClientTP obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE LinkClientTP SET idClient='" + obj.getIdClient() + "', idTypicalProfile=" + obj.getIdTypeProfile()+" where idLinkClientTP=" + obj.getIdLinkClientTP());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to find an LinkClientTP row in the database
     * @param id
     * @return LinkClientTP
     */
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

    public List<String> getClientLinkedTP(int id){
        try{
            List<String> listClientTP = new ArrayList<String>();
            String sql = "select tp.ProfileName from client c, typeprofile tp, linkclienttp ltpc Where c.idClient = ltpc.idClient and tp.idTypeProfile = ltpc.idTypeProfile and ltpc.idClient = "+ id + ";";
            CachedRowSet rs = new CachedRowSetImpl();
            rs.setCommand(sql);
            rs.execute(this.connect);
            this.connect.close();
            while (rs.next()) {
                listClientTP.add(rs.getString("ProfileName"));
            }
            rs.close();
            return listClientTP;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
