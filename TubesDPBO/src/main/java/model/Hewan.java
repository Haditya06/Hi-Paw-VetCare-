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
    private String username;
    
    public Hewan(String namaHewan,String jenis,int umur, String username) {
        this.namaHewan = namaHewan;
        this.jenis = jenis;
        this.umur = umur;
        this.username = username;
    }

    public Hewan(String idHewan,String namaHewan,String jenis,int umur, String username) {
        this.idHewan = idHewan;
        this.namaHewan = namaHewan;
        this.jenis = jenis;
        this.umur = umur;
        this.username = username;
    }
    
    public String getIdHewan() {
        return idHewan;
    }
    public void setIdHewan(String idHewan){
        this.idHewan = idHewan;
    }
    
    public String getNamaHewan() {
        return namaHewan;
    }
    public void setNamaHewan(String namaHewan){
        this.namaHewan = this.namaHewan;
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
    public void setUmur(int umur){
        this.umur = this.umur;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username){
        this.username = this.username;
    }
    
}
