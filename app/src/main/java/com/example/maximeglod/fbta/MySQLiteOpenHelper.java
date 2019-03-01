package com.example.maximeglod.fbta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    //Propriétés
    private String creationtableuser="create table user ("
            +"sexe TEXT,"
            +"prenom TEXT,"
            +"age INTEGER,"
            +"taille REAL,"
            +"poids REAL,"
            +"act_sport INTEGER,"
            +"objectif INTEGER);";
    private String creationtableevolution="create table evolution(date TEXT, poids INTEGER);";




    //Constructeur
    public MySQLiteOpenHelper(@androidx.annotation.Nullable Context context, @androidx.annotation.Nullable String name, @androidx.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Si changement de BD
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(creationtableuser);
        sqLiteDatabase.execSQL(creationtableevolution);


    }

    //Si changement de version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
