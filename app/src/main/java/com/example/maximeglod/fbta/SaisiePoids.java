package com.example.maximeglod.fbta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SaisiePoids extends AppCompatActivity {
    TextView saisie;
    EditText poids;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_poids);

        saisie = (TextView) findViewById(R.id.tvSaisie);
        poids = (EditText) findViewById(R.id.etSaisie);
        save = (Button) findViewById(R.id.btSaisie);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (poids.getText().toString().length() < 1) {
                    Toast.makeText(getApplicationContext(), "Veuillez renseigner votre poids", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                    Toast.makeText(getApplicationContext(), "La saisie de votre poids a bien été sauvegardée", Toast.LENGTH_LONG).show();
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}
