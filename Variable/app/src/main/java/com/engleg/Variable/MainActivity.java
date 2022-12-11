package com.engleg.Variable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.engleg.javalearning2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int   a1=10 , b1=3;
        System.out.println(a1/b1);
        float a2=10 , b2=3 ;
        System.out.println(a2/b2);
        long   a3=10 , b3=3;
        System.out.println(a3/b3);
        double   a4=10.0 , b4=3.0;     // Direkt 10 ve 3 olarakta yazabiliriz.
        System.out.println(a4/b4);

        String name = "Engin";
        String surname = "Gültekin";
        System.out.println(name);
        System.out.println(surname);

        String fullname = name + " " + surname;
        System.out.println(fullname);


        boolean isalive = true;
        System.out.println(isalive);
        isalive = false;
        System.out.println(isalive);

        // Final kullanımını defterde yazdık 


    }
}