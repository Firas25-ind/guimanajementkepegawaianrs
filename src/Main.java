// Main.java - Console interface for Pegawai CRUD
import java.util.*;
import java.sql.Date;
import guiadmin.*;
import guipegawai.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PegawaiDAO dao = new PegawaiDAO();
        
        // GUI init
        loginsistem login = new loginsistem();
        login.setVisible(true);
        
        while (true) {
            System.out.println("\n1. Tambah Pegawai\n2. Lihat Semua Pegawai\n3. Ubah Pegawai\n4. Hapus Pegawai\n0. Keluar");
            System.out.print("Pilihan: ");
            int pilih = sc.nextInt(); sc.nextLine();


            if (pilih == 1) {
                Pegawai p = new Pegawai();
                System.out.print("Password: "); p.setPassword(sc.nextLine());
                System.out.print("Alamat: "); p.setAlamat(sc.nextLine());
                System.out.print("Nama: "); p.setNama(sc.nextLine());
                System.out.print("Email: "); p.setEmail(sc.nextLine());
                System.out.print("No Telepon: "); p.setNoTelepon(sc.nextLine());
                System.out.print("Tanggal Masuk (yyyy-mm-dd): ");
                p.setTanggalMasuk(Date.valueOf(sc.nextLine()));
                System.out.print("Jabatan: "); p.setJabatan(sc.nextLine());
                dao.create(p);

            } else if (pilih == 2) {
                List<Pegawai> list = dao.readAll();
                for (Pegawai p : list) {
                    System.out.println(p.getId() + ". " + p.getNama() +
                        " | Email: " + p.getEmail() +
                        " | Telp: " + p.getNoTelepon() +
                        " | Masuk: " + p.getTanggalMasuk() +
                        " | Jabatan: " + p.getJabatan());
                }

            } else if (pilih == 3) {
                System.out.print("ID Pegawai yang ingin diubah: ");
                int id = sc.nextInt(); sc.nextLine();
                Pegawai p = new Pegawai();
                p.setId(id);
                System.out.print("Password: "); p.setPassword(sc.nextLine());
                System.out.print("Alamat: "); p.setAlamat(sc.nextLine());
                System.out.print("Nama: "); p.setNama(sc.nextLine());
                System.out.print("Email: "); p.setEmail(sc.nextLine());
                System.out.print("No Telepon: "); p.setNoTelepon(sc.nextLine());
                System.out.print("Tanggal Masuk (yyyy-mm-dd): ");
                p.setTanggalMasuk(Date.valueOf(sc.nextLine()));
                System.out.print("Jabatan: "); p.setJabatan(sc.nextLine());
                dao.update(p);

            } else if (pilih == 4) {
                System.out.print("ID Pegawai yang ingin dihapus: ");
                int id = sc.nextInt();
                dao.delete(id);

            } else if (pilih == 0) {
                break;
            }
        }

        sc.close();
    }
}
