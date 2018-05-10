package dao;

import com.sun.rowset.CachedRowSetImpl;
import pojo.LinkTPKeyWord;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ilies
 * @version 1
 * this is the Dao class for LinkTPKeyWord database table. This table creates link between a keyword, and a type profile. This class allows to create, delete, update or find an link in the data base
 */
public class LinkTPKeyWordDAO extends DAO<LinkTPKeyWord> {

    private Connection con;

    /**
     * this is the LinkTPKeyWordDAO constructor. This use a connection in the Connection pool to have access to the database
     * @param conn
     */
    public LinkTPKeyWordDAO(Connection conn){
        super(conn);
        this.con=conn;
    }

    /**
     * this method allows to create an LinkTPKeyWord row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean create(LinkTPKeyWord obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO LinkTPKeyWord(idLTPKW,idKeyWord, idTypicalProfile) values ("+obj.getIdLinkTPKeyWord()+",\""+obj.getIdKeyWord()+"\","+obj.getIdTypeProfile()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to delete an LinkTPKeyWord row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean delete(LinkTPKeyWord obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from LinkTPKeyWord WHERE idLTPKW=" + obj.getIdLinkTPKeyWord());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to udpate an LinkTPKeyWord row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean update(LinkTPKeyWord obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE LinkTPKeyWord SET idLTPKW='" + obj.getIdLinkTPKeyWord() + "', idKeyWord=" + obj.getIdKeyWord()+" where idTypicalProfile=" + obj.getIdTypeProfile());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to find an LinkTPKeyWord row in the database with its id
     * @param id
     * @return LinkTPKeyWord
     */
    @Override
    public LinkTPKeyWord find(int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idLTPKW,idKeyWord, idTypicalProfile FROM LinkTPKeyWord Where idLTPKW="+ id);
            while(result.next()){
                LinkTPKeyWord linkTPKeyWord = new LinkTPKeyWord(result.getInt("idLTPKW"),result.getInt("idKeyWord"), result.getInt("idTypicalProfile"));
                return linkTPKeyWord;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getTPKeywords(int id){
        try{
            List<String> listClientTP = new ArrayList<String>();
            String sql = "select tp.ProfileName from client c, typeprofile tp, linkclienttp ltpc Where c.idClient = ltpc.idClient and tp.idTypeProfile = ltpc.idTypicalProfile and ltpc.idClient = "+ id + ";";
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
