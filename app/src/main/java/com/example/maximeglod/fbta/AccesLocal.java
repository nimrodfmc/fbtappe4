package com.example.maximeglod.fbta;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.github.mikephil.charting.components.XAxis;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class AccesLocal {

    //propriétés
    private String nomBase = "fbta.sqlite";
    private Integer versionBase = 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    //Constructeur
    public AccesLocal(Context context) {
        accesBD = new MySQLiteOpenHelper(context, nomBase, null, versionBase);
    }

    //Ajout d'un utilisateur dans la base de données
    public void ajout(Personne personne) {
        bd = accesBD.getWritableDatabase();
        String req = "insert into user (sexe, prenom, age, taille, poids, act_sport, objectif) values (\"" + personne.getSexe() + "\",\"" + personne.getPrenom() + "\"," + personne.getAge() + "," + personne.getTaille() + "," + personne.getPoids() + "," + personne.getSport() + "," + personne.getObjectif() + ")";
        bd.execSQL(req);
    }

    //Ajout d'une évolution dans la table évolution
    public void ajoutevolution(String date, Integer poids) {
        bd = accesBD.getWritableDatabase();
        String req = "insert into evolution (date,poids) values(\"" + date + "\"," + poids + ");";
        bd.execSQL(req);
    }

    //Récupération du poids en fonction de la date
    public String checkevolution(String date) {
        bd = accesBD.getReadableDatabase();
        String req = "select * from evolution where evolution.date=\"" + date + "\"";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if (curseur.isAfterLast()) {
            curseur.close();
            return "pasok";
        } else {
            curseur.close();
            return "ok";
        }

    }

    public String checkalimentation(String date, Integer position) {
        bd = accesBD.getReadableDatabase();
        String req = "select * from alimentation where alimentation.date=\"" + date + "\" AND alimentation.position=" + position + "";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if (curseur.isAfterLast()) {
            curseur.close();
            return "pasok";
        } else {
            curseur.close();
            return "ok";
        }
    }

    public String checkalimentation2(String date, Integer position) {
        bd = accesBD.getReadableDatabase();
        String req = "select * from datemap where datemap.date=\"" + date + "\" AND datemap.position=" + position + "";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if (curseur.isAfterLast()) {
            curseur.close();
            return "pasok";
        } else {
            curseur.close();
            return "ok";
        }
    }

    public String checkalimentation3(String date) {
        bd = accesBD.getReadableDatabase();
        String req = "select * from datemap where datemap.date=\"" + date + "\"";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if (curseur.isAfterLast()) {
            curseur.close();
            return "pasok";
        } else {
            curseur.close();
            return "ok";
        }
    }


    //Ajout d'une ligne dans alimentation avec date position et qtecalorie
    public void ajoutalimentation(String date, Integer position, Integer qtecalorie) {
        bd = accesBD.getWritableDatabase();
        String req = "insert into alimentation (date,position,qtecalorie) values(\"" + date + "\"," + position + "," + qtecalorie + ");";
        bd.execSQL(req);
    }

    //Ajout d'une ligne dans alimentation avec date position et qtecalorie
    public void ajoutalimentation2(String date, Integer position, Integer qte2) {
        bd = accesBD.getWritableDatabase();
        String req = "insert into datemap (date,position,qte2) values(\"" + date + "\"," + position + "," + qte2 + ");";
        bd.execSQL(req);
    }

    //Modification d'une ligne dans alimentation avec date position et qtecalorie
    public void modifalimentation(String date, Integer position, Integer qtecalorie) {
        bd = accesBD.getReadableDatabase();
        String req = "UPDATE alimentation set position=" + position + ", qtecalorie=" + qtecalorie + " Where date=\"" + date + "\" AND position=" + position + ";";
        bd.execSQL(req);
    }

    //Modification d'une ligne dans alimentation avec date position et qtecalorie
    public void modifalimentation2(String date, Integer position, Integer qte2) {
        bd = accesBD.getReadableDatabase();
        String req = "UPDATE datemap set position=" + position + ", qte2=" + qte2 + " Where date=\"" + date + "\" AND position=" + position + ";";
        bd.execSQL(req);
    }

    //Création d'une méthode qui renvoie la qtecalories en focntion de la date et de la position
    public Integer returnqtecal(String date, Integer position) {
        bd = accesBD.getReadableDatabase();
        String req = "select qtecalorie from alimentation where alimentation.date=\"" + date + "\" AND alimentation.position=" + position + "";
        Cursor curseur = bd.rawQuery(req, null);
        Integer qte = curseur.getInt(0);
        curseur.close();
        return qte;

    }

    //Création d'une méthode qui renvoie la qtecalories en focntion de la date et de la position
    public Integer returnempty(String date) {
        bd = accesBD.getReadableDatabase();
        String req = "select qtecalorie from alimentation where date=\"" + date + "\"";
        Cursor curseur = bd.rawQuery(req, null);
        Integer qte = curseur.getInt(0);
        curseur.close();
        return qte;

    }

    //renvoi la quantité de l'aliment
    public Integer qtealiment(String date, Integer position) {
        bd = accesBD.getReadableDatabase();
        String req = "select qte2 from datemap where date=\"" + date + "\" AND position=" + position + "";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToFirst();

        if (curseur != null && curseur.moveToFirst()) {
            Integer qte = curseur.getInt(0);
            curseur.close();
            return qte;
        }
        curseur.close();
        return 0;
    }

    //si poids déjà rentrer alors faire une mise à jour
    public void modifevolution(String date, Integer poids) {
        bd = accesBD.getWritableDatabase();
        String req = "UPDATE evolution set poids=" + poids + " Where date=\"" + date + "\";";
        bd.execSQL(req);
    }

    //Récupération de l'ensemble des évolutions
    public Map selectevolution() {
        bd = accesBD.getReadableDatabase();
        String req = "Select * from evolution";
        Cursor curseur = bd.rawQuery(req, null);
        Map<String, Integer> poidsMap = new HashMap<>();

        while (curseur.moveToNext()) {
            String date = curseur.getString(0);
            Integer poids = curseur.getInt(1);
            poidsMap.put(date, poids);

        }
        curseur.close();

        return poidsMap;
    }

    //Création d'une requète qui renvoi la somme des calories journalière
    public int sumcal(String date) {
        bd = accesBD.getReadableDatabase();
        String req = "select sum(qtecalorie) from alimentation where alimentation.date=\"" + date + "\";";
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToFirst();

        if (curseur != null && curseur.moveToFirst()) {
            Integer qte = curseur.getInt(0);
            curseur.close();
            return qte;

        }
        curseur.close();
        return 0;


    }

  //Insertion d'un utilisateur dans la bdd
  public void ajoututilisateur(String sexe, String prenom, Integer age, Double taille,Double poids,String act_sport,Integer objectif) {
      bd = accesBD.getWritableDatabase();
      String req = "insert into user (sexe,prenom,age,taille,poids,act_sport,objectif) values(\""+sexe+"\",\"" + prenom + "\"," + age + "," + taille + ","+poids+",\""+act_sport+"\","+objectif+");";
      bd.execSQL(req);
  }
  //Récupération de l'objectif calorique de l'utilisateur
  public int totalcal() {
      bd = accesBD.getReadableDatabase();
      String req = "select objectif from user;";
      Cursor curseur = bd.rawQuery(req, null);
      curseur.moveToFirst();

      if (curseur != null && curseur.moveToFirst()) {
          Integer obj = curseur.getInt(0);
          curseur.close();
          return obj;

      }
      curseur.close();
      return 0;


  }
  //Récupération de l'activité sportive de l'utilisateur
    public String recupactsport(){
        bd = accesBD.getReadableDatabase();
        String req = "select act_sport from user;";
        Cursor curseur = bd.rawQuery(req,null);
        curseur.moveToFirst();
        if(curseur!= null && curseur.moveToFirst()){
            String act = curseur.getString(0);
            curseur.close();
            return act;
        }
        curseur.close();
        //Par défaut renvoi dédente
        return "Détente";
    }

    //Mise à jour de l'activité sportive de l'utilisateur
    public void majactsport(String act_sport,Integer objectif){
        bd = accesBD.getWritableDatabase();
        String req = "UPDATE user set act_sport=\"" + act_sport + "\", objectif="+objectif+";";
        bd.execSQL(req);
    }
}
