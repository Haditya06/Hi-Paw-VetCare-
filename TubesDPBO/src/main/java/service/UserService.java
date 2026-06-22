/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author attau
 */
import modul.UserItem;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static final String URL = "jdbc:mysql://localhost:3306/klinik";
    private static final String USER = "root";
    private static final String PASS = "";

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // =============================
    // GET ALL USER
    // =============================

    public List<UserItem> getAllUser() {

        List<UserItem> list = new ArrayList<>();

        String sql = """
                SELECT
                    id_user,
                    nama,
                    username,
                    role
                FROM user
                ORDER BY id_user ASC
                """;

        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                list.add(new UserItem(
                        rs.getInt("id_user"),
                        rs.getString("nama"),
                        rs.getString("username"),
                        rs.getString("role")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Gagal load user : " + e.getMessage(), e);
        }

        return list;
    }

    // =============================
    // SEARCH USER
    // =============================

    public List<UserItem> searchUser(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllUser();
        }

        List<UserItem> list = new ArrayList<>();

        String sql = """
                SELECT
                    id_user,
                    nama,
                    username,
                    role
                FROM user
                WHERE nama LIKE ?
                   OR username LIKE ?
                   OR role LIKE ?
                ORDER BY id_user ASC
                """;

        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            String key = "%" + keyword.trim() + "%";

            ps.setString(1, key);
            ps.setString(2, key);
            ps.setString(3, key);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new UserItem(
                        rs.getInt("id_user"),
                        rs.getString("nama"),
                        rs.getString("username"),
                        rs.getString("role")
                ));
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Gagal search user : " + e.getMessage(), e);
        }

        return list;
    }

    // =============================
    // GET ID BY USERNAME
    // =============================

    public int getIdByUsername(String username) {

        String sql = "SELECT id_user FROM user WHERE username = ?";

        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_user");
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Gagal ambil ID User : " + e.getMessage(), e);
        }

        return -1;
    }

    // =============================
    // ADD USER
    // =============================

    public void addUser(UserItem user) {

        validateUser(
                user.getNama(),
                user.getUsername(),
                user.getPassword()
        );

        if (isUsernameTaken(user.getUsername())) {
            throw new RuntimeException("Username sudah digunakan!");
        }

        String hash = BCrypt.hashpw(
                user.getPassword(),
                BCrypt.gensalt()
        );

        String sql = """
                INSERT INTO user
                (
                    nama,
                    username,
                    password,
                    role
                )
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, user.getNama());
            ps.setString(2, user.getUsername());
            ps.setString(3, hash);
            ps.setString(4, user.getRole());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(
                    "Gagal tambah user : " + e.getMessage(), e);
        }
    }

    // =============================
    // UPDATE USER
    // =============================

    public void updateUser(UserItem user, String newPassword) {

        validateNama(user.getNama());
        validateUsername(user.getUsername());

        try (Connection conn = getConnection()) {

            PreparedStatement ps;

            if (newPassword != null && !newPassword.isEmpty()) {

                validatePassword(newPassword);

                String hash = BCrypt.hashpw(
                        newPassword,
                        BCrypt.gensalt()
                );

                ps = conn.prepareStatement("""
                    UPDATE user
                    SET nama=?,
                        username=?,
                        password=?,
                        role=?
                    WHERE id_user=?
                """);

                ps.setString(1, user.getNama());
                ps.setString(2, user.getUsername());
                ps.setString(3, hash);
                ps.setString(4, user.getRole());
                ps.setInt(5, user.getId());

            } else {

                ps = conn.prepareStatement("""
                    UPDATE user
                    SET nama=?,
                        username=?,
                        role=?
                    WHERE id_user=?
                """);

                ps.setString(1, user.getNama());
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getRole());
                ps.setInt(4, user.getId());
            }

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            throw new RuntimeException(
                    "Gagal update user : " + e.getMessage(), e);
        }
    }

    // =============================
    // DELETE USER
    // =============================

    public void deleteUser(int id) {

        String sql = "DELETE FROM user WHERE id_user = ?";

        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(
                    "Gagal hapus user : " + e.getMessage(), e);
        }
    }

    // =============================
    // VALIDASI
    // =============================

    private void validateUser(
            String nama,
            String username,
            String password
    ) {
        validateNama(nama);
        validateUsername(username);
        validatePassword(password);
    }

    private void validateNama(String nama) {

        if (nama == null || nama.trim().isEmpty()) {
            throw new RuntimeException("Nama tidak boleh kosong.");
        }
    }

    private void validateUsername(String username) {

        if (username == null || username.trim().isEmpty()) {
            throw new RuntimeException("Username tidak boleh kosong.");
        }

        if (username.length() < 3) {
            throw new RuntimeException("Username minimal 3 karakter.");
        }
    }

    private void validatePassword(String password) {

        if (password == null || password.isEmpty()) {
            throw new RuntimeException("Password tidak boleh kosong.");
        }

        if (password.length() < 6) {
            throw new RuntimeException("Password minimal 6 karakter.");
        }
    }

    private boolean isUsernameTaken(String username) {

        String sql = """
                SELECT id_user
                FROM user
                WHERE username = ?
                """;

        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException(
                    "Gagal cek username : " + e.getMessage(), e);
        }
    }
}
