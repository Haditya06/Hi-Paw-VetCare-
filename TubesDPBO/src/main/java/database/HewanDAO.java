/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.*;
import java.util.ArrayList;
import model.Hewan;

/**
 *
 * @author Ray Wishnu
 */
public class HewanDAO {
    
     private Connection conn;

    public HewanDAO() {
        conn = DatabaseConnection.getConnection();
    }

    // =====================
    // 1. INSERT PET
    // =====================
    public void insertHewan(Hewan p) {

        try {

            String sql = "INSERT INTO Hewan (username, nama_hewan, jenis, umur) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getUsername());
            ps.setString(2, p.getNamaHewan());
            ps.setString(3, p.getJenis());
            ps.setInt(4, p.getUmur());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Hewan> getAllHewan() {

        ArrayList<Hewan> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM Hewan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Hewan h = new Hewan(
                        rs.getInt("id_hewan"),
                        rs.getString("nama_hewan"),
                        rs.getString("jenis"),
                        rs.getInt("umur")
                );

                list.add(h);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // =========================
    // 3. DELETE HEWAN
    // =========================
    public void deleteHewan(int idHewan) {

        try {

            String sql = "DELETE FROM Hewan WHERE id_hewan=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idHewan);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
