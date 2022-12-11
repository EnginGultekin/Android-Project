package com.engleg.ooproject;

//Inheritance
public class SuperMusician extends Musician{
    public SuperMusician(String name, String enstrumant, int age) {
        super(name, enstrumant, age);
    }

    public String sing(){
        return "Lost On You ...";
    }
}
