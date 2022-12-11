package com.engleg.arrays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ARRAY
        // Array Tanımlamasının 1.Yolu
        String[] myStringArray = new String[3];
        myStringArray[0] = "Engin";
        myStringArray[1] = "Volkan";
        myStringArray[2] = "Tahsin";
        System.out.println(myStringArray[2]);

        int[] myIntegerArray = new int[3];
        myIntegerArray[0] = 21;
        myIntegerArray[1] = 25;
        myIntegerArray[2] = 54;
        System.out.println(myIntegerArray[2]);



        // Array Tanımlamasının 2.Yolu
        int[] myNumberArray  = {1,2,3,4,5,6,7,8,9};
        System.out.println(myNumberArray[3]);             // 4 yazar
    }
}