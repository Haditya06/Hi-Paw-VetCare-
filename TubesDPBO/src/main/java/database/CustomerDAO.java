/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
import java.util.ArrayList;
import model.Customer;
import database.DatabaseConnection;

/**
 *
 * @author Ray Wishnu
 */
public class CustomerDAO {

    // 🔹 READ ALL
    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> list = new ArrayList<>();

        try {
            Connection conn = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM Customer";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer c = new Customer(
                        rs.getString("no_hp"),
                        rs.getString("alamat"),
                        rs.getInt("id_customer"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nama_lengkap")
                );

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔹 READ BY ID
    public Customer getCustomerById(int id) {
        Customer c = null;

        try {
            Connection conn = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM Customer WHERE id_customer=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Customer(
                        rs.getString("no_hp"),
                        rs.getString("alamat"),
                        rs.getInt("id_customer"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nama_lengkap")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    // 🔹 INSERT
    public void insertCustomer(Customer c) {
        try {
            Connection conn = DatabaseConnection.getConnection();

            String sql = "INSERT INTO Customer (username, nama_lengkap, password, no_hp, alamat) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, c.getUsername());
            ps.setString(2, c.getNamaLengkap());
            ps.setString(3, c.getPassword());
            ps.setString(4, c.getNoHp());
            ps.setString(5, c.getAlamat());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            int idCustomer = -1;

            if (rs.next()) {
                idCustomer = rs.getInt(1);
            }

            System.out.println("ID Customer baru: " + idCustomer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 UPDATE
    public void updateCustomer(Customer c) {
        try {
            Connection conn = DatabaseConnection.getConnection();

            String sql = "UPDATE Customer SET username=?, nama_lengkap=?, password=?, no_hp=?, alamat=? WHERE id_customer=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, c.getUsername());
            ps.setString(2, c.getNamaLengkap());
            ps.setString(3, c.getPassword());
            ps.setString(4, c.getNoHp());
            ps.setString(5, c.getAlamat());
            ps.setInt(6, c.getIdCustomer());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 DELETE
    public void deleteCustomer(int id) {
        try {
            Connection conn = DatabaseConnection.getConnection();

            String sql = "DELETE FROM Customer WHERE id_customer=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔥 BONUS: LOGIN CHECK (PENTING)

}
