package com.example.maximeglod.fbta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Inscription extends AppCompatActivity {


    TextView tv_poids, tv_taille, tv_nom, tv_age, tv_sexe, tv_sport, tv_objectif, tv_prenom;
    EditText et_poids, et_taille, et_nom, et_age, et_objectif, et_prenom, et_sexe;
    Button bt_valider;
    Spinner spinner;

    private String poids, taille, nom, naissance, sexe, sport, objectif, prenom;

    public Inscription() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Définission le contenu de la vue APRES les instructions précédentes pour éviter un crash

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        final String date2 = date.toString();
        Toast.makeText(getApplicationContext(),"La date : "+date2,Toast.LENGTH_LONG).show();

        tv_age = (TextView) findViewById(R.id.tvAge);
        tv_nom = (TextView) findViewById(R.id.tvNom);
        tv_objectif = (TextView) findViewById(R.id.tvObjectif);
        tv_poids = (TextView) findViewById(R.id.tvPoids);
        tv_prenom = (TextView) findViewById(R.id.tvPrenom);
        tv_taille = (TextView) findViewById(R.id.tvTaille);
        tv_sexe = (TextView) findViewById(R.id.tvSexe);
        tv_sport = (TextView) findViewById(R.id.tvSport);


        et_prenom = (EditText) findViewById(R.id.etPrenom);
        this.prenom = et_prenom.getText().toString();

        et_nom = (EditText) findViewById(R.id.etNom);
        this.nom = et_nom.getText().toString();

        et_age = (EditText) findViewById(R.id.etAge);
        this.naissance = et_age.getText().toString();

        et_sexe = (EditText) findViewById(R.id.etSexe);
        this.sexe = et_sexe.getText().toString();

        et_taille = (EditText) findViewById(R.id.etTaille);
        this.taille = et_taille.getText().toString();

        et_poids = (EditText) findViewById(R.id.etPoids);
        this.poids = et_poids.getText().toString();

        spinner = (Spinner) findViewById(R.id.spinner);
        List liste = new ArrayList();
        liste.add("Détente");
        liste.add("Modéré");
        liste.add("Intense");
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,liste);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        this.objectif = spinner.getSelectedItem().toString();
        et_objectif = (EditText) findViewById(R.id.etObjectif);
        this.objectif = et_objectif.getText().toString();

        bt_valider = (Button) findViewById(R.id.btnProfil);

        bt_valider.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), validInscription.class);


                if (et_prenom.getText().toString().length() < 1) {
                    Toast.makeText(getApplicationContext(),"Veuillez renseigner votre prénom", Toast.LENGTH_LONG).show();
                }
                else {
                    if (et_nom.getText().toString().length() < 1) {
                        Toast.makeText(getApplicationContext(),"Veuillez renseigner votre nom", Toast.LENGTH_LONG).show();
                    }
                    else {
                        if (et_age.getText().toString().length() < 1) {
                            Toast.makeText(getApplicationContext(),"Veuillez renseigner votre date de naissance", Toast.LENGTH_LONG).show();
                        }
                        else if (et_age.getText().toString().length() < 10) {
                            Toast.makeText(getApplicationContext(), "Veuillez renseigner correctement votre date de naissance", Toast.LENGTH_LONG).show();
                        }
                        else {
                            if (et_sexe.getText().toString().length() < 1) {
                                Toast.makeText(getApplicationContext(),"Veuillez renseigner votre sexe", Toast.LENGTH_LONG).show();
                            }
                            else if (et_sexe.getText().toString().equals("M") || et_sexe.getText().toString().equals("F")) {
                                if (et_taille.getText().toString().length() < 1) {
                                    Toast.makeText(getApplicationContext(),"Veuillez renseigner votre taille", Toast.LENGTH_LONG).show();
                                }
                                else if (et_taille.getText().toString().length() == 3) {
                                    Toast.makeText(getApplicationContext(),"Veuillez renseigner votre taille en m", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    if (et_poids.getText().toString().length() < 1) {
                                        Toast.makeText(getApplicationContext(),"Veuillez renseigner votre poids", Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        if (et_objectif.getText().toString().length() < 1) {
                                            Toast.makeText(getApplicationContext(),"Veuillez renseigner votre objectif de poids", Toast.LENGTH_LONG).show();
                                        }
                                        else {
                                            i.putExtra("Prénom", et_prenom.getText().toString());
                                            i.putExtra("Nom", et_nom.getText().toString());
                                            i.putExtra("Naissance", et_age.getText().toString());
                                            i.putExtra("Sexe", et_sexe.getText().toString());
                                            i.putExtra("Taille", et_taille.getText().toString());
                                            i.putExtra("Poids", et_poids.getText().toString());
                                            i.putExtra("Activité sportive", spinner.getSelectedItem().toString());
                                            i.putExtra("Objectif de poids", et_objectif.getText().toString());
                                            i.putExtra("date",date2);
                                            startActivity(i);
                                        }
                                    }
                                }
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Veuillez renseigner correctement votre sexe", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
            }

        });


    }



    public String getPoids() {
        return this.poids;
    }

    public String getTaille() {
        return this.taille;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getNaiss() {
        return this.naissance;
    }

    public String getSexe() {
        return this.sexe;
    }

    public String getSport() {
        return this.sport;
    }

    public String getObjectif() {return this.objectif;}

    //private int currentdate;
    //double age = (Integer.parseInt(getNaiss()) - currentdate);
    //double cal1 = (13.707 * (Integer.parseInt(getPoids())) + 492.3 * +(Integer.parseInt(getTaille())) - 6.673 * age+77.607);

}