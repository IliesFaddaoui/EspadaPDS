package MappingAxel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import com.mysql.jdbc.Statement;
import pojo.Emplacements;

public class connecterDB {

/*	public static ArrayList<Emplacements> getAllEmplacements(ArrayList<Integer> idEmplacements, EmplacementsDAO empldao) {
		ArrayList<Emplacements> empls = new ArrayList<Emplacements>();
		for (int id: idEmplacements) {
			empls.add(empldao.find(id));
		}
		return empls;
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = BDD();
		EmplacementsDAO empldao = new EmplacementsDAO(con);
	/*	ArrayList<Integer> idEmpls = empldao.getAllIdEmplacements();
		ArrayList<Emplacements> empls = getAllEmplacements(idEmpls, empldao);*/
		
		Date aujourdhui = new Date();
		
		DateFormat MediumDateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		//System.out.println(MediumDateFormat.format(aujourdhui));
		// Request to select attribut of emplacement on the DB
		Emplacements empl1 = empldao.find(1);
		Emplacements empl2 = empldao.find(2);
		Emplacements empl3 = empldao.find(3);
		Emplacements empl4 = empldao.find(4);
		Emplacements empl5 = empldao.find(5);
		
		// Request to select attribut of magasin
		MagasinsDAO magdao = new MagasinsDAO(con);
	/*	Magazins mag1 = magdao.find(1);
		Magazins mag2 = magdao.find(2);
		Magazins mag3 = magdao.find(3);
		Magazins mag4 = magdao.find(4);*/

		//Magazins mag5 = magdao.findMax();
		int i = 0;
		Emplacements empl10 = empldao.findMax(i);
	
		
		OccupationDAO occpdao = new OccupationDAO(con);
	//	System.out.println(mag5.getIdMagasin());
		// Test d'insertion dans la table Occupation
		
		for(i = 1; i < 20; i+=2) {
			int j=2;
			j+=2;
		Magazins mag1 = magdao.find(i);
		Magazins mag2 = magdao.find(j);
		Emplacements empl0 = empldao.find(i); 
		if (mag1.getMagasinType() != mag2.getMagasinType() && mag1.getMagasinSuperficie() < empl0.getSuperficie())
			try {
				java.sql.Statement stmt = con.createStatement();
				String sql = "INSERT INTO Occupation(idMagasin, idEmplacement, dateEntree) values ("+mag1.getIdMagasin()+","+ empl0.getIdEmplacement()+", '"+MediumDateFormat.format(aujourdhui)+"')";
				stmt.executeUpdate(sql);
				}catch(SQLException e) {
					e.printStackTrace();
				}
		else 
			System.out.println("Regarde bien khoya y'a une erreur");
		//System.out.println("Magasin1 = "+mag1.getIdMagasin());
	//	System.out.println("Emplacement1 = "+ empl1.getIdEmplacement());
		}
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