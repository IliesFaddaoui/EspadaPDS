package said;

import dao.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Magasins;
import pojo.Occupation;
import said.ParcoursType;
import pojo.TypeProfile;

public class ParcoursTypeDAO extends DAO<ParcoursType> {

	private Connection con;
	
	
	public ParcoursTypeDAO(Connection conn){
		super(conn);
		this.con=conn;
		
	}
	
	public boolean create(ParcoursType obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean delete(ParcoursType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(ParcoursType obj) {
		// TODO Auto-generated method stub
		return false;
	}


	public ParcoursType find(int idMagasin, int idTypeProfile) {
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idMagasin, idTypeProfile FROM ParcoursType Where idMagasin="+ idMagasin +"AND idTypeProfile="+ idTypeProfile);
			while(result.next()){
				ParcoursType parcty = new ParcoursType (result.getInt("idMagasin"),result.getInt("idTypeProfile"));
				return parcty;
			}
			} catch (SQLException e) {
				e.printStackTrace();		
			}
		
		
		return null;
	}


	public ParcoursType find(int idMagasin) {
		return null;
		
	}
}