package analyseAnax;

import analyseAnax.Product;
import dao.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Ilies
 * @version 1
 * this is the Dao class for Product database table. This class allows to create, delete, update or find a Product in the data base
 */
public class ProductDAO extends DAO<Product> {

    private Connection con;
    /**
     * this is the Product constructor. This use a connection in the Connection pool to have access to the database
     * @param conn
     */
    public ProductDAO(Connection conn){
        super(conn);
        this.con=conn;
    }
    /**
     * this method allows to create a Product row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean create(Product obj) {
        try{
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO Product(productReference, price, keyWord) values ('"+obj.getProductReference()+"',"+obj.getPrice()+","+obj.getKeyWord()+")");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to delete a Product row in the database
     * @param obj
     * @return boolean
     */
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
    /**
     * this method allows to update a Product row in the database
     * @param obj
     * @return boolean
     */
    @Override
    public boolean update(Product obj) {
        try {
            int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Product SET productReference='" + obj.getProductReference() + "',price=" + obj.getPrice() + ", keyWord=" + obj.getKeyWord()+ " where idProduct=" + obj.getIdProduct());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * this method allows to find a Product row in the database with its id
     * @param id
     * @return Product
     */
    @Override
    public Product find(int id) {
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idProduct, productReference, price,keyword FROM Product Where idProduct="+ id);
            while(result.next()){
                Product product = new Product(result.getInt("idProduct"),result.getString("productReference"), result.getInt("price"), result.getInt("keyWord"));
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
