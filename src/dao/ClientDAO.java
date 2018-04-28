package dao;

import pojo.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Client(idClient,name, surname,birthdate, phone, address, gender) values ("+obj.getIdClient()+",\""+obj.getName()+"\","+obj.getSurname()+",\""+obj.getBirthDate()+"\","+obj.getPhone()+"\","+obj.getAddress()+"\","+obj.getGender()+")");
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
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Client SET idClient='" + obj.getIdClient() + "', name=" + obj.getName() + ",surname='" + obj.getSurname() + "',birthdate=" + obj.getBirthDate() + " phone=" + obj.getPhone() + "', address=" + obj.getAddress()+ "', gender=" + obj.getGender()+" where idClient=" + obj.getIdClient());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Client find(int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idClient,name, surname,birthdate, phone, address, gender FROM Client Where idClient="+ id);
            while(result.next()){
                Client client = new Client(result.getInt("idClient"),result.getString("name"), result.getString("surname"), result.getDate("birthdate"), result.getString("phone"), result.getString("adress"), result.getString("gender"));
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
