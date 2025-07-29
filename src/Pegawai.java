/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
import java.sql.Date;
import java.time.LocalDate;

public class Pegawai {
    private int id_pegawai;
    private String password;
    private String alamat;
    private String nama;
    private String email;
    private String noTelepon;
    private Date tanggalMasuk;
    private String jabatan;

    public Pegawai() {}
    public Pegawai(
        int id_pegawai, 
        String password, 
        String alamat,
        String nama,
        String email,
        String noTelepon,
        Date tanggalMasuk,
        String jabatan
        ){
        this.id_pegawai = id_pegawai;
        this.password = password;
        this.alamat = alamat;
        this.nama = nama;
        this.email = email;
        this.noTelepon = noTelepon;
    this.tanggalMasuk = tanggalMasuk;
        this.jabatan = jabatan;
    }

    public int getId() { return id_pegawai; }
    public String getPassword() { return password; }
    public String getAlamat() { return alamat; }
    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getNoTelepon() { return noTelepon; }
    public Date getTanggalMasuk() { return tanggalMasuk; }
    public String getJabatan() { return jabatan; }

    public void setId(int id_pegawai) { this.id_pegawai = id_pegawai; }
    public void setPassword(String password) { this.password = password; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public void setNama(String nama) { this.nama = nama; }
    public void setEmail(String email) { this.email = email; }
    public void setNoTelepon(String noTelepon) { this.noTelepon = noTelepon; }
    public void setTanggalMasuk(Date tanggalMasuk) { this.tanggalMasuk = tanggalMasuk; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }
}


