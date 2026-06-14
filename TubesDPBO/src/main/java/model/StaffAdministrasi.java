/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dit
 */
public class StaffAdministrasi extends User {
    private String idStaff;
    private String shiftKerja;

    public StaffAdministrasi() {
    }
    public StaffAdministrasi(String username,String password,String namaLengkap,String idStaff,String shiftKerja) {
        super(username, password, namaLengkap);
        this.idStaff = idStaff;
        this.shiftKerja = shiftKerja;
    }
    public String getIdStaff() {
        return idStaff;
    }
    public String getShiftKerja() {
        return shiftKerja;
    }
}
