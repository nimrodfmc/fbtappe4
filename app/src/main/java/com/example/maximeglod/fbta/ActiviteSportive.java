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
    private static AccesLocal accesLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_sportive);
        accesLocal = new AccesLocal(getApplicationContext());

        r_nulle = (RadioButton) findViewById(R.id.btnNulle);
        r_modere = (RadioButton) findViewById(R.id.btnModere);
        r_forte = (RadioButton) findViewById(R.id.btnForte);
        r_grp = (RadioGroup) findViewById(R.id.radioGroup);
        btn = (Button) findViewById(R.id.save);
        Double lObjectif =0.0;
        //On récupère l'activité sportive de l'utilisateur pour cocher le btn radio correspondant
        if (accesLocal.recupactsport().equals("Intense")) {
            r_forte.setChecked(true);
            r_forte.toggle();
            Double objectif=(accesLocal.totalcal())/1.82;
            lObjectif=objectif;
        } else if (accesLocal.recupactsport().equals("Modéré")) {
            r_modere.setChecked(true);
            r_modere.toggle();
            Double objectif=(accesLocal.totalcal())/1.64;
            lObjectif=objectif;
        } else {
            //L'activité est "détente"
            r_nulle.setChecked(true);
            r_nulle.toggle();
            Double objectif=(accesLocal.totalcal())/1.375;
            lObjectif=objectif;
        }


         final Double lObjectif2 = lObjectif;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), MainActivity.class);

                //ATTENTION UTILISATION DE VALEUR ARRONDI DONC DECALLAGE POSSIBLE DE QUELQUES CALORIES (Negligeable cependant)
                //Mise à jour de l'activité sportive dans la base de données
                if (r_forte.isChecked()) {
                    //Si l'activité forte est cochée
                    Double objmod = lObjectif2;
                    int objmod2=(int) (objmod*1.82);

                    accesLocal.majactsport("Intense",objmod2);


                } else if (r_modere.isChecked()) {
                    //Si l'activité modéré est cochée
                    Double objmod = lObjectif2;
                    int objmod2=(int) (objmod*1.64);

                    accesLocal.majactsport("Modéré",objmod2);
                } else {
                    //Si l'activité détente est cochée
                    Double objmod = lObjectif2;
                    int objmod2=(int) (objmod*1.375);

                    accesLocal.majactsport("Détente",objmod2);
                }
                Toast.makeText(getApplicationContext(), "L'activité choisie a bien été sauvegardée dans la base de données", Toast.LENGTH_LONG).show();
                startActivityForResult(myIntent, 0);
            }
        });
    }
}

