package com.example.maximeglod.fbta;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DAO {
    private SQLiteDatabase maBase;
    private BDHelper monBDHelper;

    public DAO(Context context) {
        monBDHelper = new BDHelper(context, "fbta", null, 1);
    }

    public void open() {
        maBase = monBDHelper.getWritableDatabase();
    }

    public void close() {
        maBase.close();
    }

    public long ajoutePersonne(Inscription inscription) {
        ContentValues v = new ContentValues();
        v.put("prenom", inscription.getPrenom());
        v.put("nom", inscription.getNom());
        v.put("age", inscription.getNaiss());
        v.put("sexe", inscription.getSexe());
        v.put("taille", inscription.getTaille());
        v.put("poids", inscription.getPoids());
        v.put("activité", inscription.getSport());
        v.put("objectif", inscription.getObjectif());
        return  maBase.insert("personne", null, v);
    }

}