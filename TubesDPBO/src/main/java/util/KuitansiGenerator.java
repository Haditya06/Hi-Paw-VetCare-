/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import model.DetailTransaksi;
import model.Layanan;
import model.Tagihan;

/**
 *
 * @author syahrilfarhan
 */
public class KuitansiGenerator {
    public static String generateKuitansi(
        Tagihan tagihan) {

        StringBuilder sb =new StringBuilder();
        sb.append("========================\n");
        sb.append("     HI-PAW VETCARE\n");
        sb.append("========================\n");

        sb.append("ID Tagihan : ").append(tagihan.getIdTagihan()).append("\n\n");
        if (!tagihan.getDaftarLayanan().isEmpty()) {
            sb.append("LAYANAN\n");
            for (Layanan layanan :tagihan.getDaftarLayanan()) {
                sb.append("- ").append(layanan.getNamaLayanan()).append(" : Rp ").append(layanan.getHarga()).append("\n");
            }
            sb.append("\n");
        }

        if (!tagihan.getDaftarDetail().isEmpty()) {
            sb.append("OBAT\n");
            for (DetailTransaksi detail : tagihan.getDaftarDetail()) {
                sb.append("- ").append(detail.getObat().getNamaObat()).append(" x ").append(detail.getJumlah()).append(" = Rp ").append(detail.hitungSubtotal()).append("\n");
            }
        }
        sb.append("\n------------------------\n");
        sb.append("TOTAL : Rp ").append(tagihan.hitungTotalBiaya()).append("\n");
        sb.append("========================");
        return sb.toString();
    }
}
