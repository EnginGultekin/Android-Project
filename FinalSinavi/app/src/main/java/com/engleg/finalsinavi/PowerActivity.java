package com.engleg.finalsinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class PowerActivity extends AppCompatActivity {

    EditText Number2;
    EditText Power;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);

        Number2 = findViewById(R.id.number2);
        Power = findViewById(R.id.power);
        Result = findViewById(R.id.sonuc2);

    }

    public void calculatePower(View view){
        int Num1 = Integer.parseInt(Number2.getText().toString());  // Alttaki sayi
        int Num2 = Integer.parseInt(Power.getText().toString());  // Üstteki sayi
        int Res = 1;
        for(int i=Num2; i>0; i--){
            Res *= Num1;
        }
        Result.setText("Result: " + Res);  // Burda normalde integer değeri stringe çevirmemiz gerekli ama
        // tırnak içinde Result yazdığımız için bilgisayar string olrak algılıyor
    }

    public void goback2(View view){
        Intent intent = new Intent(PowerActivity.this , MainActivity.class);
        startActivity(intent);

    }


}