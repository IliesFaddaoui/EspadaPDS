package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Magasins;
import pojo.Occupation;

public class OccupationDAO extends DAO<Occupation>{
	

		private Connection con;
		/**
		 * this is the Magasins constructor. This use a connection in the Connection pool to have access to the database
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
		public Occupation find(int idMagasin) {
			;
			try{
				ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idEmplacement, idMagasin, dateEntree, dateSortie FROM Occupation Where idMagasin="+ idMagasin);
				while(result.next()){
					Occupation occup = new Occupation(result.getInt("idEmplacement"),result.getInt("idMagasin"), result.getString("dateEntree"), result.getString("dateSortie"));
					return occup;
				}
				} catch (SQLException e) {
					e.printStackTrace();		
				}
			return null;
			
		}
		

	}
}
