package com.engleg.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView3);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userInput");  // userInput bizim anahtar kelimemiz
        textView.setText(userName);
    }

    public void changeOld(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        // Burdan birinci Activitye geçmek için kullanılan kodu yazdık
    }

}