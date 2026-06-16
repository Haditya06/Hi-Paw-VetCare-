/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dit
 */
public class Customer extends User {

    private int idCustomer;
    private String noHp;
    private String alamat;

    public Customer(int idCustomer, String noHp, String alamat, String username, String password, String namaLengkap){

        super(username, password, namaLengkap, Role.CUSTOMER);
        this.idCustomer = idCustomer;
        this.noHp = noHp;
        this.alamat = alamat;
    }

    public Customer(String noHp, String alamat, String username, String password, String namaLengkap) {

        super(username, password, namaLengkap, Role.CUSTOMER);
        this.noHp = noHp;
        this.alamat = alamat;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
