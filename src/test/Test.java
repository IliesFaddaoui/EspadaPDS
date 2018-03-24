package test;
import java.sql.Connection;
import java.sql.SQLException;

import connexion.Database;
import connexion.PoolDeConnexion;
import dao.MagasinsDAO;
import pojo.Magasins;
import dao.EmplacementsDAO;
import pojo.Emplacements;
public class Test {

	public static void main(String[] args) throws SQLException {
		//Connection connexion = Database.getConnection();
		//MagasinsDAO m1Dao = new MagasinsDAO(connexion);
		//System.out.print(m1Dao.find(2).getNom());
		//Magasins m1 = new Magasins(2, "auchan", 120, 2);
		//m1Dao.create(m1);
		//System.out.print(m1Dao.find(2).getNom());
		//EmplacementsDAO e1DAO = new EmplacementsDAO(connexion);
		//Emplacements e1 = new Emplacements(1,"Bas-gauche",150, "A", 82);
		//e1DAO.create(e1);
		//System.out.println("ancienne loca: "+e1DAO.find(1).getLocalisation());
		//e1.setLocalisation("Haut-droite");
		//e1DAO.update(e1);
		//System.out.println("nouvelle loca: "+ e1DAO.find(1).getLocalisation());
		PoolDeConnexion con = new PoolDeConnexion(3);
		MagasinsDAO m1dao = new MagasinsDAO(con.getConnection());
		MagasinsDAO m2dao = new MagasinsDAO(con.getConnection());
		MagasinsDAO m3dao = new MagasinsDAO(con.getConnection());
		MagasinsDAO m4dao = new MagasinsDAO(con.getConnection());
		con.releaseConnection(m1dao.getConnection());
		MagasinsDAO m5dao = new MagasinsDAO(con.getConnection());



	}

}
