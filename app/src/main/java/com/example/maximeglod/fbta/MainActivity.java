package com.example.maximeglod.fbta;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static com.example.maximeglod.fbta.CustomGridAdapter.calMap;

public class MainActivity extends Activity {
    public static HashMap<String, Object> personne = new HashMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        //Définission le contenu de la vue APRES les instructions précédentes pour éviter un crash

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instance de Handler pour lancer une fonction à intervalle de temps régulier
        myHandler = new Handler();
        myHandler.postDelayed(myRunnable, 5);
        TextView dateView = (TextView)findViewById(R.id.currentdate);
        Calendar cal = Calendar.getInstance();
        final String heures = (cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.DAY_OF_WEEK)+"/"+cal.get(Calendar.YEAR));
        dateView.setText(heures);

        CalendarView view = findViewById(R.id.calendarView);


        view.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView arg0, int year, int month,
                                            int date) {
                TextView dateView = (TextView)findViewById(R.id.currentdate);
                String heures2 = (date+"/"+(month+1)+"/"+year);
                dateView.setText(heures2);

            }
        });





        myHandler = new Handler();
        myHandler.postDelayed(myRunnable,5);

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
                TextView dateView2 = (TextView)findViewById(R.id.currentdate);
                final String heures3 = dateView2.getText().toString();
                Intent myIntent = new Intent(getBaseContext(), MainAliments.class);
                myIntent.putExtra("date", heures3);

                startActivityForResult(myIntent, 0);
            }


        });
        //les deux autres bouttons reste à faire


    }
    private Handler myHandler;
    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            // Code à éxécuter de façon périodique




            int sum = 0;
            //Parcours du Hashmap pour sommer toutes les valeurs caloriques et ainsi récupérer le totalcalorique
            //dans la variable sum
            for (int f : calMap.values()) {
                sum += f;
            }

            //On récupère le champ totalcalories de la vue
            TextView totalcalories = (TextView) findViewById(R.id.totalcalories);
            String sumtotal = Integer.toString(sum);
            //On met à jour le text de totalcalories avec la valeur calculée
            totalcalories.setText(sumtotal);

            //Changement de la couleur d'un élément si l'objectif n'est pas respecté
            TextView objectifcalories = (TextView) findViewById(R.id.objectif);
            int objectif = Integer.parseInt(objectifcalories.getText().toString());

            if (sum <= objectif) {
                Button b1 = (Button) findViewById(R.id.verif);
                b1.setBackgroundResource(R.drawable.rounded_button_ok);
                b1.setText("V");
                b1.setTextColor(Color.BLACK);
            } else {

                //On tolère une marge de 5% par rapport à l'objectif (Changement de couleur)
                if (sum <= objectif + (objectif * 0.05)) {
                    Button b2 = (Button) findViewById(R.id.verif);
                    b2.setBackgroundResource(R.drawable.rounded_button_mid);
                    b2.setText("~");
                    b2.setTextColor(Color.WHITE);
                } else {
                    Button b1 = (Button) findViewById(R.id.verif);
                    b1.setBackgroundResource(R.drawable.rounded_button_false);
                    b1.setText("X");
                    b1.setTextColor(Color.WHITE);
                }

            }




            myHandler.postDelayed(this, 5);

        }
    };



}