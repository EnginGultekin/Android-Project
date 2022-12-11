package com.engleg.ooproject;

public class Piano implements Decore,HouseRoom {

    String brand;
    boolean digital;

    @Override
    public void Info() {
        System.out.println("Override Method");
    }
}
