package com.kizilkaya.androidproje;

public class VerileriIsle {
    String restoran_ismi;
    String adres;
    String cinsi;
    String puan;


    public VerileriIsle(String restoran_ismi, String adres, String cinsi,String puan) {
        this.restoran_ismi = restoran_ismi;
        this.adres = adres;
        this.cinsi = cinsi;
        this.puan=puan;
    }

    public String getIsim() {
        return restoran_ismi;
    }

    public void setIsim(String restoran_ismi) {
        this.restoran_ismi = restoran_ismi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }


    public String getPuan() { return puan; }

    public void setPuan(String puan) { this.puan = puan; }


    public String getCinsi() { return cinsi; }

    public void setCinsi(String cinsi) { this.cinsi = cinsi; }


}
