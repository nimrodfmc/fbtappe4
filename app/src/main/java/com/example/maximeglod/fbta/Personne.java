package com.example.maximeglod.fbta;


import android.widget.TextView;

public class Personne extends Inscription {
    private String prenom;
    private String nom;
    private int age;
    private String sexe;
    private float taille;
    private float poids;
    private String sport;
    private int objectif;
    /*public float Calorie;*/

    TextView tv_objectif, tv_calorie, tv_conso, tv_total;
    Personne p1 = new Personne("Jules", "Couraud", 18, "Homme", (float) 1.78, (float) 90, "Intensité forte", 80);
    //TextView total = (TextView )findViewById(R.id.tv_total);
//tftgj
    public float totalcal = 2500;

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
        return objectif ;
    }



    Inscription i = new Inscription();


}