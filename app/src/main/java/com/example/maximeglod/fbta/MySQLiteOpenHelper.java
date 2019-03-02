package com.example.maximeglod.fbta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    //Propriétés
    private String creationtableuser = "create table user ("
            + "prenom TEXT,"
            + "age INTEGER,"
            + "taille REAL,"
            + "poids REAL,"
            + "act_sport TEXT,"
            + "objectif INTEGER);";
    //Création table évolution
    private String creationtableevolution = "create table evolution(date TEXT, poids INTEGER);";
    //Création table alimentation
    private String creationtablealimentation = "create table alimentation(date TEXT,position INTEGER,qtecalorie INTEGER);";
    //Création table datemap pour les cal
    private String creationtabledatemap = "create table datemap(date TEXT,position INTEGER,qte2 INTEGER)";

    //Constructeur
    public MySQLiteOpenHelper(@androidx.annotation.Nullable Context context, @androidx.annotation.Nullable String name, @androidx.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Si changement de BD
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Lancement des requètes de création de tables
        sqLiteDatabase.execSQL(creationtableuser);
        sqLiteDatabase.execSQL(creationtableevolution);
        sqLiteDatabase.execSQL(creationtablealimentation);
        sqLiteDatabase.execSQL(creationtabledatemap);

    }

    //Si changement de version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
