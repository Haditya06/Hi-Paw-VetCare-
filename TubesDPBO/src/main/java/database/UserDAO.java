/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
import model.User;
import model.Customer;
import model.Dokter;

/**
 *
 * @author Ray Wishnu
 */
public class UserDAO {

    public boolean insert(User user) {

        try {
            Connection conn = DatabaseConnection.getConnection();

            String sql = "INSERT INTO users(username, password, nama_lengkap, role) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNamaLengkap());
            ps.setString(4, user.getRole()); // ✔ hasil override

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public User login(String username, String password) {

    try {
        Connection conn = DatabaseConnection.getConnection();

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            String role = rs.getString("role");

            if (role.equalsIgnoreCase("CUSTOMER")) {
                return new Customer(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nama_lengkap"),
                        "",
                        "",
                        0
                );
            }

            if (role.equalsIgnoreCase("DOKTER")) {
                return new Dokter(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nama_lengkap"),
                        "",
                        ""
                );
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}
    
    public int insertAndReturnId(User user) {

    try {
        Connection conn = DatabaseConnection.getConnection();

        String sql = "INSERT INTO users(username, password, nama_lengkap, role) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getNamaLengkap());
        ps.setString(4, user.getRole());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return -1;
}
    
}
