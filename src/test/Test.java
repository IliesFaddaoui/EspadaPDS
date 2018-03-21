package test;
import java.sql.Connection;
import java.sql.SQLException;

import connexion.Database;
import dao.MagasinsDAO;
import pojo.Magasins;
public class Test {

	public static void main(String[] args) throws SQLException {
		Connection connexion = Database.getConnection();
		MagasinsDAO m1Dao = new MagasinsDAO(connexion);
		System.out.print(m1Dao.find(2).getNom());
		//Magasins m1 = new Magasins(2, "auchan", 120, 2);
		//m1Dao.create(m1);
	}

}
