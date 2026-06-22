/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author attau
 */
import modul.UserItem;
import service.UserService;
import java.util.List;

public class UserController {

    private final UserService service = new UserService();

    // Menampilkan semua user
    public List<UserItem> getAllUser() {
        return service.getAllUser();
    }

    // Mencari user berdasarkan nama, username, atau role
    public List<UserItem> searchUser(String keyword) {
        return service.searchUser(keyword);
    }

    // Ambil ID user berdasarkan username
    public int getIdByUsername(String username) {
        return service.getIdByUsername(username);
    }

    // Tambah user baru
    public void addUser(UserItem user) {
        service.addUser(user);
    }

    // Update user
    public void updateUser(UserItem user, String newPassword) {
        service.updateUser(user, newPassword);
    }

    // Hapus user
    public void deleteUser(int id) {
        service.deleteUser(id);
    }
}