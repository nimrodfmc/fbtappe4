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
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.example.maximeglod.fbta.SaisiePoids.poidsMap;
import static com.example.maximeglod.fbta.SaisiePoids.recup_date;

public class Evolution extends Activity {
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
        final List list_x_axis_name = new ArrayList<>();

        mChart.getAxisLeft().setStartAtZero(false);
        mChart.getAxisRight().setStartAtZero(false);

        ArrayList<Entry> yValues = new ArrayList<>();
        Integer result = poidsMap.get("18/02/2019");
        //Implémentation fonction différence date

        //////////
        if (poidsMap != null) {
            mChart.getAxisLeft().setStartAtZero(false);
            mChart.getAxisRight().setStartAtZero(false);
            //Boucle While + iterator
            Iterator iterator = poidsMap.entrySet().iterator();
            Integer a = 0;
            while (iterator.hasNext()) {
                mChart.getAxisLeft().setStartAtZero(false);
                mChart.getAxisRight().setStartAtZero(false);
                Map.Entry mapentry = (Map.Entry) iterator.next();
                Object i = mapentry.getValue();
                Integer i2 = (Integer) i;
                //DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
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

                        Integer b = a + 1;
                        Integer getdays = period.getDays();

                        yValues.add(new Entry(getdays, i2));
                        //yValues.add(new Entry(1,63));
                        LineDataSet set1 = new LineDataSet(yValues, "Evolution de votre poids");
                        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                        dataSets.add(set1);
                        LineData data2 = new LineData(dataSets);
                        //LineData data3 = new LineDataSet(null,"Evolution du poids");
                        mChart.getAxisLeft().setStartAtZero(false);
                        mChart.getAxisRight().setStartAtZero(false);
                        mChart.setData(data2);

                    } else {
                        mChart.getAxisLeft().setStartAtZero(false);
                        mChart.getAxisRight().setStartAtZero(false);
                        final String heures = (corjour + cal.get(Calendar.DAY_OF_MONTH) + "/" + ds + "/" + cal.get(Calendar.YEAR));

                        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // format jour / mois / année

                        LocalDate date1 = LocalDate.parse(dateduhashmap, format);
                        LocalDate date2 = LocalDate.parse(heures, format);

                        Period period = Period.between(date1, date2);

                        Integer b = a + 1;
                        Integer getdays = period.getDays();

                        yValues.add(new Entry(getdays, i2));
                        //yValues.add(new Entry(1,63));
                        LineDataSet set1 = new LineDataSet(yValues, "Evolution de votre poids");
                        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                        dataSets.add(set1);
                        LineData data2 = new LineData(dataSets);
                        //LineData data3 = new LineDataSet(null,"Evolution du poids");
                        mChart.getAxisLeft().setStartAtZero(false);
                        mChart.getAxisRight().setStartAtZero(false);
                        mChart.setData(data2);

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
                        

                        Integer b = a + 1;
                        Integer getdays = period.getDays();

                        yValues.add(new Entry(getdays, i2));
                        //yValues.add(new Entry(1,63));
                        LineDataSet set1 = new LineDataSet(yValues, "Evolution de votre poids");
                        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                        dataSets.add(set1);
                        LineData data2 = new LineData(dataSets);
                        //LineData data3 = new LineDataSet(null,"Evolution du poids");
                        mChart.getAxisLeft().setStartAtZero(false);
                        mChart.getAxisRight().setStartAtZero(false);
                        mChart.setData(data2);

                    } else {
                        mChart.getAxisLeft().setStartAtZero(false);
                        mChart.getAxisRight().setStartAtZero(false);
                        final String heures = (cal.get(Calendar.DAY_OF_MONTH) + "/" + ds + "/" + cal.get(Calendar.YEAR));

                        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // format jour / mois / année

                        LocalDate date1 = LocalDate.parse(dateduhashmap, format);
                        LocalDate date2 = LocalDate.parse(heures, format);

                        Period period = Period.between(date1, date2);

                        Integer b = a + 1;
                        Integer getdays = period.getDays();

                        yValues.add(new Entry(getdays, i2));
                        //yValues.add(new Entry(1,63));
                        LineDataSet set1 = new LineDataSet(yValues, "Evolution de votre poids");
                        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                        dataSets.add(set1);
                        LineData data2 = new LineData(dataSets);
                        //LineData data3 = new LineDataSet(null,"Evolution du poids");
                        mChart.getAxisLeft().setStartAtZero(false);
                        mChart.getAxisRight().setStartAtZero(false);
                        mChart.setData(data2);

                    }

                }
                //final String heures = (cal.get(Calendar.DAY_OF_MONTH) + "/" + ds + "/" + cal.get(Calendar.YEAR));


            }
        }


    }


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