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
    private String username;
    
    public Hewan(int idHewan,String namaHewan,String jenis,int umur, String username) {
        this.idHewan = idHewan;
        this.namaHewan = namaHewan;
        this.jenis = jenis;
        this.umur = umur;
        this.username = username;
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
    
    public String getUsername() {
        return username;
    }
    
}
