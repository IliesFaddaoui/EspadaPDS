package connexion;

import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class Connect {
	public static void main(String[]args) throws SQLException{
		Connection connexion = Database.getConnection();
		String sql ="INSERT INTO TEST1(id,nom) values(12,'Ilies')";
		PreparedStatement ordre = connexion.prepareStatement(sql);
		ordre.executeUpdate();
		ordre.close();
		connexion.close();
		
	}
}
