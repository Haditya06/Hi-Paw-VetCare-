/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.logic;
import model.Tagihan;
import model.*;
import util.KuitansiGenerator;
/**
 *
 * @author Dit
 */
public class Pembayaran {
    private double totalPemasukan;
    
    public Pembayaran(){
        this.totalPemasukan=0;
    }
    
    
    
    public boolean prosesBayar(Tagihan tagihan, double uangDibayar){
        double totalBiaya = tagihan.hitungTotalBiaya();
        
        if(uangDibayar >= totalBiaya){
            tagihan.setLunas();
            totalPemasukan += totalBiaya;
            double kembalian = hitungKembalian(uangDibayar, totalBiaya);
            
            System.out.println("======================================");
            System.out.println("[Pembayaran] Pembayaran Berhasil");
            System.out.println(" Tagihan ID  : "+tagihan.getIdTagihan());
            System.out.println(" Total Biaya : " + formatRupiah(totalBiaya));  
            System.out.println(" Uang Dibayar : " + formatRupiah(uangDibayar));
            System.out.println(" Kembalian : "+ formatRupiah(kembalian));
            System.out.println("========================================");
            return true;
        }else{
            double kurang = totalBiaya - uangDibayar;
            System.out.println("[Pembayaran] Gagal: Uang dibayar tidak mencukupi");
            System.out.println(" Kurang : "+ formatRupiah(kurang));
            return false;
        }
    }
    
    public double hitungKembalian(double uangDibayar, double totalBiaya){
        double kembalian = uangDibayar - totalBiaya;
        if(kembalian < 0){
            return 0;
        }
        return kembalian;
    }
    
    public String cetakStruk(Tagihan tagihan){
        String hasil = "";
        String namaPelanggan = "Unknow";
        
        if(tagihan.getReservasi() != null && tagihan.getReservasi().getPelanggan() != null){
            namaPelanggan = tagihan.getReservasi().getPelanggan().getNamaLengkap();
        }
        
        hasil += "============================================\n";
        hasil += "         HI PAW VETCARE                     \n";
        hasil += "============================================\n";
        hasil += "ID Tagihan  : " + tagihan.getIdTagihan() + "\n";
        hasil += "Pelanggan   : " + namaPelanggan + "         \n";
        hasil += "--------------------------------------------\n"; 
        
        hasil += "RINCIAN OBAT: \n";
        for(DetailTransaksi detail : tagihan.getDaftarDetail()){
            String namaObat = "Obat Tidak Dikenal";
            if(detail.getObat() != null){
                namaObat = detail.getObat().getNamaObat();
            }
            hasil += "- " + namaObat + " x" + detail.getJumlah() + " = " + formatRupiah(detail.hitungSubtotal()) + "\n";
        }
        
        hasil += "\nRINCIAN LAYANAN:\n";    
        for (Layanan layanan : tagihan.getDaftarLayanan()){
            hasil += "- " + layanan.getNamaLayanan() + " = " + layanan.getHarga() + "\n";
        }
        
        hasil += "--------------------------------------------\n";
        hasil += "TOTAL : " + tagihan.hitungTotalBiaya() + "\n";
        hasil += "============================================\n";
        
        if(tagihan.getStatusBayar()){
            hasil += "Status : Lunas \n";
        }else{
            hasil += "Status: Belum Lunas\n";
        }
        
        return hasil;
    }
    
    public double getTotalPemasukan(){
        return totalPemasukan;
    }


}
