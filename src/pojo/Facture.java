package pojo;

import java.util.*;

public class Facture
{
  private int idFacture;
  private Date factureDate;
  private int idMagasin;
  private int idEmplacement;
  private boolean categorie;
  private int niveauFrequentation;
  private int montant;
  
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

  public int getMontant()
  {
    return montant;
  }

  public void setMontant(int montant)
  {
    this.montant = montant;
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
  
  
  public int CalculRedevance(int chiffreAffaire, boolean caterogie, int niveauFrequentation, int superficie) {
    
    if (caterogie == true) 
    {montant = (int)((chiffreAffaire/superficie)+(niveauFrequentation)*1.2);}
    else 
    {montant = (int)((chiffreAffaire/superficie)+(niveauFrequentation));}
    return montant;
  }
}
