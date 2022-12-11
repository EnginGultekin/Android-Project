package com.engleg.methodsclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate");

        testMethod();    // İstediğimiz yerde Çağırabiliriz
        System.out.println(Math(3,4));      // Math fonksyonuun çağırdı
        System.out.println(newMethod("Engin"));   // newMethod fonksyonuun çağırdı
        makeMusician();
        makeSimpsons();
    }

     // Method
    public void  makeMusician(){
        //İnstance
        Musicians one = new Musicians("James","Guitar",50);
        System.out.println(one.name);
    }

    // Method
    public void makeSimpsons(){
        Simpsons Homer = new Simpsons("Homer","Nuclear",36);
        System.out.println(Homer.getName());

        Homer.setName("Homer Simpsons");
        System.out.println(Homer.getName());
    }



    public void testMethod(){
        int x = 4+4;
        System.out.println("Value of x: " +x);
    }
    public int Math(int a, int b){
        return a+b;
    }
    public String newMethod(String s1){
        return s1 + " New Method";
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
        testMethod();    // Burda da çağırdık
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop");
    }
}