package com.example.maximeglod.fbta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Inscription extends AppCompatActivity {


    TextView tv_poids, tv_taille, tv_nom, tv_age, tv_sexe, tv_sport, tv_objectif, tv_prenom;
    EditText et_poids, et_taille, et_nom, et_age, et_objectif, et_prenom;
    String et_sexe;
    Button bt_valider;
    Spinner spinner;
    RadioButton r_homme, r_femme;
    RadioGroup r_grp2;
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

        tv_age = (TextView) findViewById(R.id.tvAge);
        tv_nom = (TextView) findViewById(R.id.tvNom);
        tv_objectif = (TextView) findViewById(R.id.tvObjectif);
        tv_poids = (TextView) findViewById(R.id.tvPoids);
        tv_prenom = (TextView) findViewById(R.id.tvPrenom);
        tv_taille = (TextView) findViewById(R.id.tvTaille);
        tv_sexe = (TextView) findViewById(R.id.tvSexe);
        tv_sport = (TextView) findViewById(R.id.tvSport);
        r_homme = (RadioButton) findViewById(R.id.radio2);
        r_femme = (RadioButton) findViewById(R.id.radio1);

        et_prenom = (EditText) findViewById(R.id.etPrenom);
        et_prenom.requestFocus();
        this.prenom = et_prenom.getText().toString();

        et_nom = (EditText) findViewById(R.id.etNom);
        this.nom = et_nom.getText().toString();

        et_age = (EditText) findViewById(R.id.etAge);
        this.naissance = et_age.getText().toString();



//        et_sexe = (EditText) findViewById(R.id.etSexe);
//        this.sexe = et_sexe.getText().toString();

        //Checkbox case1 = (Checkbox) findViewById (R.id.radio1);

//        switch (view.getId()){
//            case R.id.radio1:
//                if (checked)
//                    break;
//            case R.id.radio2:
//                if (checked)
//                    break;
//            case R.id.radio3:
//                if (checked)
//                    break;
//        }

        et_taille = (EditText) findViewById(R.id.etTaille);
        this.taille = et_taille.getText().toString();

        et_poids = (EditText) findViewById(R.id.etPoids);
        this.poids = et_poids.getText().toString();

        spinner = (Spinner) findViewById(R.id.spinner);
        List liste = new ArrayList<String>();
        liste.add("Détente");
        liste.add("Modéré");
        liste.add("Intense");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, liste);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        this.sport = spinner.getSelectedItem().toString();


        bt_valider = (Button) findViewById(R.id.btnProfil);
        //Listener btn radio homme
        r_homme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_femme.setChecked(false);

            }
        });
        //Listner btn radio femme
        r_femme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r_homme.setChecked(false);

            }
        });

        bt_valider.setOnClickListener(new View.OnClickListener() {

            private String sexe;

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), validInscription.class);

                if (et_prenom.getText().toString().length() < 1) {
                    Toast.makeText(getApplicationContext(), "Veuillez renseigner votre prénom", Toast.LENGTH_LONG).show();
                } else {
                    if (et_nom.getText().toString().length() < 1) {
                        Toast.makeText(getApplicationContext(), "Veuillez renseigner votre nom", Toast.LENGTH_LONG).show();
                    } else {
                        if (et_age.getText().toString().length() < 1) {
                            Toast.makeText(getApplicationContext(), "Veuillez renseigner votre date de age", Toast.LENGTH_LONG).show();
                        } else if (et_age.getText().toString().length() < 1) {
                            Toast.makeText(getApplicationContext(), "Veuillez renseigner correctement votre age", Toast.LENGTH_LONG).show();
                        } else {
                            if (et_taille.getText().toString().length() < 1) {
                                Toast.makeText(getApplicationContext(), "Veuillez renseigner votre taille", Toast.LENGTH_LONG).show();
                            } else if (et_taille.getText().toString().length() == 3) {
                                Toast.makeText(getApplicationContext(), "Veuillez renseigner votre taille en m", Toast.LENGTH_LONG).show();
                            } else {
                                if (et_poids.getText().toString().length() < 1) {
                                    Toast.makeText(getApplicationContext(), "Veuillez renseigner votre poids", Toast.LENGTH_LONG).show();
                                } else {

                                    if (r_homme.isChecked()) {

                                        et_sexe = (String) "H";
                                        this.sexe = et_sexe;


                                    } else if (r_femme.isChecked()) {
//            String sexebtn = "F";
                                        et_sexe = (String) "F";
                                        this.sexe = et_sexe;
                                    }

                                    i.putExtra("Prénom", et_prenom.getText().toString());
                                    i.putExtra("Nom", et_nom.getText().toString());
                                    i.putExtra("Naissance", et_age.getText().toString());
                                    i.putExtra("Sexe", et_sexe);
                                    i.putExtra("Taille", et_taille.getText().toString());
                                    i.putExtra("Poids", et_poids.getText().toString());
                                    i.putExtra("Activité sportive", spinner.getSelectedItem().toString());
                                    startActivity(i);
                                }
                            }

                        }
                    }
                }
            }

        });


    }

//    public void buttonclicked(View view) {
//        boolean checked = ((RadioButton) view).isChecked();
//        switch (view.getId()) {
//            case R.id.radio1:
//                if (checked)
//                    r_homme.setChecked(false);
//                r_femme.toggle();
//                break;
//            case R.id.radio2:
//                if (checked)
//                    r_femme.setChecked(false);
//                r_homme.toggle();
//                break;
//
//        }
//    }

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

    public String getObjectif() {
        return this.objectif;
    }
}