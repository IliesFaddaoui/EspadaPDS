package redevanceDan;

import java.util.*;
import java.util.ArrayList;
import java.util.Date;

public class Facture 
{
  private int idFacture;
  private Date factureDate;
  private int idMagasin;
  private int idEmplacement;
  private boolean categorie;
  private int niveauFrequentation;
  private double montant;
  private int chiffreDaffaires;
  private boolean caterogie;
  private int superficie;
  
  public Facture(int idFacture, Date factureDate, int idMagasin, int idEmplacement, boolean categorie, int niveauFrequentation, int montant ){
    this.idFacture = idFacture; 
    this.factureDate = factureDate;
    this.idMagasin = idMagasin;
    this.idEmplacement = idEmplacement;
    this.setCategorie(categorie);
    this.niveauFrequentation = niveauFrequentation;
    this.montant = montant;
  }

  public Date getFactureDate()
  {
    return factureDate;
  }

  public void setFactureDate(Date factureDate)
  {
    this.factureDate = factureDate;
  }

  public int getIdMagasin()
  {
    return idMagasin;
  }

  public void setIdMagasin(int idMagasin)
  {
    this.idMagasin = idMagasin;
  }

  public int getIdEmplacement()
  {
    return idEmplacement;
  }

  public void setIdEmplacement(int idEmplacement)
  {
    this.idEmplacement = idEmplacement;
  }

  public int getNiveauFrequentation()
  {
    return niveauFrequentation;
  }

  public void setNiveauFrequentation(int niveauFrequentation)
  {
    this.niveauFrequentation = niveauFrequentation;
  }

  public double getMontant()
  {
    return montant;
  }

  public void setMontant(double montant)
  {
    {
      if (isCaterogie() == true){
        montant = ((getChiffreDaffaires()/getSuperficie())+(niveauFrequentation)*1.2);
        }else{
        montant = ((getChiffreDaffaires()/getSuperficie())+(niveauFrequentation));
      }
    } 
  }

  public boolean isCategorie()
  {
    return categorie;
  }

  public void setCategorie(boolean categorie)
  {
    this.categorie = categorie;
  }

  public int getIdFacture()
  {
    return idFacture;
  }

  public void setIdFacture(int idFacture)
  {
    this.idFacture = idFacture;
  }
  

  public int getChiffreDaffaires()
  {
    return chiffreDaffaires;
  }

  public void setChiffreAffaire(int chiffreDaffaires)
  {
    this.chiffreDaffaires = chiffreDaffaires;
  }

  public boolean isCaterogie()
  {
    return caterogie;
  }

  public void setCaterogie(boolean caterogie)
  {
    this.caterogie = caterogie;
  }

  public int getSuperficie()
  {
    return superficie;
  }

  public void setSuperficie(int superficie)
  {
    this.superficie = superficie;
  }
  
 
  
  
  
}
