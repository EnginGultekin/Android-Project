package com.engleg.kitapkayit;

public class Users {

    int id;
    String name;
    String eposta;
    String password;
    int number;

    public Users(int id, String name, String eposta, String password, int number) {
        this.id = id;
        this.name = name;
        this.eposta = eposta;
        this.password = password;
        this.number = number;
    }

    public Users(String name, String eposta, String password, int number) {
        this.name = name;
        this.eposta = eposta;
        this.password = password;
        this.number = number;
    }

    public Users(String name, String eposta, String password, int number) {
        this.name = name;
        this.eposta = eposta;
        this.password = password;
    }


}
