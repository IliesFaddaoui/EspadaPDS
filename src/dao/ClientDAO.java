package dao;

import com.sun.rowset.CachedRowSetImpl;
import pojo.Client;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DAO<Client> {

    private Connection con;

    public ClientDAO(Connection conn){
        super(conn);
        this.con=conn;
    }

    public Connection getConnection(){
        return this.con;
    }

    @Override
    public boolean create(Client obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Client(idClient, pseudo, password, ClientName, ClientSurname, phone, address, gender) values ("+obj.getIdClient()+",'"+obj.getPseudo()+"','"+obj.getPassword()+"','"+obj.getClientName()+"','"+obj.getClientSurname()+"',',"+obj.getPhone()+"','"+obj.getAddress()+"','"+obj.getGender()+"')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Client obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from Client WHERE idClient=" + obj.getIdClient());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Client obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Client SET idClient='" + obj.getIdClient() + "',pseudo='" + obj.getPseudo() +"',password='" + obj.getPassword() +"', ClientName='" + obj.getClientName() + "',ClientSurname='" + obj.getClientSurname() + "', phone='" + obj.getPhone() + "', address='" + obj.getAddress()+ "', gender='" + obj.getGender()+"' where idClient=" + obj.getIdClient());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Client find(int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idClient,pseudo, password, ClientName, ClientSurname, phone, address, gender FROM Client Where idClient="+ id);
            while(result.next()){
                Client client = new Client(result.getInt("idClient"),result.getString("pseudo"), result.getString("password"),result.getString("ClientName"), result.getString("ClientSurname"), result.getString("phone"), result.getString("address"), result.getString("gender"));
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method return the list of the client id on the client table
     * @return List<String>
     */
    public List<String> listOfClients(){
        try{
            List<String> clientsList = new ArrayList<String>();
            String sql = "SELECT idClient FROM client";
            CachedRowSet rs = new CachedRowSetImpl();
            rs.setCommand(sql);
            rs.execute(con);
            con.close();
            while (rs.next()) {
                clientsList.add(rs.getString("idClient"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
