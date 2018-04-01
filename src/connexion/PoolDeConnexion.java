package connexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ilies
 * @version 1.2
 * This class set the connection pool, and define methods.
 */
public class PoolDeConnexion implements Pool{

    /**
     * This list contains all the available Connection in the pool
     */
    private List<Connection> ListDispo = new ArrayList<Connection>();
    /**
     * This list contains all the used Connection in the pool
     */
    private List<Connection> ListUsed = new ArrayList<Connection>();

    /**
     * Class constructor, which create the amount of connection asked for the pool
     * @param Poolsize
     */
    public PoolDeConnexion(final int Poolsize){
        for (int i=0; i<Poolsize; i++){
            try{
                ListDispo.add(this.newConnection());
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public List<Connection> getListUsed(){
        return this.ListUsed;
    }
    /**
     * public method which return a connection from the pool only if
     * @return Connection
     */
    public Connection getConnection() {
        if (ListDispo.size() == 0) {
            System.out.println("No connection available, try later");
            return null;
        }
        Connection c =ListDispo.remove(ListDispo.size() - 1);
        System.out.println("Connection done");
        ListUsed.add(c);
        return c;

    }

    /**
     * This method releases a connection on the pool
     * @param c
     * @return boolean
     */
    public boolean releaseConnection(Connection c) {
            ListUsed.remove(c);
            ListDispo.add(c);
            return true;
    }

    /**
     * this method instances a new connection, using the database class
     * @return Connection
     * @throws SQLException
     */
    private Connection newConnection() throws SQLException {
        return Database.getConnection();
    }
}





