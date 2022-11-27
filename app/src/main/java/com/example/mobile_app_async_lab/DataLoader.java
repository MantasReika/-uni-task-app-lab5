package com.example.mobile_app_async_lab;

import android.os.AsyncTask;

import java.io.PrintWriter;
import java.io.StringWriter;

public class DataLoader extends AsyncTask<String, Void, String> {

    protected String doInBackground(String... params) {
        try {
            return DataManager.fetchExchangeRatesForCurrency(params[0]);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            return sw.toString();
        }
    }
}