package com.example.maximeglod.fbta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class validInscription extends AppCompatActivity {
    TextView tv_prenom, tv_nom, tv_naissance, tv_taille, tv_poids, tv_objectif, tv_sexe, tv_activite;
    Button btn_inscrire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        tv_prenom = (TextView) findViewById(R.id.tvPrenom);
        tv_nom = (TextView) findViewById(R.id.tvNom);
        tv_naissance = (TextView) findViewById(R.id.tvAge);
        tv_taille = (TextView) findViewById(R.id.tvTaille);
        tv_poids = (TextView) findViewById(R.id.tvPoids);
        tv_objectif = (TextView) findViewById(R.id.tvObjectif);
        tv_sexe = (TextView) findViewById(R.id.tvSexe);
        tv_activite = (TextView) findViewById(R.id.tvSport);
        btn_inscrire = (Button) findViewById(R.id.btn_inscrire);
        final String lePrenom = getIntent().getStringExtra("Prénom");
        final String leNom = getIntent().getStringExtra("Nom");
        String laNaissance = getIntent().getStringExtra("Naissance");
        String leSexe = getIntent().getStringExtra("Sexe");
        String laTaille = getIntent().getStringExtra("Taille");
        String lePoids = getIntent().getStringExtra("Poids");
        String lActivite = getIntent().getStringExtra("Activité sportive");
        String lObjectif = getIntent().getStringExtra("Objectif de poids");
        tv_prenom.setText("Prénom : " + lePrenom);
        tv_nom.setText("Nom : " + leNom);
        tv_naissance.setText("Date de naissance : " + laNaissance);
        tv_sexe.setText("Sexe : " + leSexe);
        tv_taille.setText("Taille : " + laTaille);
        tv_poids.setText("Poids : " + lePoids);
        tv_activite.setText("Activité Sportive : " + lActivite);
        tv_objectif.setText("Objectif : " + lObjectif);

        btn_inscrire.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent e = new Intent(getApplicationContext(), MainActivity.class);

                Toast.makeText(getApplicationContext(), lePrenom + " " + leNom + " enregistré", Toast.LENGTH_LONG).show();

                startActivity(e);
            }

        });
    }
}