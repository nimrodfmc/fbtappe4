package com.example.maximeglod.fbta;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;


public class Evolution extends Activity {
    public static AccesLocal accesLocal;
    private RelativeLayout Evolution;
    private LineChart mChart;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Définission le contenu de la vue APRES les instructions précédentes pour éviter un crash

        super.onCreate(savedInstanceState);
        setContentView(R.layout.evolution);
        Evolution = (RelativeLayout) findViewById(R.id.Evolution);
        accesLocal = new AccesLocal(getApplicationContext());
        //Création du graph ligne
        mChart = new LineChart(this);
        //On ajoute au layout
        Evolution.addView(mChart, new AbsListView.LayoutParams
                (AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT));
        //Personalisation du graphique

        mChart.setNoDataText("Pas de données pour le moment");
        mChart.setHighlightPerTapEnabled(true);
        //Autorisation des geste de touché
        mChart.setTouchEnabled(true);
        //On souhaite aussi autoriser la mise à l'échelle
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setDrawGridBackground(false);
        //On autorise le zoom sur les axes différents
        mChart.setPinchZoom(false);
        //Alternative color background
        mChart.setBackgroundColor(Color.BLACK);
        mChart.animateXY(0, 1200);


        //Maintenant on travail sur les données
        //Récupération de la légende
        Legend l = mChart.getLegend();
        //Personalisation de la légende
        l.setForm(Legend.LegendForm.LINE);
        l.setTextColor(Color.WHITE);
        XAxis xl = mChart.getXAxis();
        xl.setTextColor(Color.WHITE);
        xl.setDrawGridLines(false);
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setDrawLabels(true);
        xl.setDrawAxisLine(true);
        xl.setAxisLineColor(Color.CYAN);
        xl.setAxisLineWidth(3);
        YAxis yl = mChart.getAxisLeft();
        yl.setTextColor(Color.WHITE);
        yl.setDrawGridLines(false);
        yl.setAxisLineColor(Color.CYAN);
        yl.setAxisLineWidth(3);
        YAxis yl2 = mChart.getAxisRight();
        yl2.setEnabled(false);

        mChart.setAutoScaleMinMaxEnabled(true);
        mChart.getAxisLeft().setStartAtZero(false);
        mChart.getAxisRight().setStartAtZero(false);

        ArrayList<Entry> yValues = new ArrayList<>();

