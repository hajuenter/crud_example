package com.example.crud_example.Model;

// model digunakan untuk setter dan getter dari data api yang dikirim
public class ModelData {
    private int id_karakter;
    private String nama, jenis_kelamin;

    public int getId_karakter() {
        return id_karakter;
    }

    public void setId_karakter(int id_karakter) {
        this.id_karakter = id_karakter;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
}
