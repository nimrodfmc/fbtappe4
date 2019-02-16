package com.example.maximeglod.fbta;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.maximeglod.fbta.R;

public class SplashScreen extends AppCompatActivity {


    private static int SPLASH_TIME = 3000; //Environ 2 secondes

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //On enlève la barre de titre
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Définission le contenu de la vue APRES les instructions précédentes pour éviter un crash
        this.setContentView(R.layout.activity_splash);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);




        //Code qui commence avec le timer et lance les actions ensuite
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //On change de page
                Intent mySuperIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(mySuperIntent);

                /* Ce finish() sert à quitter l'application lorsque le bouton de retour est enfoncé
                 * de la page d'accueil qui est mainactivity
                 */
                finish();
            }
        }, SPLASH_TIME);
    }

}
