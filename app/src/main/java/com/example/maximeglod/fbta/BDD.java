package com.example.maximeglod.fbta;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BDD extends SQLiteOpenHelper {


    //INITIALISATION DE LA BASE DE DONNEES
    public static final String DATABASE_NAME = "fbta.db";
    public static final String TABLE_NAME = "personne_table";
    public static final String TABLE_NAME_COL_1 = "ID";
    public static final String TABLE_NAME_COL_2 = "PRENOM";
    public static final String TABLE_NAME_COL_3 = "NOM";
    public static final String TABLE_NAME_COL_4 = "AGE";
    public static final String TABLE_NAME_COL_5 = "SEXE";
    public static final String TABLE_NAME_COL_6 = "TAILLE";
    public static final String TABLE_NAME_COL_7 = "POIDS";
    public static final String TABLE_NAME_COL_8 = "ACTIVITE";
    public static final String TABLE_NAME_COL_9 = "OBJECTIF";


    public BDD(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    //CREATION DE LA BDD fbta
    @Override
    public void onCreate(SQLiteDatabase fbta) {
        fbta.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT , PRENOM TEXT, NOM TEXT, AGE INTEGER, SEXE TEXT, TAILLE TEXT,POIDS TEXT, ACTIVITE TEXT, OBJECTIF TEXT)");

    }

    // MISE A JOUR BDD
    // SI LA TABLE EST DEJA CREER, ON LA SUPPRIME
    @Override
    public void onUpgrade(SQLiteDatabase fbta, int oldVersion, int newVersion) {
        fbta.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(fbta);
    }
}


//AUTRE FACON DE FAIRE UNE INSERT DANS LA BDD
   /* public boolean insertData ( String prenom, String nom, String age, String sexe, String taille, String poids, String activite, String objectif) {
        SQLiteDatabase fbta = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TABLE_NAME_COL_2, prenom);
        contentValues.put(TABLE_NAME_COL_3, nom);
        contentValues.put(TABLE_NAME_COL_4, age);
        contentValues.put(TABLE_NAME_COL_5, sexe);
        contentValues.put(TABLE_NAME_COL_6, taille);
        contentValues.put(TABLE_NAME_COL_7, poids);
        contentValues.put(TABLE_NAME_COL_8, activite);
        contentValues.put(TABLE_NAME_COL_9, objectif);


        long result = fbta.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        }
        else{
            return true;
        }
    }
}

 DANS LE MAIN ACTIVITY
@Override

    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fbta = new BDD(this);
    }

*/