package dao;

import pojo.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO extends DAO<Product> {

    private Connection con;

    public ProductDAO(Connection conn){
        super(conn);
        this.con=conn;
    }

    public Connection getConnection(){
        return this.con;
    }

    @Override
    public boolean create(Product obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Product(idProduct ,productReference, stock,price, keyWord) values ("+obj.getIdProduct()+",\""+obj.getProductReference()+"\","+obj.getStock()+",\""+obj.getStock()+"\","+obj.getPrice()+"\","+obj.getKeyWord()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Product obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from Product WHERE idProduct=" + obj.getIdProduct());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Product SET productReference=" + obj.getProductReference() + ",stock='" + obj.getStock() + "',price=" + obj.getPrice() + " keyWord=" + obj.getKeyWord()+ " where idProduct=" + obj.getIdProduct());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product find(int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idProduct, productReference, stock, price,keyword FROM Product Where idProduct="+ id);
            while(result.next()){
                Product product = new Product(result.getInt("idProduct"),result.getString("productReference"), result.getInt("stock"), result.getInt("price"), result.getString("keyWord"));
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
