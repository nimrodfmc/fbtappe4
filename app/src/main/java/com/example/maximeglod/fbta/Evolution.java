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
import com.github.mikephil.charting.utils.ColorTemplate;

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
        mChart.setDescription("");
        mChart.setNoDataTextDescription("Pas de données pour le moment");
        mChart.setHighlightEnabled(true);
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
        LineData data = new LineData();
        data.setValueTextColor(Color.WHITE);
        //On ajoute les données au graphique
        mChart.setData(data);
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
        yl.setDrawGridLines(true);

        YAxis yl2 = mChart.getAxisRight();
        yl2.setEnabled(false);


    }

    //Ajout des données au graph
    private void addEntry() {
        LineData data = mChart.getData();
        if (data != null) {
            LineDataSet set = (LineDataSet) data.getDataSetByIndex(0);
            if (set == null) {
                //création if null
                set = createSet();
                data.addDataSet(set);
            }
            //ajout de nouvelles valeurs random
            data.addXValue("");
            data.addEntry(new Entry((float) (Math.random() * 75) + 60f, set.getEntryCount()), 0);
            //le graphique a connaissance du changement
            mChart.notifyDataSetChanged();

            //On limote le nombre d'entrée visible
            mChart.setVisibleXRange(6);

            //Scroll à la dernière entrée
            mChart.moveViewToX(data.getXValCount() - 7);
        }
    }
    //Méthode to create set
    private LineDataSet createSet() {
        LineDataSet set = new LineDataSet(null,"SPL Db");
        set.setDrawCubic(true);
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
}