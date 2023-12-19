package com.politecnicomalaga.NasdaqOilPrices;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GraphController {
    private List<Double> oilPrices;

    public GraphController(List<Price> priceList) {
        oilPrices = new ArrayList<>();
        createOilPrices(priceList);
    }

    private void createOilPrices(List<Price> list) {
        for (Price item : list) {
            oilPrices.add(Double.parseDouble(item.getPrice()));
        }
    }

    public List<Double> getOilPrices() {
        return oilPrices;
    }
}


