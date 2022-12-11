package com.engleg.finalsinavi;

import static android.view.KeyEvent.KEYCODE_ENTER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Spinner spinner;
  //  String[] hesaplamalar = { "Henüz Seçilmedi", "Calculate Factorial","Calculate Power of Number"};

    public class OnItemSelectedListenerS implements AdapterView.OnItemSelectedListener {
        public void  onItemSelected(AdapterView<?> parent, View view, int pos, long id){
            int num = pos;
            if(num == 2){
                Toast.makeText(parent.getContext(), "Hesaplama Modu "+ parent.getItemAtPosition(pos).toString()  ,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this , PowerActivity.class);
                startActivity(intent);
            }
            else if(num == 1){
                Toast.makeText(parent.getContext(), "Hesaplama Modu "+ parent.getItemAtPosition(pos).toString()  ,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this , FactorialActivity.class);
                startActivity(intent);

            }
            else {
                Toast.makeText(parent.getContext(), "Hesaplama Modu "+ parent.getItemAtPosition(pos).toString()  ,Toast.LENGTH_LONG).show();
            }
            pos=0;
        }
        public void onNothingSelected(AdapterView<?> arg0){
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spiner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.CalculateMod, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListenerS());

    }

    public void fact(View view){
        Intent intent = new Intent(MainActivity.this , FactorialActivity.class);
        startActivity(intent);
    }

    public void powe(View view){
        Intent intent = new Intent(MainActivity.this , PowerActivity.class);
        startActivity(intent);
    }
}