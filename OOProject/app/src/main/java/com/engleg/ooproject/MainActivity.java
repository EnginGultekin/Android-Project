package com.engleg.ooproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Constructor
        Users myuser = new Users("Engin","ComEng");
        System.out.println(myuser.job);

        //Encopsulation
        Musician once = new Musician("Engin","Cello",28);
        System.out.println(once.getAge());
        once.setAge(22,"5241");   // Sağ taraf şifre  //
        System.out.println(once.getAge());

        //Inheritance
        SuperMusician sonce = new SuperMusician("Tarkan" ,"Solist" ,36);
        System.out.println(sonce.sing());
        System.out.println(sonce.getAge());

        //Polymorphism - Static Polymorphism
        Mathematic mat = new Mathematic();
        System.out.println(mat.sum());
        System.out.println(mat.sum(5,7));
        System.out.println(mat.sum(5,7,8));

        //Dynemic Polymorphism
        Animal animal = new Animal();
        animal.sing();

        Dog dog = new Dog();
        dog.test();
        dog.sing();

        //Abstract
        Person person = new Person();
        System.out.println(person.Info());

        //Interface
        Piano piano = new Piano();
        piano.brand ="Kaya";
        piano.digital =true;
        piano.Info();




    }
}