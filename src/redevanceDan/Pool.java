package redevanceDan;

import java.sql.Connection;

/**
 * @author ilies
 * this interface define the methods needed in Pool classes
 */
public interface Pool {
    public Connection getConnection();
    public boolean releaseConnection(Connection c);

}