        if (accesLocal.selectevolution() != null) {
            mChart.getAxisLeft().setStartAtZero(false);
            mChart.getAxisRight().setStartAtZero(false);
            //Boucle While + iterator
            Iterator iterator = accesLocal.selectevolution().entrySet().iterator();

            while (iterator.hasNext()) {
                mChart.getAxisLeft().setStartAtZero(false);
                mChart.getAxisRight().setStartAtZero(false);
                Map.Entry mapentry = (Map.Entry) iterator.next();
                Object i = mapentry.getValue();
                Integer i2 = (Integer) i;
                String dateduhashmap = (String) mapentry.getKey();


                Calendar cal = Calendar.getInstance();
                int ds = cal.get(Calendar.MONTH) + 1;
                if (cal.get(Calendar.DAY_OF_MONTH) < 10) {
                    mChart.getAxisLeft().setStartAtZero(false);
                    mChart.getAxisRight().setStartAtZero(false);
                    String corjour = "0";

                    if ((cal.get(Calendar.MONTH) + 1) < 10) {
                        mChart.getAxisLeft().setStartAtZero(false);
                        mChart.getAxisRight().setStartAtZero(false);
                        final String heures = (corjour + cal.get(Calendar.DAY_OF_MONTH) + "/" + corjour + ds + "/" + cal.get(Calendar.YEAR));

                        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // format jour / mois / année

                        LocalDate date1 = LocalDate.parse(dateduhashmap, format);
                        LocalDate date2 = LocalDate.parse(heures, format);

                        Period period = Period.between(date1, date2);

                        Integer comparaison = date1.compareTo(date2);
                        if (comparaison <= -1) {
                            Integer getdays = (period.getDays()) * -1;

                            yValues.add(new Entry(getdays, i2));
                            yValues.sort(new Comparator<Entry>() {
                                @Override
                                public int compare(Entry o1, Entry o2) {
                                    return 0;
                                }
                            });
                        } else {


                            Integer getdays = (period.getDays()) * -1;
                            yValues.add(new Entry(getdays, i2));
                            yValues.sort(new Comparator<Entry>() {
                                @Override
                                public int compare(Entry o1, Entry o2) {
                                    return 0;
                                }
                            });
                        }


                    } else {
                        mChart.getAxisLeft().setStartAtZero(false);
                        mChart.getAxisRight().setStartAtZero(false);
                        final String heures = (corjour + cal.get(Calendar.DAY_OF_MONTH) + "/" + ds + "/" + cal.get(Calendar.YEAR));

                        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // format jour / mois / année

                        LocalDate date1 = LocalDate.parse(dateduhashmap, format);
                        LocalDate date2 = LocalDate.parse(heures, format);

                        Period period = Period.between(date1, date2);

                        Integer comparaison = date1.compareTo(date2);
                        if (comparaison <= -1) {
                            Integer getdays = (period.getDays()) * -1;

                            yValues.add(new Entry(getdays, i2));
                            yValues.sort(new Comparator<Entry>() {
                                @Override
                                public int compare(Entry o1, Entry o2) {
                                    return 0;
                                }
                            });
                        } else {


                            Integer getdays = (period.getDays()) * -1;
                            yValues.add(new Entry(getdays, i2));
                            yValues.sort(new Comparator<Entry>() {
                                @Override
                                public int compare(Entry o1, Entry o2) {
                                    return 0;
                                }
                            });
                        }


                    }

                } else {
                    mChart.getAxisLeft().setStartAtZero(false);
                    mChart.getAxisRight().setStartAtZero(false);

                    if ((cal.get(Calendar.MONTH) + 1) < 10) {
                        mChart.getAxisLeft().setStartAtZero(false);
                        mChart.getAxisRight().setStartAtZero(false);
                        final String heures = (cal.get(Calendar.DAY_OF_MONTH) + "/" + "0" + ds + "/" + cal.get(Calendar.YEAR));

                        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // format jour / mois / année

                        LocalDate date1 = LocalDate.parse(dateduhashmap, format);
                        LocalDate date2 = LocalDate.parse(heures, format);

                        Period period = Period.between(date1, date2);
                        Integer comparaison = date1.compareTo(date2);
                        if (comparaison <= -1) {
                            Integer getdays = (period.getDays()) * -1;

                            yValues.add(new Entry(getdays, i2));
                            yValues.sort(new Comparator<Entry>() {
                                @Override
                                public int compare(Entry o1, Entry o2) {
                                    return 0;
                                }
                            });
                        } else {


                            Integer getdays = (period.getDays()) * -1;
                            yValues.add(new Entry(getdays, i2));
                            yValues.sort(new Comparator<Entry>() {
                                @Override
                                public int compare(Entry o1, Entry o2) {
                                    return 0;
                                }
                            });
                        }

                    } else {
                        mChart.getAxisLeft().setStartAtZero(false);
                        mChart.getAxisRight().setStartAtZero(false);
                        final String heures = (cal.get(Calendar.DAY_OF_MONTH) + "/" + ds + "/" + cal.get(Calendar.YEAR));

                        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // format jour / mois / année

                        LocalDate date1 = LocalDate.parse(dateduhashmap, format);
                        LocalDate date2 = LocalDate.parse(heures, format);

                        Period period = Period.between(date1, date2);

                        Integer comparaison = date1.compareTo(date2);
                        if (comparaison <= -1) {
                            Integer getdays = (period.getDays()) * -1;

                            yValues.add(new Entry(getdays, i2));
                            yValues.sort(new Comparator<Entry>() {
                                @Override
                                public int compare(Entry o1, Entry o2) {
                                    return 0;
                                }
                            });
                        } else {

                            Integer getdays = (period.getDays()) * -1;
                            yValues.add(new Entry(getdays, i2));
                            yValues.sort(new Comparator<Entry>() {
                                @Override
                                public int compare(Entry o1, Entry o2) {
                                    return 0;
                                }
                            });
                        }

                    }

                }


            }

//            //Tri des valeur en X
            Collections.sort(yValues, new EntryXComparator());

            LineDataSet set1 = new LineDataSet(yValues, "Evolution de votre poids en kg en fonction des jours");

            //Personalisation de la ligne entre les points
            set1.setColor(Color.argb(255, 255, 165, 0));
            set1.setLineWidth(4);
            set1.setCircleColor(Color.GREEN);
            set1.setCircleRadius(6);
            set1.setValueTextSize(15);
            set1.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
            set1.setHighLightColor(Color.RED);
            set1.setValueTextColor(Color.WHITE);

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1);


            LineData data2 = new LineData(dataSets);
            mChart.getDescription().setEnabled(false);
            mChart.getAxisLeft().setStartAtZero(false);
            mChart.getAxisRight().setStartAtZero(false);


            mChart.setData(data2);


        }


    }


}