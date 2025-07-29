// PegawaiDAO.java - Updated to handle new Pegawai fields
import java.sql.*;
import java.util.*;

public class PegawaiDAO {
    public void create(Pegawai p) {
        String sql = "INSERT INTO pegawai (password, alamat, nama, email, no_telepon, tanggal_masuk, jabatan) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getPassword());
            stmt.setString(2, p.getAlamat());
            stmt.setString(3, p.getNama());
            stmt.setString(4, p.getEmail());
            stmt.setString(5, p.getNoTelepon());
            stmt.setDate(6, p.getTanggalMasuk());
            stmt.setString(7, p.getJabatan());
            stmt.executeUpdate();
            System.out.println("Pegawai ditambahkan.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pegawai> readAll() {
        List<Pegawai> list = new ArrayList<>();
        String sql = "SELECT * FROM pegawai";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pegawai p = new Pegawai(
                    rs.getInt("id_pegawai"),
                    rs.getString("password"),
                    rs.getString("alamat"),
                    rs.getString("nama"),
                    rs.getString("email"),
                    rs.getString("no_telepon"),
                    rs.getDate("tanggal_masuk"),
                    rs.getString("jabatan")
                );
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(Pegawai p) {
        String sql = "UPDATE pegawai SET password=?, alamat=?, nama=?, email=?, no_telepon=?, tanggal_masuk=?, jabatan=? WHERE id_pegawai=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getPassword());
            stmt.setString(2, p.getAlamat());
            stmt.setString(3, p.getNama());
            stmt.setString(4, p.getEmail());
            stmt.setString(5, p.getNoTelepon());
            stmt.setDate(6, p.getTanggalMasuk());
            stmt.setString(7, p.getJabatan());
            stmt.setInt(8, p.getId());
            stmt.executeUpdate();
            System.out.println("Pegawai diperbarui.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM pegawai WHERE id_pegawai=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Pegawai dihapus.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
