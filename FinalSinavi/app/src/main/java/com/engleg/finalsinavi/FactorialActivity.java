package com.engleg.finalsinavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FactorialActivity extends AppCompatActivity {

    EditText Number1;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        Number1 = findViewById(R.id.number1);
        Result = findViewById(R.id.sonuc1);

    }

    public void calculateFactorial(View view){
        int Num1 = Integer.parseInt(Number1.getText().toString());
        int Res = 1;
        for(int i=Num1; i>1; i--){
            Res *= i;
        }
        Result.setText("Result: " + Res);  // Burda normalde integer değeri stringe çevirmemiz gerekli ama
        // tırnak içinde Result yazdığımız için bilgisayar string olrak algılıyor
    }


    public void goback1(View view){  // OnClick Kullandık
        Intent intent = new Intent(FactorialActivity.this , MainActivity.class);
        startActivity(intent);
    }
}