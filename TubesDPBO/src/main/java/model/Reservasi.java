/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDateTime;
/**
 *
 * @author Dit
 */
public class Reservasi {
    private String idReservasi;
    private LocalDateTime tanggalWaktu;
    private Customer customer;
    private Hewan hewan;
    private String status;
    public Reservasi() {
    }
    public Reservasi(String idReservasi,LocalDateTime tanggalWaktu,Customer customer,Hewan hewan) {
        this.idReservasi = idReservasi;
        this.tanggalWaktu = tanggalWaktu;
        this.customer = customer;
        this.hewan = hewan;
        status = "MENUNGGU";
    }

    public void buatReservasi() {
        System.out.println("Reservasi berhasil dibuat");
    }

    public void updateStatus(String statusBaru) {
        status = statusBaru;
        System.out.println("Status berubah menjadi "+ statusBaru);
    }

    public String getStatus() {
        return status;
    }
}
