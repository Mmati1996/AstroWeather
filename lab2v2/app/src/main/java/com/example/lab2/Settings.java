package com.example.lab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Settings extends Activity {

    public static double x=0;
    public static double y=0;
    public static int r=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);
        ListenerX listenerX = new ListenerX();
        ListenerY listenerY = new ListenerY();
        ListenerR listenerR = new ListenerR();

        EditText xCoordinate = findViewById(R.id.coordinatesX);
        EditText yCoordinate = findViewById(R.id.coordinatesY);
        EditText refresh = findViewById(R.id.refresh);

        xCoordinate.addTextChangedListener(listenerX);
        yCoordinate.addTextChangedListener(listenerY);
        refresh.addTextChangedListener(listenerR);

    }

    public static int getR(){
        return r;
    }


}