package com.tugas2.GanjilGenapMVC.model;

public class ModelAngka {
    int angka;
    String keterangan;

    public ModelAngka(int angka, String keterangan) {
        this.angka = angka;
        this.keterangan = keterangan;
    }

    public int getAngka() {
        return angka;
    }

    public void setAngka(int angka) {
        this.angka = angka;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
