package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Magasins;


public class MagasinsDAO extends DAO<Magasins>{

	public MagasinsDAO(Connection conn){
		super(conn);
	}
	public boolean create(Magasins obj) {

		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("INSERT INTO Magasins(idMagasins, nom) values ("+obj.getIdMagasin()+",\""+obj.getNom()+"\")");	
			return true;
			} catch (SQLException e) {
				e.printStackTrace();		
			}
		return false;
	}

	
	public boolean delete(Magasins obj) {

		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM 'Magasins' WHERE idMagasins="+obj.getIdMagasin());		
			return true;
		} catch (SQLException e) {
				e.printStackTrace();		
			}
		return false;
	}

	
	public boolean update(Magasins obj) {
		return false;
	}

	
	public Magasins find(int idMagasins) {
		Magasins mag = new Magasins();
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Magasins Where idMagasins= " + idMagasins);		
			} catch (SQLException e) {
				e.printStackTrace();		
			}
		return mag;
	}
	

}
