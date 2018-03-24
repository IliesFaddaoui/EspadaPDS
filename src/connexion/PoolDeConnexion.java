package connexion;

import java.sql.Connection;

public class PoolDeConnexion implements Pool{

    public PoolDeConnexion(int taille){
        private Connection[] tabDispo = new Connection[taille];
        private Connection[] tabOccupe = new Connection[taille];
        for (int i=1; i<taille; i++){
            tabDispo[i]= new Connection;
        }
    }
    public Connection getConnection() {
        return null;
    }

    @Override
    public void releaseConnection() {

    }

    @Override
    public void initialiserPool() {

    }
}
