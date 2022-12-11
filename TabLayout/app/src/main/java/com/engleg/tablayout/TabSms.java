package com.engleg.tablayout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TabSms extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textview = new TextView(this);
        textview.setPadding(45,150,0,0);
        textview.setTextSize(30);
        textview.setText("MESAJ EKRANI");
        setContentView(textview);
    }
}
