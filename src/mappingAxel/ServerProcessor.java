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
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import connexion.PoolDeConnexion;
import javax.swing.JOptionPane;

/**
 * @author ilies, axel, aramil
 * @version 1.3
 * Class with all the Server sockets and operation with database
 */

public class ServerProcessor {

	BufferedInputStream reader=null;
	
	public ServerProcessor() {
		// TODO Auto-generated method stub
		Connection con = BDD();
		EmplacementsDAO empldao = new EmplacementsDAO(con);
		FileWriter fw = null;
		
		

	
		try {
			fw = new FileWriter("Location.txt");
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		Date aujourdhui = new Date();
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd-MM-yy");
		MagasinsDAO magdao = new MagasinsDAO(con);
		
		int i = 0;
		int j = 1;

		for(i = 1; i < 31; i++) {
		
		Magazins mag1 = magdao.find(i);

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
				pw.println("Le magasin "+ mag1.getMagasinName()+" a été placé à  l'emplacement "+ empl0.getLocalisation());
				
				}catch(SQLException e) {
					pw.println("Le magasin "+mag1.getMagasinName()+" Ã  déjà  été placé à l'emplacement "+empl0.getLocalisation());
				}
			
		else if (mag1.getMagasinSuperficie() < empl01.getSuperficie())
		try {
			java.sql.Statement stmt = con.createStatement();
			String sql = "INSERT INTO Occupation(idMagasin, idEmplacement, dateEntree) values ("+mag1.getIdMagasin()+","+ empl01.getIdEmplacement()+", '"+formater.format(aujourdhui)+"')";
			stmt.executeUpdate(sql);
			pw.println("Le magasin "+ mag1.getMagasinName()+" a été placé à  l'emplacement "+ empl01.getCategorie());
			
		}catch(SQLException e) {
				pw.println("Le magasin "+mag1.getMagasinName()+" a déjà  été placé à  l'emplacement "+empl01.getLocalisation());
			}
		else 
		pw.println("Le magasin " + mag1.getMagasinName()+" n'a pas pu être placé");
		}
		pw.close();
		JOptionPane jop1;
		jop1 = new JOptionPane();
		jop1.showMessageDialog(null, "Serveur lancé", "Information", JOptionPane.INFORMATION_MESSAGE);

		Socket sock = null;
		PrintWriter writer = null;
		PoolDeConnexion connection;
		// Waiting client socket
		try {
			ServerSocket s = new ServerSocket(5001);
			while (true) {
				Socket clientSocket = s.accept();
				new Thread(new CreateNewStore(clientSocket, con)).start();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
		}}

	// Connection to the database
	public static Connection BDD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver OK");
			String url="jdbc:mysql://localhost/pds";
			String user="root";
			String password="root";
			Connection con=DriverManager.getConnection(url, user, password);
			System.out.println("Connexion etablie");
			return con;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

	class Occupation1 {
	String magasin;
	String emplacement;
}
	// Permits to map new store with the information received by the client
	class CreateNewStore implements Runnable {
	Socket clientSocket;
	Connection con;
	public CreateNewStore(Socket clientSocket, Connection con) {
		this.clientSocket = clientSocket;
		this.con = con;
	}
	@Override
	public void run() {
		
		try {
			BufferedReader plec = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())),true);
			Gson gson = new Gson();

			while(true) {
				String str = plec.readLine();
				System.out.println("--" + str +"--");

				Occupation1 e1 = gson.fromJson(str, Occupation1.class);
				System.out.println("magasin = " +e1.magasin + " emplacement = " +e1.emplacement);
				if (str.equals("END")) break;
				System.out.println(str);
				pred.println(str);
				MagasinsDAO magdao1 = new MagasinsDAO(con);

				Date aujourdhui = new Date();
				SimpleDateFormat formater = null;
				formater = new SimpleDateFormat("yy-MM-dd");


				Magazins magname = magdao1.findName(e1.magasin);
				EmplacementsDAO empldao = new EmplacementsDAO(con);
				Emplacements emp = empldao.findName(e1.emplacement);
				java.sql.Statement stmt;

				stmt = con.createStatement();

				String sql = "INSERT INTO Occupation(idMagasin, idEmplacement, dateEntree) values ("+magname.getIdMagasin()+","+ emp.getIdEmplacement()+", '"+formater.format(aujourdhui)+"')";
				System.out.println(sql);
				stmt.executeUpdate(sql);

				System.out.println("Le magasin "+ magname.getMagasinName() +" a été placé à  l'emplacement "+ emp.getLocalisation());
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		
	}
	
}
