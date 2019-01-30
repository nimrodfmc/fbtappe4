package com.example.maximeglod.fbta;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class ObjectifCalorie extends AppCompatActivity {
    TextView tv_objectif, tv_calorie, tv_conso, tv_total;
    Personne p1 = new Personne("Jules","Couraud",18,"Homme", (float) 1.78,90,"Intensité forte", 80);
    TextView total = (TextView )findViewById(R.id.tv_total);

public float totalcal = 2500;
}









   /* if (IMC > 40) {
        texte = "Ton IMC indique une obésité de classe III";
    } else {
        if (IMC > 35) {
            texte = "Ton IMC indique une obésité de classe II";
        } else {
            if (IMC > 30) {
                texte = "Ton IMC indique une obésité de classe I";
            } else {
                if (IMC > 25) {
                    texte = "Ton IMC indique une pré-obésité";
                } else {
                    if (IMC > 18.5) {
                        texte = "Ton IMC indique une corpulence normale";
                    } else {
                        if (IMC > 17) {
                            texte = "Ton IMC indique une insuffisance pondérale légère";
                        } else {
                            if (IMC > 16) {
                                texte = "Ton IMC indique une insuffisance pondérale modérée";
                            } else {
                                texte = "Ton IMC indique une insuffisance pondérale sévère";
                            }
                        }
                    }
                }
            }
        }
    }*/

