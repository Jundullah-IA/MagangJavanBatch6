package com.tugas2.Organisasi.Models;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    Integer id;
    int atasan_id;
    int company_id;
    String nama;

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAtasan_id() {
        return atasan_id;
    }

    public void setAtasan_id(int atasan_id) {
        this.atasan_id = atasan_id;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
