/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
import model.Customer;

/**
 *
 * @author Ray Wishnu
 */
public class CustomerDAO {

    public int insert(Customer c, int idUser) {

    try {
        Connection conn = DatabaseConnection.getConnection();

        String sql = "INSERT INTO customer(id_user, no_hp, alamat) VALUES (?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, idUser);
        ps.setString(2, c.getNoHp());
        ps.setString(3, c.getAlamat());

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

    public Customer getById(int idCustomer) {

    try {
        Connection conn = DatabaseConnection.getConnection();

        String sql = """
            SELECT c.id_customer, c.no_hp, c.alamat,
                   u.username, u.password, u.nama_lengkap
            FROM customer c
            JOIN users u ON c.id_user = u.id_user
            WHERE c.id_customer = ?
        """;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idCustomer);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return new Customer(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("nama_lengkap"),
                    rs.getString("no_hp"),
                    rs.getString("alamat"),
                    rs.getInt("id_customer")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}
}
