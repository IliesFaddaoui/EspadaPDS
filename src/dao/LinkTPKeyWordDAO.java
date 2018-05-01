package dao;

import pojo.LinkTPKeyWord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LinkTPKeyWordDAO extends DAO<LinkTPKeyWord> {

    private Connection con;

    public LinkTPKeyWordDAO(Connection conn){
        super(conn);
        this.con=conn;
    }
    @Override
    public boolean create(LinkTPKeyWord obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO LinkTPKeyWord(idLTPKW,idKeyWord, idTypicalProfile) values ("+obj.getIdLinkTPKeyWord()+",\""+obj.getIdKeyWord()+"\","+obj.getIdTypicalProfile()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

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

    @Override
    public boolean update(LinkTPKeyWord obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE LinkTPKeyWord SET idLTPKW='" + obj.getIdLinkTPKeyWord() + "', idKeyWord=" + obj.getIdKeyWord()+" where idTypicalProfile=" + obj.getIdTypicalProfile());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

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
}
