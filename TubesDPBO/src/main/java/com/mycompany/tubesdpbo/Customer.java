/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubesdpbo;

/**
 *
 * @author Dit
 */
public class Customer extends User {
    private String noHP;
    private String alamat;
    public Customer(String username, String password, String nama, String noHP, String alamat){
        super(username, password, nama);
        this.noHP = noHP;
        this.alamat = alamat;
    }
    public String getNoHP(){
        return noHP;
    }
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    public void kirimNotifikasi(String pesan){
        System.out.print("Notifikasi untuk Customer: " + pesan);
    }
    @Override
    public String toString(){
        return "Customer{" + "noHP='" + noHP + '\'' + ", alamat='" + alamat + '\'' + '}';
    }
    
}
