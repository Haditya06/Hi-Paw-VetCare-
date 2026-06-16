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
    private int idHewan;
    private String namaHewan;
    private String jenis;
    private int umur;
    private int idCustomer;
    
    public Hewan(int idHewan,String namaHewan,String jenis,int umur, int idCustomer) {
        this.idHewan = idHewan;
        this.namaHewan = namaHewan;
        this.jenis = jenis;
        this.umur = umur;
        this.idCustomer = idCustomer;
    }
    
    public Hewan(String namaHewan,String jenis,int umur, int idCustomer) {
        this.namaHewan = namaHewan;
        this.jenis = jenis;
        this.umur = umur;
        this.idCustomer = idCustomer;
    }
    
    public int getIdHewan() {
        return idHewan;
    }
    public void setIdHewan(int idHewan){
        this.idHewan = idHewan;
    }
    
    public String getNamaHewan() {
        return namaHewan;
    }
    
    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis){
        this.jenis = jenis;
    }
    
    public int getUmur() {
        return umur;
    }
    
    public int getIdCustomer() {
        return idCustomer;
    }
    
}
