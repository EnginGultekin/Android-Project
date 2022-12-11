package com.engleg.list_set_map_array;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ARRAY
        String[] myStringArray = new String[3];
        myStringArray[0] = "Engin";
        myStringArray[1] = "Volkan";
        myStringArray[2] = "Tahsin";
        System.out.println(myStringArray[2]);

        // LİST
        ArrayList<String> myMusician = new ArrayList<>();  // kaç elemen alacağını başta belirtmemeize gerek yok
        myMusician.add("Mozart");
        myMusician.add("Lars");
        myMusician.add(0 , "Tarkan");   // index ve element yazısını bilgisayar ekliyor
        myMusician.add("Rob");

        System.out.println(myMusician.get(0));
        System.out.println(myMusician.get(1));
        System.out.println(myMusician.get(2));
        System.out.println(myMusician.get(3));
        System.out.println(myMusician.size());    // 4

        // SET
        HashSet<String> mySet = new HashSet<>();
        mySet.add("James");
        mySet.add("James");

        System.out.println(mySet.size());  // 1 Yazcak çünkü Set'te her elemandan sadece bir tane olabilir


        // Map
        HashMap<String , String> myHashMap = new HashMap<>();
        myHashMap.put("name","Engin");
        myHashMap.put("surname","Gültekin");
        System.out.println(myHashMap.get("name"));      //Engin
        System.out.println(myHashMap.get("surname"));  //Gültekin

        HashMap<String , Integer> mySecMap = new HashMap<>();
        mySecMap.put("run", 200);
        mySecMap.put("swim" , 450);
        mySecMap.put("walk" ,150);

        System.out.println(mySecMap.get("run"));


    }
}