package com.example.maximeglod.fbta;


public class Personne extends Inscription {
    //Propriétés
    Inscription i = new Inscription();
    private String prenom;
    private String nom;
    private int age;
    private String sexe;
    private float taille;
    private float poids;
    private String sport;
    private int objectif;

    //constructeur
    public Personne(String prenom, String nom, int age, String sexe, float taille, float poids, String sport, int objectif) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.sexe = sexe;
        this.taille = taille;
        this.poids = poids;
        this.sport = sport;
        this.objectif = objectif;
    }

//getter / setter

    public Personne(String sexe, String prenom, Integer age, Float taille, Integer poids, Integer act_sport, Integer objectif) {
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String getSexe() {
        return sexe;
    }

    public String getSport() {
        return sport;
    }

    public int getObjectifs() {
        return objectif;
    }


}
