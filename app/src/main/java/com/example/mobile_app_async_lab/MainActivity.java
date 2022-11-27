package com.example.mobile_app_async_lab;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textViewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textViewContent = findViewById(R.id.textViewContent);

    }

    public void onClickBtnDownload(View view) {
        this.textViewContent.setText("Loading...");
        new DataLoader(){
            @Override
            public void onPostExecute(String result)
            {
                textViewContent.setText(result);

            }
        }.execute("usd");
    }
}