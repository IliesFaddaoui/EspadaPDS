package MappingAxel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import pojo.Emplacements;

public class connecterDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = BDD();
		EmplacementsDAO empldao = new EmplacementsDAO(con);
		Emplacements empl1 = empldao.find(9);
		System.out.println("idEmplacement = "+empl1.getIdEmplacement()+" localisation = "+empl1.getLocalisation());
	}
	
	public static Connection BDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK");
			String url="jdbc:mysql://localhost/pds";
			String user="root";
			String password="root";
			Connection con=DriverManager.getConnection(url, user, password);
			System.out.println("Connexion �tablie");
			return con;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
