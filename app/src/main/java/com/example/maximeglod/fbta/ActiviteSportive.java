package com.example.maximeglod.fbta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActiviteSportive extends AppCompatActivity {
    RadioButton r_nulle, r_modere, r_forte;
    RadioGroup r_grp;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_sportive);

        r_nulle = (RadioButton) findViewById(R.id.radioButton);
        r_modere = (RadioButton) findViewById(R.id.radioButton2);
        r_forte = (RadioButton) findViewById(R.id.radioButton3);
        r_grp = (RadioGroup) findViewById(R.id.radioGroup);
        btn = (Button) findViewById(R.id.save);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                Toast.makeText(getApplicationContext(), "L'activité choisie a bien été sauvegardée", Toast.LENGTH_LONG).show();
                startActivityForResult(myIntent, 0);
            }
        });
    }
}

