package com.politecnicomalaga.NasdaqOilPrices;

import android.util.Log;

import com.jjoe64.graphview.GraphView;

import java.util.LinkedList;
import java.util.List;

public class MainController {

    //SINGLETON Controller
    private static final String DATA_URL = "https://data.nasdaq.com/api/v3/datatables/QDL/OPEC.json?api_key=aBic3pvBmjQd4zgQPpY3";
    private static MainController mySingleController;

    private List<Price> dataRequested;
    private static MainActivity activeActivity;
    //Comportamiento
    //Constructor
    private MainController() {
         dataRequested = new LinkedList<Price>();
    }

    //Get instance
    public static MainController getSingleton() {
        if (MainController.mySingleController == null) {
            mySingleController = new MainController();
        }
        return mySingleController;
    }

    //To send data to view
    public List<Price> getDataFromNasdaq() {
        return this.dataRequested;
    }

    //Called from the view
    public void requestDataFromNasdaq() {
        Peticion p = new Peticion();
        p.requestData(DATA_URL);
    }

    //Called when onResponse is OK
    public void setDataFromNasdaq(String json) {

        Respuesta answer = new Respuesta(json);
        dataRequested = answer.getData();
        MainController.activeActivity.accessData();
    }

    public void setErrorFromNasdaq(String error) {

        //Load data on the list
        MainController.activeActivity.errorData(error);
    }


    public static void setActivity(MainActivity myAct) {
        activeActivity = myAct;
    }

}
