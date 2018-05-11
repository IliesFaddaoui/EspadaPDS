package redevanceDan;

import java.util.Date;

import dao.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


  
  public class FactureDAO extends DAO<Facture> {

      private Connection con;
      /**
       * this is the FactureDAO constructor. This use a connection in the Connection pool to have access to the database
       * @param conn
       */
      public FactureDAO(Connection conn){
          super(conn);
          this.con=conn;
      }


      public Connection getConnection(){
          return this.con;
      }

      /**
       * this method allows to create a facture row in the database
       * @param obj
       * @return boolean
       */
      public boolean create(Facture obj) {

          try{
              int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate
                  ("INSERT INTO Facture(idFacture, Date factureDate, int idMagasin, int idEmplacement, boolean categorie, int niveauFrequentation, int montant) "
                    + "values ("+obj.getIdFacture()+",\""+obj.getFactureDate()+"\","+obj.getIdMagasin()+",\""+obj.getIdEmplacement()+"\","+obj.isCategorie()+"\","+obj.getNiveauFrequentation()+"\","+obj.getMontant()+")");
              return true;
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return false;
      }
      /**
       * this method allows to delete an facture row in the database
       * @param obj
       * @return
       */
      public boolean delete(Facture obj) {
          try {
              int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE from Facture WHERE idFacture=" + obj.getIdFacture());
              return true;
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return false;
      }
      /**
       * this method allows to update an facture row in the database
       * @param obj
       * @return
       */
      public boolean update(Facture obj){
              try {
                  int result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("UPDATE Facture SET factureDate='" + obj.getFactureDate() + "', idMagasin=" + obj.getIdMagasin() + ",idEmplacement='" + obj.getIdEmplacement() + "',categorie=" + obj.isCategorie() + "',idNiveauFrequentation=" + obj.getNiveauFrequentation() + "', montant=" + obj.getMontant() + " where idFacture=" + obj.getIdFacture());
                  return true;
              } catch (SQLException e) {
                  e.printStackTrace();
              }
              return false;
          }
      /**
       * this method allows to find a facture row in the database with its id
       * @param idFacture
       * @return Facture
       */
      public Facture find(int idFacture) {
          try{
              ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idFacture, factureDate, idMagasin, idEmplacement, categorie, niveauFrequentation, montant FROM Facture Where idFacture="+ idFacture);
              while(result.next()){
                  Facture fact = new Facture(result.getInt("idFacture"),result.getDate("factureDate"), result.getInt("idMagasin"), result.getInt("idEmplacement"), result.getBoolean("categorie"), result.getInt("niveauFrequentation"), result.getInt("montant"));
                  return fact;
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return null;
      }
  }


