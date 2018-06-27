package com.BetterTogether.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import DB.QueryHandler;
import DB.SQLiteDB;
import DB.Tables.Pair;

public class Overview extends AppCompatActivity {

    private SQLiteDB db;
    private QueryHandler handler;
    private Date d = new Date(new GregorianCalendar(2017, 01,01, 00,00,00).getTimeInMillis());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createDB();
        setContentView(R.layout.activity_overview);
        addPairToDB();
    }


    private void createDB(){
        db = SQLiteDB.getInstance(this);
        handler = new QueryHandler(this);
    }

    private void addPairToDB(){
        handler.addPair(new Pair(d))
                .subscribe(longs -> Log.d("room", Long.toString(longs))
                        , error -> Log.d("error", error.toString()));
    }



}
