/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dit
 */
public class Hewan {
    private String idHewan;
    private String namaHewan;
    private String jenis;
    private int umur;
    private Customer pemilik;

    public Hewan(String idHewan,String namaHewan,String jenis,int umur,Customer pemilik) {
        this.idHewan = idHewan;
        this.namaHewan = namaHewan;
        this.jenis = jenis;
        this.umur = umur;
        this.pemilik = pemilik;
    }
    public String getIdHewan() {
        return idHewan;
    }
    public String getNamaHewan() {
        return namaHewan;
    }
    public String getJenis() {
        return jenis;
    }
    public int getUmur() {
        return umur;
    }
    public Customer getPemilik() {
        return pemilik;
    }
}
