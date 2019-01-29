package com.example.maximeglod.fbta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Inscription extends AppCompatActivity {
    TextView tv_prenom, tv_nom, tv_naissance, tv_taille, tv_poids, tv_objectif;
    Button btn_inscrire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        tv_prenom = (TextView) findViewById(R.id.tvPrenom);
        tv_nom = (TextView) findViewById(R.id.tvNom);
        tv_naissance = (TextView) findViewById(R.id.tvAge);
        tv_taille = (TextView) findViewById(R.id.tvTaille);
        tv_poids = (TextView) findViewById(R.id.tvPoids);
        tv_objectif = (TextView) findViewById(R.id.tvObjectif);
        btn_inscrire = (Button) findViewById(R.id.btn_inscrire);
        String lePrenom = getIntent().getStringExtra("Prénom");
        String leNom = getIntent().getStringExtra("Nom");
        String laNaissance = getIntent().getStringExtra("Naissance");
        String laTaille = getIntent().getStringExtra("Taille");
        String lePoids = getIntent().getStringExtra("Poids");
        String lObjectif = getIntent().getStringExtra("Objectif de poids");
        tv_prenom.setText("Prénom : " + lePrenom);
        tv_nom.setText("Nom : " + leNom);
        tv_naissance.setText("Date de naissance : " + laNaissance);
        tv_taille.setText("Taille : " + laTaille);
        tv_poids.setText("Poids : " + lePoids);
        tv_objectif.setText("Objectif : " + lObjectif);
    }
}
