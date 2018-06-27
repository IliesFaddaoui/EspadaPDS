package analyseAnax;

import java.sql.Connection;
import dao.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import analyseAnax.Magasins;
import analyseAnax.Occupation;
import analyseAnax.Stock;

public class OccupationDAO extends DAO<Occupation>{
	

		private Connection con;
		/**
		 * @author Anaximandro
		 * this is the Occupation constructor. This use a connection in the Connection pool to have access to the database
		 * @param conn
		 */
		public OccupationDAO(Connection conn){
			super(conn);
			this.con=conn;
		}
		/**
		 * this method allows to create a Magasin row in the database
		 * @param obj
		 * @return boolean
		 */
		public boolean create(Occupation obj) {

			try{
				int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Occupation(idEmplacement, idMagasin, dateEntree, dateSortie) values ("+obj.getIdEmplacement()+",\""+obj.getIdMagasin()+"\","+obj.getDateEntree()+","+obj.getDateSortie()+")");	
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
		public boolean delete(Occupation obj) {

			try{
				ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("DELETE FROM 'Occupation' WHERE idEmplacement"+obj.getIdEmplacement());		
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
		public boolean update(Occupation obj) {
			return false;
		}

		/**
		 * this method allows to find a Magasin row in the database
		 * @param idMagasins
		 * @return Magasins
		 */
		public Occupation find(int idMagasin, int idEmplacement) {
			
			try{
				ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idEmplacement, idMagasin, dateEntree, dateSortie FROM Occupation Where idMagasin="+ idMagasin + "AND idEmplacement="+ idEmplacement);
				while(result.next()){
					Occupation occup = new Occupation(result.getInt("idEmplacement"),result.getInt("idMagasin"), result.getString("dateEntree"), result.getString("dateSortie"));
					return occup;
				}
				} catch (SQLException e) {
					e.printStackTrace();		
				}
			return null;
			
		}
		
		public Occupation find(int idMagasin) {
			return null;
		}
		public Collection<Integer> findOccupation() throws SQLException{
			Collection <Integer> Occupations = new ArrayList<Integer>();
			ResultSet compteur = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT Count DISTINCT (dateEntree) as count FROM Occupation");
			int cpt = compteur.getInt("count");
			try {
				for(int i = 1; i<cpt; i++) {
	            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT Count DISTINCT (dateEntree) as count2 FROM Occupation Where dateSortie = null and DATEDIFF(month, GETDATE(), S.dateEntree) = " + i);
	            while(result.next()){
	            	int cpt2 = compteur.getInt("count2");
	            	Occupations.add(cpt2);        
	            }
				}
				return Occupations;
			}
			catch (SQLException e) {
	            e.printStackTrace();
	        }
			return null;
	}

}