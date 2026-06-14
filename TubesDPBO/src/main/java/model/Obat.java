/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dit
 */
public class Obat {
    private String idObat;
    private String namaObat;
    private int stok;
    private double harga;

    public Obat() {
    }
    public Obat(String idObat,String namaObat,int stok,double harga) {
        this.idObat = idObat;
        this.namaObat = namaObat;
        this.stok = stok;
        this.harga = harga;
    }
    public void kurangiStok(int jumlah) {

        if (stok >= jumlah) {
            stok -= jumlah;
        } else {
            System.out.println("Stok tidak cukup");
        }
    }
    public String getNamaObat() {
        return namaObat;
    }
    public double getHarga() {
        return harga;
    }
}
