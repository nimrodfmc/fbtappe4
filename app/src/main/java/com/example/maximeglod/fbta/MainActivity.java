package com.example.maximeglod.fbta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;

public class MainActivity extends Activity {

    public static HashMap<String,Object> personne = new HashMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Définission le contenu de la vue APRES les instructions précédentes pour éviter un crash

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //On instancie des bouttons de menu sur la vue activity_main
        // avec des intent pour lancer les activités correspondante
        Button inscription = (Button) findViewById(R.id.Button01);
        inscription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), Inscription.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button alimentation = (Button) findViewById(R.id.Button02);
        alimentation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(getBaseContext(), MainAliments.class);
                startActivityForResult(myIntent, 0);
            }

        });
        //les deux autres bouttons reste à faire

        TextView dateView = (TextView)findViewById(R.id.currentdate);
        setDate(dateView);
    }
    public void setDate (TextView view){
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
        String date = formatter.format(today);
        view.setText(date);
    }

}