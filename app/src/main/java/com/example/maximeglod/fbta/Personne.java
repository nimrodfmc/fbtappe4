package com.example.maximeglod.fbta;

public class Personne{
    private String prenom;
    private String nom;
    private int age;
    private String sexe;
    private float taille;
    private float poids;
    private String sport;
    private int obj_poids;

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
