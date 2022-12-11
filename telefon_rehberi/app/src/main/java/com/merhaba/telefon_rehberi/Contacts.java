package com.merhaba.telefon_rehberi;

public class Contacts {
    public int id;
    public String name;
    public long number;
    public String mail;

    public Contacts()
    {
    }
    public Contacts(int id, String name, long number, String mail)
    {
        this.id = id;
        this.name = name;
        this.number = number;
        this.mail = mail;
    }
    public Contacts(String name, long number, String mail)
    {
        this.name = name;
        this.number = number;
        this.mail = mail;
    }
}
