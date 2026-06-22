/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul;

/**
 *
 * @author attau
 */

public class SessionUser {

    public static int id;
    public static String nama;
    public static String username;
    public static String role;
    public SessionUser(int id, String nama, String username, String role){
        SessionUser.id = id;
        SessionUser.nama = nama;
        SessionUser.username = username;
        SessionUser.role = role;
    }
    public static void logout() {
        id = 0;
        nama = null;
        username = null;
        role = null;
    }
}
