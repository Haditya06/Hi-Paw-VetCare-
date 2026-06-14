/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author syahrilfarhan
 */
public class DetailTransaksi {
    private String idDetail;
    private Obat obat;
    private int jumlah;
    private double hargaSatuan;
    
    
    public DetailTransaksi(String idDetail, Obat obat, int jumlah, double hargaSatuan){
        this.idDetail = idDetail;
        this.obat = obat;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
    }
    
    public double hitungSubtotal(){
        return jumlah * hargaSatuan;
    }
    
    public String getIdDetail() {
        return idDetail;
    }
    
    public Obat getObat(){
        return obat;
    }
    
    public int getJumlah(){
        return jumlah;
    }
    
    public double getHargaSatuan(){
        return hargaSatuan;
    }
    
    @Override
    public String toString(){
        String namaObat = obat != null ? obat.getNamaObat() : null;
        return "[Detail] ID: "+idDetail+ " | Obat: "+namaObat + " | Jumlah: "+ jumlah+" | Harga: Rp. "+hargaSatuan+ " | SubTotal: Rp. "+hitungSubtotal();
    }
}
