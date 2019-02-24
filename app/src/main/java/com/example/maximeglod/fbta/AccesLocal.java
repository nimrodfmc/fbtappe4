package com.example.maximeglod.fbta;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.w3c.dom.Text;

public class AccesLocal {

    //propriétés
    private String nomBase="fbta.sqlite";
    private Integer versionBase =1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    //Constructeur
    public AccesLocal(Context context){
        accesBD = new MySQLiteOpenHelper(context, nomBase,null,versionBase);
    }
    //Ajout d'un utilisateur dans la base de données
    public void ajout(Personne personne){
        bd = accesBD.getWritableDatabase();
        String req = "insert into user (sexe, prenom, age, taille, poids, act_sport, objectif) values (\""+personne.getSexe()+"\",\""+personne.getPrenom()+"\","+personne.getAge()+","+personne.getTaille()+","+personne.getPoids()+","+personne.getSport()+","+personne.getObjectif()+")";
        bd.execSQL(req);
    }
    //Récupération du dernier profil de la bd
    public Personne recupDernier(){
        bd = accesBD.getReadableDatabase();
        Personne personne = null;
        String req = "select * from user";
        Cursor curseur = bd.rawQuery(req,null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            String sexe = curseur.getString(0);
            String prenom = curseur.getString(1);
            Integer age = curseur.getInt(2);
            Float taille = curseur.getFloat(3);
            Integer poids = curseur.getInt(4);
            Integer act_sport = curseur.getInt(5);
            Integer objectif = curseur.getInt(6);
            personne = new Personne(sexe,prenom,age,taille,poids,act_sport,objectif);

        }
        curseur.close();
        return personne;
    }
}
