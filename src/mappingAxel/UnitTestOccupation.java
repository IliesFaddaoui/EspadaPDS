package mappingAxel;

import java.sql.Connection;
import java.sql.DriverManager;
import connexion.PoolDeConnexion;

public class UnitTestOccupation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PoolDeConnexion connection= new PoolDeConnexion(10);
		Connection con = BDD();
		
		//TEST new Occupation
		OccupationDAO occpdao = new OccupationDAO(con);
		Occupation oc1 = occpdao.find(1, 1);
		System.out.println("idMagasin : "+oc1.getIdMagasin()+" Date Entree : "+oc1.getDateEntree());
	}
	
	public static Connection BDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK");
			String url="jdbc:mysql://localhost/pds";
			String user="root";
			String password="root";
			Connection con=DriverManager.getConnection(url, user, password);
			System.out.println("Connexion établie");
			return con;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
