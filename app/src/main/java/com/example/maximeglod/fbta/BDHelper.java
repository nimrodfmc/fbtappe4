package com.example.maximeglod.fbta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;
import java.util.Map;

//Fichier de gestion de la BDD
public class BDHelper extends SQLiteOpenHelper {
    private SQLiteDatabase maBase;
    private BDD maBDD;

    //constructeur qui initialise la base
    public BDHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // on obtient l’accès en écriture, ce qui permet de lire et modifier les données
    public void open() {
        maBase = maBDD.getWritableDatabase();
    }

    //pour libérer la connection
    public void close() {
        maBase.close();
    }

    //Si changement de bdd
    @Override
    public void onCreate(SQLiteDatabase db) {
        //requête
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //ajout de la liste (HashMap) dans la BDD
    public boolean insert(String table, HashMap<String, String> map) {
        ContentValues contentValues = new ContentValues();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            contentValues.put(entry.getKey(), entry.getValue());
        }

        long result = maBase.insert(table, null, contentValues);
        return result != -1;
    }

    public boolean update(String Id, String table, HashMap<String, String> map) {
        ContentValues contentValues = new ContentValues();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            contentValues.put(entry.getKey(), entry.getValue());
        }

        long result = maBase.update(table, contentValues, "id=" + Id, null);
        return result != -1;
    }

    public Cursor select(String table) {
        Cursor res = maBase.rawQuery("select * from " + table, null);
        return res;
    }
}