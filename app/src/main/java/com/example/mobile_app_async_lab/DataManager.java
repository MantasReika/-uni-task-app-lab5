package com.example.mobile_app_async_lab;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataManager {

    public static String fetchExchangeRatesForCurrency(String currencyCode) throws IOException {
        String rate = "Failed data fetching...";
        InputStream stream = fetchDataFromURL(Constants.API_EXCHANGE_URL + currencyCode + ".xml");
        try {
            rate = XmlParser.parseExchangeRates(stream);
        }
        finally {
            if (stream != null) {
                stream.close();
            }
        }
        return rate;
    }

    private static InputStream fetchDataFromURL(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }
}
