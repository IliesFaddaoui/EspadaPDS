package mappingAxel;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import com.mysql.jdbc.Statement;

import com.google.gson.Gson;

import connexion.PoolDeConnexion;


public class ServerProcessor {

	BufferedInputStream reader=null;
	
	public ServerProcessor() {
		// TODO Auto-generated method stub
		Connection con = BDD();
		EmplacementsDAO empldao = new EmplacementsDAO(con);
		FileWriter fw = null;
		
		

		// Mettre en place socket + seria + thread 
		try {
			fw = new FileWriter("Mapping1.txt");
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		
		Date aujourdhui = new Date();
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("yy-MM-dd");
		
		MagasinsDAO magdao = new MagasinsDAO(con);
		
		int i = 0;
		int j = 1;
		
		OccupationDAO occpdao = new OccupationDAO(con);

		for(i = 1; i < 31; i++) {
			
		// Modifier critÃ¨res attribution emplacement 
		// Add Chiffre d'affaire et zone privilÃ©giÃ© 
			
		Magazins mag1 = magdao.find(i);
		Magazins mag2 = magdao.find(j);
		if (mag1 == null)
			continue ;

		Emplacements empl0 = empldao.find(i); 
		Emplacements empl01 = empldao.find(i);
		 j++;
		if (mag1.getMagasinSuperficie() < empl0.getSuperficie())
			try {
				java.sql.Statement stmt = con.createStatement();
				String sql = "INSERT INTO Occupation(idMagasin, idEmplacement, dateEntree) values ("+mag1.getIdMagasin()+","+ empl0.getIdEmplacement()+", '"+formater.format(aujourdhui)+"')";
				stmt.executeUpdate(sql);
				pw.println("Le magasin "+ mag1.getMagasinName()+" a Ã©tÃ© placÃ© Ã  l'emplacement "+ empl0.getLocalisation());
				
				}catch(SQLException e) {
					pw.println("Le magasin "+mag1.getMagasinName()+" Ã  dÃ©jÃ  Ã©tÃ© placÃ© Ã  l'emplacement "+empl0.getLocalisation());
				}
			
		else if (mag1.getMagasinSuperficie() < empl01.getSuperficie())
		try {
			java.sql.Statement stmt = con.createStatement();
			String sql = "INSERT INTO Occupation(idMagasin, idEmplacement, dateEntree) values ("+mag1.getIdMagasin()+","+ empl01.getIdEmplacement()+", '"+formater.format(aujourdhui)+"')";
			stmt.executeUpdate(sql);
			pw.println("Le magasin "+ mag1.getMagasinName()+" a Ã©tÃ© placÃ© Ã  l'emplacement "+ empl01.getCategorie());
			
		}catch(SQLException e) {
				pw.println("Le magasin "+mag1.getMagasinName()+" a dÃ©jÃ  Ã©tÃ© placÃ© Ã  l'emplacement "+empl01.getLocalisation());
			}
		else 
		pw.println("Le magasin " + mag1.getMagasinName()+" n'a pas pu Ãªtre placÃ©");
		}
		pw.close();
	
	//}
	
	// Pour nouvelle attribution Magasin Emplacement 
	//public void newStore(String magasin, String emplacement) {
		 Socket sock = null;
	 PrintWriter writer = null;
//	 BufferedInputStream reader=null;
	 PoolDeConnexion connection;
	 //writer = new PrintWriter(sock.getOutputStream());
	//	reader = new BufferedInputStream(sock.getInputStream());
		//Gson gson = new Gson();
//	Connection con = BDD();
//		Date aujourdhui = new Date();
	//	SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd-MM-yy");
		MagasinsDAO magdao1 = new MagasinsDAO(con);
		//EmplacementsDAO empldao = new EmplacementsDAO(con);
		try {
			ServerSocket s = new ServerSocket(500);
			System.out.println("test1");
		    Socket socket = s.accept();    
		    System.out.println("test2");
		    BufferedReader plec = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
		    Gson gson = new Gson();

		        while(true) {
		            String str = plec.readLine();
		            System.out.println("--" + str +"--");
		       
		         Occupation e1 = gson.fromJson(str, Occupation.class);
		          System.out.println("magasin = " +e1.magasin + " emplacement = " +e1.emplacement);
		           // String str2 = plec.readLine();
		            if (str.equals("END")) break;
		            //if (str2.equals("END")) break;
		      //     Emplacements e1 = gson.fromJson(str, Emplacements.class);
		            System.out.println(str);
		         //   System.out.println(str2);
		           pred.println(str);
		           // pred.println(str2);
		        
				
			Magazins magname = magdao1.findName(e1.magasin);
		Emplacements emp = empldao.findName(e1.emplacement);
		java.sql.Statement stmt = con.createStatement();
			String sql = "INSERT INTO Occupation(idMagasin, idEmplacement, dateEntree) values ("+magname.getIdMagasin()+","+ emp.getIdEmplacement()+", '"+formater.format(aujourdhui)+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			System.out.println("Le magasin "+ magname.getMagasinName() +" a été placé à  l'emplacement "+ emp.getLocalisation());
		         }
		      plec.close();
		        pred.close();
		        socket.close();
			
			
		        } catch (Exception e) {
			// TODO Auto-generated catch block
		System.out.println("Il y a eu une erreur");
		}}

	class Occupation {
		String magasin;
		String emplacement;
	}
	
	public static Connection BDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK");
			String url="jdbc:mysql://localhost/pds";
			String user="root";
			String password="root";
			Connection con=DriverManager.getConnection(url, user, password);
			System.out.println("Connexion Ã©tablie");
			return con;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}