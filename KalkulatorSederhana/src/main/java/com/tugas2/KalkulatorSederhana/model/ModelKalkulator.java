package com.tugas2.KalkulatorSederhana.model;

public class ModelKalkulator {
    public String operator;
    public int angka1, angka2;

    public ModelKalkulator() {
    }

    public ModelKalkulator(String operator, int angka1, int angka2) {
        this.operator = operator;
        this.angka1 = angka1;
        this.angka2 = angka2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getAngka1() {
        return angka1;
    }

    public void setAngka1(int angka1) {
        this.angka1 = angka1;
    }

    public int getAngka2() {
        return angka2;
    }

    public void setAngka2(int angka2) {
        this.angka2 = angka2;
    }
}
