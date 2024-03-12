package com.politecnicomalaga.NasdaqOilPrices;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_day_item);

        Button btBack = findViewById(R.id.btAtras);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        GraphView gvGrafico = findViewById(R.id.gvGrafico);
        GraphController controller = new GraphController(MainController.getSingleton().getDataFromNasdaq());
        List<Double> oilPrices = controller.getOilPrices();

        ArrayList<DataPoint> dataPoints = new ArrayList<>();
        for (int i = 0; i < oilPrices.size(); i++) {
            DataPoint newDP = new DataPoint(i, oilPrices.get(i));
            dataPoints.add(newDP);
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPoints.toArray(new DataPoint[0]));
        series.setThickness(5);
        series.setTitle("Oil Price");
        series.setDrawBackground(true);
        series.setColor(Color.argb(255, 255, 60, 60));
        series.setBackgroundColor(Color.argb(100, 204, 119, 119));
        series.setDrawDataPoints(true);

        gvGrafico.getLegendRenderer().setVisible(true);
        gvGrafico.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        gvGrafico.getLegendRenderer().setBackgroundColor(Color.rgb(220, 220, 220));
        gvGrafico.removeAllSeries();
        gvGrafico.addSeries(series);

        gvGrafico.getViewport().setXAxisBoundsManual(true);
        gvGrafico.getViewport().setMinX(3);
        gvGrafico.getViewport().setMaxX(23);

       

    }
}