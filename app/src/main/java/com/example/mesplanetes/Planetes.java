package com.example.mesplanetes;

public class Planetes {
    private String nom;
    private String description;
    private String taille;
    private String vitesse;
    private int image;

    Planetes(String Nom,String Description,String Taille,String Vitesse, int Image){
        nom=Nom;
        description=Description;
        image=Image;
        taille=Taille;
        vitesse=Vitesse;

    }


    public String getNom() {
        return nom;
    }
    public String getDescription() {
        return description;
    }
    public int  getImage() {
        return image;
    }
    public String getTaille() {
        return taille;
    }
    public String getVitesse() {
        return vitesse;
    }

}
