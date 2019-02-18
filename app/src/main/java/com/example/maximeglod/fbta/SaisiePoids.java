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

import java.util.HashMap;
import java.util.Map;

public class SaisiePoids extends AppCompatActivity {
    public static String recup_date;
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
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        recup_date = date;
        TextView date5 = (TextView) findViewById(R.id.currentdate);
        date5.setText(recup_date);

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
                   Integer poidscurrent = Integer.parseInt(poids.getText().toString());
                    poidsMap.put(recup_date,poidscurrent);
                    poidsMap.get(recup_date);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
    public static Map<String, Integer> poidsMap = new HashMap<>();
}
