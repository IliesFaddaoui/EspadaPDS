package MappingAxel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



public class MagasinsDAO extends DAO<Magazins>{

	private Connection con;
	/**
	 * this is the Magazins constructor. This use a connection in the Connection pool to have access to the database
	 * @param conn
	 */
	public MagasinsDAO(Connection conn){
		super(conn);
		this.con=conn;
	}
	/**
	 * this method allows to create a Magasin row in the database
	 * @param obj
	 * @return boolean
	 */
	public boolean create(Magazins obj) {

		try{
			int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Magasins(idMagasins, magasinName, magasinType, magasinSuperficie) values ("+obj.getIdMagasin()+",\""+obj.getMagasinName()+"\","+obj.getMagasinType()+","+obj.getMagasinSuperficie()+")");	
			return true;
			} catch (SQLException e) {
				e.printStackTrace();		
			}
		return false;
	}

	/**
	 * this method allows to delete a Magasin row in the database
	 * @param obj
	 * @return boolean
	 */
	public boolean delete(Magazins obj) {

		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM 'Magasins' WHERE idMagasins="+obj.getIdMagasin());		
			return true;
		} catch (SQLException e) {
				e.printStackTrace();		
			}
		return false;
	}

	/**
	 * this method allows to update a Magasin row in the database
	 * @param obj
	 * @return boolean
	 */
	public boolean update(Magazins obj) {
		return false;
	}

	/**
	 * this method allows to find a Magasin row in the database
	 * @param idMagasins
	 * @return Magazins
	 */
	public Magazins find(int i) {
		;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idMagasin, magasinName, magasinType, magasinSuperficie FROM magasin Where idMagasin="+i);
			while(result.next()){
				Magazins mag = new Magazins(result.getInt("idMagasin"), result.getString("magasinName"), result.getString("magasinType"), result.getInt("magasinSuperficie"));
				return mag;
			}
			} catch (SQLException e) {
				e.printStackTrace();		
			}
		return null;
		
	}
	
	public Magazins findName(String i) {
		;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idMagasin, magasinName, magasinType, magasinSuperficie FROM magasin Where magasinName='"+i+"'");
			while(result.next()){
				Magazins mag = new Magazins(result.getInt("idMagasin"), result.getString("magasinName"), result.getString("magasinType"), result.getInt("magasinSuperficie"));
				return mag;
			}
			} catch (SQLException e) {
				e.printStackTrace();		
			}
		return null;
		
	}
	
	public Magazins findMax(int i) {

		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM magasin ORDER BY magasinSuperficie DESC LIMIT 1 IS NOT NULL");
			while(result.next()){
				Magazins mag = new Magazins(result.getInt("idMagasin"), result.getString("magasinName"), result.getString("magasinType"), result.getInt("magasinSuperficie"));
				return mag;
			}
			} catch (SQLException e) {
				e.printStackTrace();		
			}
		return null;
		
	}

}
