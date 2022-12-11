package com.engleg.ooproject;

public class Musician {

    private String name;
    private String enstrumant;
    private int age;
    //Constructor
    public Musician(String name, String enstrumant, int age) {
        this.name = name;
        this.enstrumant = enstrumant;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public String getEnstrumant() { return enstrumant; }
    public void setEnstrumant(String enstrumant) {
        this.enstrumant = enstrumant;
    }

    public int getAge() { return age; }
    public void setAge(int age ,String password) {
        if (password.matches("5241")){   // şifreyi girdik 
            this.age = age;
        }
    }
}
