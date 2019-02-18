package com.example.maximeglod.fbta;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
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
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.maximeglod.fbta.SaisiePoids.poidsMap;
import static com.example.maximeglod.fbta.SaisiePoids.recup_date;

public class Evolution extends Activity {
    private RelativeLayout Evolution;
    private LineChart mChart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // On retire la barre de notifications pour afficher l'application en plein écran
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Définission le contenu de la vue APRES les instructions précédentes pour éviter un crash

        super.onCreate(savedInstanceState);
        setContentView(R.layout.evolution);
        Evolution = (RelativeLayout) findViewById(R.id.Evolution);

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
        mChart.setPinchZoom(true);
        //Alternative color background
        mChart.setBackgroundColor(Color.BLACK);
        //Maintenant on travail sur les données
        //LineData data = new LineData();
       // data.setValueTextColor(Color.WHITE);
        //On ajoute les données au graphique
       // mChart.setData(data);
        //Récupération de la légende
        Legend l = mChart.getLegend();
        //Personalisation de la légende
        l.setForm(Legend.LegendForm.LINE);
        l.setTextColor(Color.WHITE);

        XAxis xl = mChart.getXAxis();
        xl.setTextColor(Color.WHITE);
        xl.setDrawGridLines(false);
        xl.setAvoidFirstLastClipping(true);

        YAxis yl = mChart.getAxisLeft();
        yl.setTextColor(Color.WHITE);
        yl.setAxisMaxValue(120f);
        yl.setDrawGridLines(false);

        YAxis yl2 = mChart.getAxisRight();
        yl2.setEnabled(false);


       ArrayList<Entry> yValues = new ArrayList<>();
      Integer result = poidsMap.get("18/02/2019");
if (poidsMap!=null){
    for (Map.Entry<String,Integer> e : poidsMap.entrySet()){

        yValues.add(new Entry(0,poidsMap.get(recup_date)));
        //yValues.add(new Entry(1,63));
        LineDataSet set1 = new LineDataSet(yValues,"Evolution de votre poids");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        LineData data2 = new LineData(dataSets);
        //LineData data3 = new LineDataSet(null,"Evolution du poids");

        mChart.setData(data2);
    }
}


    }
//    @Override
//    protected void onResume() {
//
//        super.onResume();
//        //Simulation d'ajout en temps réel
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //On ahoute 100 entrées
//                for (int i = 0; i<100;i++){
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        addEntry(); //Le graphique est notifié du changement d'entrée
//
//                    }
//                });
//                //Pause entre les ajouts
//                    try {
//                        Thread.sleep(600);
//                    } catch (InterruptedException e) {
//                        //On gère l'erreur...
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//    }

    //Ajout des données au graph

    //Méthode to create set
    private LineDataSet createSet() {
        LineDataSet set = new LineDataSet(null, "Evolution du poids");
        set.setCubicIntensity(0.2f);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setColor(ColorTemplate.getHoloBlue());
        set.setCircleColor(ColorTemplate.getHoloBlue());
        set.setLineWidth(2f);
        set.setCircleSize(4f);
        set.setFillAlpha(65);
        set.setFillColor(ColorTemplate.getHoloBlue());
        set.setValueTextSize(10f);


        return set;

    }

    public static Map<String, Integer> poidsMap = SaisiePoids.poidsMap;
}