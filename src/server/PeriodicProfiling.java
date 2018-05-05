package server;

import connexion.PoolDeConnexion;

import java.util.TimerTask;

public class PeriodicProfiling extends TimerTask {

    PoolDeConnexion connection;
    public PeriodicProfiling(PoolDeConnexion connection){
        this.connection=connection;

    }
    public void run(){

    }
}
