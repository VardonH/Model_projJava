/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pedago
 */
public class Produit {
    
    private String nProduit;
    private int fournisseur;
    private int categorie;
    private float prixUnitaire;
    private float quantiteParUnite;
    private int unitesEnStock;
    private int unites_Commandees;
    private int niveauReaprovi;
    private boolean indisponible;

    public Produit(String nProduit, int fournisseur, int categorie, float prixUnitaire, float quantiteParUnite, int unitesEnStock, int unites_Commandees, int niveauReaprovi, boolean indisponible) {
        this.nProduit = nProduit;
        this.fournisseur = fournisseur;
        this.categorie = categorie;
        this.prixUnitaire = prixUnitaire;
        this.quantiteParUnite = quantiteParUnite;
        this.unitesEnStock = unitesEnStock;
        this.unites_Commandees = unites_Commandees;
        this.niveauReaprovi = niveauReaprovi;
        this.indisponible = indisponible;
    }
    
    
    
    
    
    
}
