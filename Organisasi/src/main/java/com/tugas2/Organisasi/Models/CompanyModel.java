package com.tugas2.Organisasi.Models;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class CompanyModel {
    public Long id;
    public String nama;
    public String alamat;

    public CompanyModel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
