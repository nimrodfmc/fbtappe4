package com.example.maximeglod.fbta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView tv_poids, tv_taille, tv_nom, tv_age, tv_sexe, tv_sport, tv_objectif, tv_prenom;
    EditText et_poids, et_taille, et_nom, et_age, et_objectif, et_prenom;
    Button bt_valider;
    RadioGroup rd_groupe;
    RadioButton rbt_homme, rbt_femme;
    Spinner spinner;
    String[] sexe={"Homme","Femme"};
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_age = (TextView) findViewById(R.id.tvAge);
        tv_nom = (TextView) findViewById(R.id.tvNom);
        tv_objectif = (TextView) findViewById(R.id.tvObjectif);
        tv_poids = (TextView) findViewById(R.id.tvPoids);
        tv_prenom = (TextView) findViewById(R.id.tvPrenom);
        tv_taille = (TextView) findViewById(R.id.tvTaille);
        tv_sexe = (TextView) findViewById(R.id.tvSexe);
        tv_sport = (TextView) findViewById(R.id.tvSport);

        et_age = (EditText) findViewById(R.id.etAge);
        et_nom = (EditText) findViewById(R.id.etNom);
        et_objectif = (EditText) findViewById(R.id.etObjectif);
        et_poids = (EditText) findViewById(R.id.etPoids);
        et_prenom = (EditText) findViewById(R.id.etPrenom);
        et_taille = (EditText) findViewById(R.id.etTaille);

        rd_groupe = (RadioGroup) findViewById(R.id.rdGrp);
        rbt_homme = (RadioButton) findViewById(R.id.rbtnHomme);
        if (rbt_homme.isChecked()) {
            s = sexe[0];
        }
        else {
            s = sexe[1];
        }
        rbt_femme = (RadioButton) findViewById(R.id.rbtnFemme);

        spinner = (Spinner) findViewById(R.id.spinner);
        List liste = new ArrayList();
        liste.add("Détente");
        liste.add("Modéré");
        liste.add("Intense");
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,liste);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        bt_valider = (Button) findViewById(R.id.btnProfil);

        bt_valider.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Inscription.class);
                i.putExtra("Prénom", et_prenom.getText().toString());
                i.putExtra("Nom", et_nom.getText().toString());
                i.putExtra("Naissance", et_age.getText().toString());
                i.putExtra("Sexe", s);
                i.putExtra("Taille", et_taille.getText().toString());
                i.putExtra("Poids", et_poids.getText().toString());
                i.putExtra("Activité sportive", spinner.getSelectedItem().toString());
                i.putExtra("Objectif de poids", et_objectif.getText().toString());
                startActivity(i);
            }
        });
    }
}