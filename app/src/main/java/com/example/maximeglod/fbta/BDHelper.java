package com.example.maximeglod.fbta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDHelper extends SQLiteOpenHelper {

    public BDHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        // contexte : contexte de l'activité transmis au parent
        // name : nom de la bdd, il permet la création d'un dossier sur le système android
        // factory : un outil pour traiter les requêtes
        // version : permet les mises à jour de la base de données
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String req = "Create table personnage (nom text, topo text)";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

