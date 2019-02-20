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

import java.util.HashMap;

import static com.example.maximeglod.fbta.BDD.TABLE_NAME;

public class validInscription extends AppCompatActivity {
    TextView tv_prenom, tv_nom, tv_naissance, tv_taille, tv_poids, tv_objectif, tv_sexe, tv_activite;
    Button btn_inscrire;

    // NOM DE LA BDD
    BDD fbta;

    private String lePrenom;
    private String leNom;
    private String laNaissance;
    private String leSexe;
    private String laTaille;
    private String lePoids;
    private String lActivite;
    private String lObjectif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Définission le contenu de la vue APRES les instructions précédentes pour éviter un crash
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valid_inscription);

        //BDD
        fbta = new BDD(this);

        tv_prenom = (TextView) findViewById(R.id.tvPrenom);
        tv_nom = (TextView) findViewById(R.id.tvNom);
        tv_naissance = (TextView) findViewById(R.id.tvAge);
        tv_taille = (TextView) findViewById(R.id.tvTaille);
        tv_poids = (TextView) findViewById(R.id.tvPoids);
        tv_objectif = (TextView) findViewById(R.id.tvObjectif);
        tv_sexe = (TextView) findViewById(R.id.tvSexe);
        tv_activite = (TextView) findViewById(R.id.tvSport);
        btn_inscrire = (Button) findViewById(R.id.btn_inscrire);
        lePrenom = getIntent().getStringExtra("Prénom");
        leNom = getIntent().getStringExtra("Nom");
        laNaissance = getIntent().getStringExtra("Naissance");
        leSexe = getIntent().getStringExtra("Sexe");
        laTaille = getIntent().getStringExtra("Taille");
        lePoids = getIntent().getStringExtra("Poids");
        lActivite = getIntent().getStringExtra("Activité sportive");
        lObjectif = getIntent().getStringExtra("Objectif de poids");
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

        //AJOUT DES DONNEES
        AddData();

    }

    // AJOUT DES DONNEES DANS LA BASE DE DONNEES SUR LE CLIC DU BOUTON DE VALIDINSCRIPTION
    public void AddData() {
        btn_inscrire.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                BDHelper bdHelper = new BDHelper(getBaseContext(), "fbta", null, 1);

                //LISTE DES PARAMETRES A AJOUTER A LA BDD
                HashMap<String, String> params = new HashMap<>();
                params.put(BDD.TABLE_NAME_COL_2, lePrenom);
                params.put(BDD.TABLE_NAME_COL_3, leNom);
                params.put(BDD.TABLE_NAME_COL_4, laNaissance);
                params.put(BDD.TABLE_NAME_COL_5, leSexe);
                params.put(BDD.TABLE_NAME_COL_6, laTaille);
                params.put(BDD.TABLE_NAME_COL_7, lePoids);
                params.put(BDD.TABLE_NAME_COL_8, lActivite);
                params.put(BDD.TABLE_NAME_COL_9, lObjectif);

                //OUVERTURE DE LA BDD
                bdHelper.open();
                boolean retour = bdHelper.insert(TABLE_NAME, params);

                //AFFICHAGE RAPIDE
                //LES DONNEES NE SONT PAS MISE DANS LA BDD
                if (!retour) {
                    Toast.makeText(validInscription.this, "SA MARCHE PAS", Toast.LENGTH_LONG).show();
                }
                bdHelper.close();
            }
        });
    }
}