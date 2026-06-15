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

    // =========================
    // 1. INSERT HEWAN
    // =========================
    public void insertHewan(Hewan h) {
        try {
            String sql = "INSERT INTO Hewan (username, nama_hewan, jenis, umur) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, h.getUsername());
            ps.setString(2, h.getNamaHewan());
            ps.setString(3, h.getJenis());
            ps.setInt(4, h.getUmur());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // 2. GET ALL HEWAN
    // =========================
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
                        rs.getInt("umur"),
                        rs.getString("username")
                );

                list.add(h);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // =========================
    // 3. GET HEWAN BY USERNAME
    // =========================
    public ArrayList<Hewan> getHewanByUsername(String username) {

        ArrayList<Hewan> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Hewan WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Hewan h = new Hewan(
                        rs.getInt("id_hewan"),
                        rs.getString("nama_hewan"),
                        rs.getString("jenis"),
                        rs.getInt("umur"),
                        rs.getString("username")
                );

                list.add(h);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // =========================
    // 4. UPDATE HEWAN
    // =========================
    public void updateHewan(Hewan h) {

        try {
            String sql = "UPDATE Hewan SET nama_hewan=?, jenis=?, umur=? WHERE id_hewan=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, h.getNamaHewan());
            ps.setString(2, h.getJenis());
            ps.setInt(3, h.getUmur());
            ps.setInt(4, h.getIdHewan());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
