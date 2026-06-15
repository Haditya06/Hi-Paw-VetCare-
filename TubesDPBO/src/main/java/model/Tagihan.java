/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
//import java.util.*;
/**
 *
 * @author Dit
 */
public class Tagihan {
    private String idTagihan;
    private Reservasi reservasi;
    private ArrayList<DetailTransaksi> daftarDetail; // untuk obat kita ni
    private ArrayList<Layanan> daftarLayanan;
    private double totalBiaya; 
    private boolean statusBayar;
    
    public Tagihan(String idTagihan,Reservasi reservasi){
        this.idTagihan = idTagihan;
        this.reservasi = reservasi;
        this.daftarDetail = new ArrayList<>();
        this.daftarLayanan = new ArrayList<>();
        this.totalBiaya = 0;
        this.statusBayar = false;
    }
    
    public Tagihan(String idTagihan,Reservasi reservasi, ArrayList<Layanan> daftarLayanan){
        this.idTagihan = idTagihan;
        this.reservasi = reservasi;
        this.daftarDetail = new ArrayList<>();
        this.daftarLayanan = daftarLayanan != null ? daftarLayanan: new ArrayList<>();
        this.totalBiaya = 0;
        this.statusBayar = false;
        
        for(Layanan layanan : this.daftarLayanan){
            this.totalBiaya += layanan.getHarga();
        }
    }
    
    public void tambahDetail(DetailTransaksi detail){ //class detailTransaksi
        daftarDetail.add(detail);
        totalBiaya += detail.hitungSubtotal(); 
    }
    
    public void tambahLayanan(Layanan layanan){ //class layanan
        daftarLayanan.add(layanan);
        totalBiaya += layanan.getHarga();
    }
    
    public double hitungTotalBiaya(){
        return totalBiaya;
    }
    
    public void setLunas(){
        this.statusBayar = true;
    }
    
    
    public String getIdTagihan(){
        return idTagihan;
    }
    
    public Reservasi getReservasi(){
        return reservasi;
    }
    
    public ArrayList<DetailTransaksi> getDaftarDetail(){
        return daftarDetail;
    }
    
    public ArrayList<Layanan> getDaftarLayanan() {
        return daftarLayanan;
    }
    
    public double getTotalBiaya(){
        return totalBiaya;
    }
    
    public boolean getStatusBayar(){
        return statusBayar;
    }
    
    // getPelanggan dari class Reservasi
    @Override
    public String toString(){
        String namaPelanggan = (reservasi != null && reservasi.getPelanggan() != null) ? reservasi.getPelanggan().getNamaLengkap() : "Unknown";
        
        String status = statusBayar ? "Ya" : "Tidak";
        return "[Tagihan] ID: "+idTagihan + " | Pelanggan: "+namaPelanggan + " | Total: Rp "+totalBiaya + " | Lunas: "+status;
    }

}
