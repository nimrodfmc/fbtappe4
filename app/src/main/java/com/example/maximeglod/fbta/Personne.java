package com.example.maximeglod.fbta;

public class Personne{
    public String prenom;
    public String nom;
    public int age;
    public String sexe;
    public float taille;
    public float poids;
    public String sport;
    public int obj_poids;
/*public float Calorie;*/

    //constructeur
    public Personne(String prenom, String nom, int age, String sexe, float taille, float poids, String sport, int obj_poids) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.sexe = sexe;
        this.taille = taille;
        this.poids = poids;
        this.sport = sport;
        this.obj_poids = obj_poids;
    }
}

