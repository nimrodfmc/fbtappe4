package com.example.maximeglod.fbta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tv_poids, tv_taille, tv_nom, tv_age, tv_sexe, tv_sport, tv_objectif, tv_prenom;
    EditText et_poids, et_taille, et_nom, et_age, et_sexe, et_sport, et_objectif, et_prenom;
    Button bt_valider;

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
        et_sexe = (EditText) findViewById(R.id.etSexe);
        et_sport = (EditText) findViewById(R.id.etActivite);

        bt_valider = (Button) findViewById(R.id.btnProfil);

        bt_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), tv_prenom+" "+tv_nom+" enregistré", Toast.LENGTH_LONG).show();
            }
        });
    }
}
