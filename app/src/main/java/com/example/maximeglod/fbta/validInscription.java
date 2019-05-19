package com.example.maximeglod.fbta;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class validInscription extends AppCompatActivity {
    private static AccesLocal accesLocal;
    TextView tv_prenom, tv_nom, tv_naissance, tv_taille, tv_poids, tv_objectif, tv_sexe, tv_activite;
    Button btn_inscrire;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Définission le contenu de la vue APRES les instructions précédentes pour éviter un crash
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valid_inscription);
        accesLocal = new AccesLocal(getApplicationContext());
        tv_prenom = (TextView) findViewById(R.id.tvPrenom);
        tv_nom = (TextView) findViewById(R.id.tvNom);
        tv_naissance = (TextView) findViewById(R.id.tvAge);
        tv_taille = (TextView) findViewById(R.id.tvTaille);
        tv_poids = (TextView) findViewById(R.id.tvPoids);
        tv_objectif = (TextView) findViewById(R.id.tvObjectif);
        tv_sexe = (TextView) findViewById(R.id.tvSexe);
        tv_activite = (TextView) findViewById(R.id.tvSport);
        btn_inscrire = (Button) findViewById(R.id.btn_inscrire);
        final String lePrenom = getIntent().getStringExtra("Prénom");
        final String leNom = getIntent().getStringExtra("Nom");
        String laNaissance = getIntent().getStringExtra("Naissance");
        final String leSexe = getIntent().getStringExtra("Sexe");
        final String laTaille = getIntent().getStringExtra("Taille");
        final String lePoids = getIntent().getStringExtra("Poids");
        final String lActivite = getIntent().getStringExtra("Activité sportive");
        tv_prenom.setText("Prénom : " + lePrenom);
        tv_nom.setText("Nom : " + leNom);
        tv_naissance.setText("Date de naissance : " + laNaissance);
        tv_sexe.setText("Sexe : " + leSexe);
        tv_taille.setText("Taille : " + laTaille);
        tv_poids.setText("Poids : " + lePoids);
        tv_activite.setText("Activité Sportive : " + lActivite);

        Integer lObjectif = 0;
        //Calcul de l'âge

        Calendar cal = Calendar.getInstance();
        int ds = cal.get(Calendar.MONTH) + 1;
        String corjour = "0";
        if (ds < 10) {
            if (cal.get(Calendar.DAY_OF_MONTH) < 10) {
                final String heures = (corjour+cal.get(Calendar.DAY_OF_MONTH) + "/" + corjour + ds + "/" + cal.get(Calendar.YEAR));

                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRANCE); // format jour / mois / année

                LocalDate date1 = LocalDate.parse(laNaissance, format);
                LocalDate date2 = LocalDate.parse(heures, format);

                Period period = Period.between(date1, date2);
                //Différence d'années entre la date de naissance et la date actuelle
                final Integer age = period.getYears();


                //Calcul de l'objectif calorique
                if (leSexe.equals("F")) {
                    //Calcul de l'objectif calorique pour une femme
                    Double objcal = (9.5634 * (Integer.parseInt(lePoids))) + (184.96 * (Double.parseDouble(laTaille))) - (4.6756 * age) + 655.0955;
                    if (lActivite.equals("Détente")) {
                        //Si l'activité est faible

                        Integer objectifcalorique = (int) (objcal * 1.375);
                        lObjectif = objectifcalorique;

                    } else if (lActivite.equals("Modéré")) {
                        //Si l'activité est modéré
                        Integer objectifcalorique = (int) (objcal * 1.64);
                        lObjectif = objectifcalorique;

                    } else {
                        //Si l'activité est intense
                        Integer objectifcalorique = (int) (objcal * 1.82);
                        lObjectif = objectifcalorique;
                    }
                } else {
                    //Calcul de l'objectif calorique pour un homme
                    Double objcal = (13.7516 * (Integer.parseInt(lePoids))) + (500.33 * (Double.parseDouble(laTaille))) - (6.7550 * age) + 66.473;
                    if (lActivite.equals("Détente")) {
                        //Si l'activité est faible

                        Integer objectifcalorique = (int) (objcal * 1.375);
                        lObjectif = objectifcalorique;

                    } else if (lActivite.equals("Modéré")) {
                        //Si l'activité est modéré
                        Integer objectifcalorique = (int) (objcal * 1.64);
                        lObjectif = objectifcalorique;

                    } else {
                        //Si l'activité est intense
                        Integer objectifcalorique = (int) (objcal * 1.82);
                        lObjectif = objectifcalorique;

                    }
                }

                final Integer finalLObjectif = lObjectif;
                btn_inscrire.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        Intent e = new Intent(getApplicationContext(), MainActivity.class);
                        //Inscription dans la base de données
                        accesLocal.ajoututilisateur(leSexe, lePrenom, age, Double.parseDouble(laTaille), Double.parseDouble(lePoids), lActivite, finalLObjectif);
                        Toast.makeText(getApplicationContext(), "Utilisateur " + lePrenom + " " + leNom + " bien enregistré", Toast.LENGTH_LONG).show();
                        startActivity(e);
                    }

                });
            } else {
                final String heures = (cal.get(Calendar.DAY_OF_MONTH) + "/" + corjour + ds + "/" + cal.get(Calendar.YEAR));

                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRANCE); // format jour / mois / année

                LocalDate date1 = LocalDate.parse(laNaissance, format);
                LocalDate date2 = LocalDate.parse(heures, format);

                Period period = Period.between(date1, date2);
                //Différence d'années entre la date de naissance et la date actuelle
                final Integer age = period.getYears();


                //Calcul de l'objectif calorique
                if (leSexe.equals("F")) {
                    //Calcul de l'objectif calorique pour une femme
                    Double objcal = (9.5634 * (Integer.parseInt(lePoids))) + (184.96 * (Double.parseDouble(laTaille))) - (4.6756 * age) + 655.0955;
                    if (lActivite.equals("Détente")) {
                        //Si l'activité est faible

                        Integer objectifcalorique = (int) (objcal * 1.375);
                        lObjectif = objectifcalorique;

                    } else if (lActivite.equals("Modéré")) {
                        //Si l'activité est modéré
                        Integer objectifcalorique = (int) (objcal * 1.64);
                        lObjectif = objectifcalorique;

                    } else {
                        //Si l'activité est intense
                        Integer objectifcalorique = (int) (objcal * 1.82);
                        lObjectif = objectifcalorique;
                    }
                } else {
                    //Calcul de l'objectif calorique pour un homme
                    Double objcal = (13.7516 * (Integer.parseInt(lePoids))) + (500.33 * (Double.parseDouble(laTaille))) - (6.7550 * age) + 66.473;
                    if (lActivite.equals("Détente")) {
                        //Si l'activité est faible

                        Integer objectifcalorique = (int) (objcal * 1.375);
                        lObjectif = objectifcalorique;

                    } else if (lActivite.equals("Modéré")) {
                        //Si l'activité est modéré
                        Integer objectifcalorique = (int) (objcal * 1.64);
                        lObjectif = objectifcalorique;

                    } else {
                        //Si l'activité est intense
                        Integer objectifcalorique = (int) (objcal * 1.82);
                        lObjectif = objectifcalorique;

                    }
                }

                final Integer finalLObjectif = lObjectif;
                btn_inscrire.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        Intent e = new Intent(getApplicationContext(), MainActivity.class);
                        //Inscription dans la base de données
                        accesLocal.ajoututilisateur(leSexe, lePrenom, age, Double.parseDouble(laTaille), Double.parseDouble(lePoids), lActivite, finalLObjectif);
                        Toast.makeText(getApplicationContext(), "Utilisateur " + lePrenom + " " + leNom + " bien enregistré", Toast.LENGTH_LONG).show();
                        startActivity(e);
                    }

                });
            }
        } else {
            if (cal.get(Calendar.DAY_OF_MONTH) < 10) {

                final String heures = (corjour + cal.get(Calendar.DAY_OF_MONTH) + "/" + ds + "/" + cal.get(Calendar.YEAR));

                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRANCE); // format jour / mois / année

                LocalDate date1 = LocalDate.parse(laNaissance, format);
                LocalDate date2 = LocalDate.parse(heures, format);

                Period period = Period.between(date1, date2);
                //Différence d'années entre la date de naissance et la date actuelle
                final Integer age = period.getYears();


                //Calcul de l'objectif calorique
                if (leSexe.equals("F")) {
                    //Calcul de l'objectif calorique pour une femme
                    Double objcal = (9.5634 * (Integer.parseInt(lePoids))) + (184.96 * (Double.parseDouble(laTaille))) - (4.6756 * age) + 655.0955;
                    if (lActivite.equals("Détente")) {
                        //Si l'activité est faible

                        Integer objectifcalorique = (int) (objcal * 1.375);
                        lObjectif = objectifcalorique;

                    } else if (lActivite.equals("Modéré")) {
                        //Si l'activité est modéré
                        Integer objectifcalorique = (int) (objcal * 1.64);
                        lObjectif = objectifcalorique;

                    } else {
                        //Si l'activité est intense
                        Integer objectifcalorique = (int) (objcal * 1.82);
                        lObjectif = objectifcalorique;
                    }
                } else {
                    //Calcul de l'objectif calorique pour un homme
                    Double objcal = (13.7516 * (Integer.parseInt(lePoids))) + (500.33 * (Double.parseDouble(laTaille))) - (6.7550 * age) + 66.473;
                    if (lActivite.equals("Détente")) {
                        //Si l'activité est faible

                        Integer objectifcalorique = (int) (objcal * 1.375);
                        lObjectif = objectifcalorique;

                    } else if (lActivite.equals("Modéré")) {
                        //Si l'activité est modéré
                        Integer objectifcalorique = (int) (objcal * 1.64);
                        lObjectif = objectifcalorique;

                    } else {
                        //Si l'activité est intense
                        Integer objectifcalorique = (int) (objcal * 1.82);
                        lObjectif = objectifcalorique;

                    }
                }

                final Integer finalLObjectif = lObjectif;
                btn_inscrire.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        Intent e = new Intent(getApplicationContext(), MainActivity.class);
                        //Inscription dans la base de données
                        accesLocal.ajoututilisateur(leSexe, lePrenom, age, Double.parseDouble(laTaille), Double.parseDouble(lePoids), lActivite, finalLObjectif);
                        Toast.makeText(getApplicationContext(), "Utilisateur " + lePrenom + " " + leNom + " bien enregistré", Toast.LENGTH_LONG).show();
                        startActivity(e);
                    }

                });
            } else {
                final String heures = (cal.get(Calendar.DAY_OF_MONTH) + "/" + ds + "/" + cal.get(Calendar.YEAR));

                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.FRANCE); // format jour / mois / année

                LocalDate date1 = LocalDate.parse(laNaissance, format);
                LocalDate date2 = LocalDate.parse(heures, format);

                Period period = Period.between(date1, date2);
                //Différence d'années entre la date de naissance et la date actuelle
                final Integer age = period.getYears();


                //Calcul de l'objectif calorique
                if (leSexe.equals("F")) {
                    //Calcul de l'objectif calorique pour une femme
                    Double objcal = (9.5634 * (Integer.parseInt(lePoids))) + (184.96 * (Double.parseDouble(laTaille))) - (4.6756 * age) + 655.0955;
                    if (lActivite.equals("Détente")) {
                        //Si l'activité est faible

                        Integer objectifcalorique = (int) (objcal * 1.375);
                        lObjectif = objectifcalorique;

                    } else if (lActivite.equals("Modéré")) {
                        //Si l'activité est modéré
                        Integer objectifcalorique = (int) (objcal * 1.64);
                        lObjectif = objectifcalorique;

                    } else {
                        //Si l'activité est intense
                        Integer objectifcalorique = (int) (objcal * 1.82);
                        lObjectif = objectifcalorique;
                    }
                } else {
                    //Calcul de l'objectif calorique pour un homme
                    Double objcal = (13.7516 * (Integer.parseInt(lePoids))) + (500.33 * (Double.parseDouble(laTaille))) - (6.7550 * age) + 66.473;
                    if (lActivite.equals("Détente")) {
                        //Si l'activité est faible

                        Integer objectifcalorique = (int) (objcal * 1.375);
                        lObjectif = objectifcalorique;

                    } else if (lActivite.equals("Modéré")) {
                        //Si l'activité est modéré
                        Integer objectifcalorique = (int) (objcal * 1.64);
                        lObjectif = objectifcalorique;

                    } else {
                        //Si l'activité est intense
                        Integer objectifcalorique = (int) (objcal * 1.82);
                        lObjectif = objectifcalorique;

                    }
                }

                final Integer finalLObjectif = lObjectif;
                btn_inscrire.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        Intent e = new Intent(getApplicationContext(), MainActivity.class);
                        //Inscription dans la base de données
                        accesLocal.ajoututilisateur(leSexe, lePrenom, age, Double.parseDouble(laTaille), Double.parseDouble(lePoids), lActivite, finalLObjectif);
                        Toast.makeText(getApplicationContext(), "Utilisateur " + lePrenom + " " + leNom + " bien enregistré", Toast.LENGTH_LONG).show();
                        startActivity(e);
                    }

                });
            }
        }

    }
}