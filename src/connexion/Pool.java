package connexion;

import java.sql.Connection;

public interface Pool {
    public Connection getConnection();
    public void releaseConnection();
    public void initialiserPool();

}
