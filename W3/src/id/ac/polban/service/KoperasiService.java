package id.ac.polban.service;

import id.ac.polban.model.Barang;
import id.ac.polban.model.Pembelian;
import java.util.Scanner;

public class KoperasiService {
    private static final Barang[] DAFTAR_BARANG = {
        new Barang("Pulpen", 2000, 100),
        new Barang("Pensil", 1500, 100),
        new Barang("Pengserut", 2000, 100),
        new Barang("Penghapus", 2000, 100),
        new Barang("Tipe-X", 5000, 40),
        new Barang("HVS", 100, 15000),
        new Barang("Buku Tulis", 4000, 50)
    };

    public static void mulaiBelanja() {
        Scanner scanner = new Scanner(System.in);
        Pembelian pembelian = new Pembelian();
        boolean lanjutBelanja = true;

        while (lanjutBelanja) {
            System.out.println("\n=== Koperasi ===");
            System.out.println("Pilih barang yang mau dibeli:");
            for (int i = 0; i < DAFTAR_BARANG.length; i++) {
                System.out.println((i + 1) + ". " + DAFTAR_BARANG[i].getNamaBarang() + 
                    " - Rp " + DAFTAR_BARANG[i].getHarga() + 
                    " (Stok: " + DAFTAR_BARANG[i].getStok() + ")");
            }
            System.out.println((DAFTAR_BARANG.length + 1) + ". Selesai dan tampilkan total");
            System.out.print("Masukkan pilihan (1-" + (DAFTAR_BARANG.length + 1) + "): ");

            int pilihan = scanner.nextInt();

            if (pilihan >= 1 && pilihan <= DAFTAR_BARANG.length) {
                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                int jumlah = scanner.nextInt();

                if (jumlah > 0) {
                    pembelian.tambahBarang(DAFTAR_BARANG[pilihan - 1], jumlah);
                } else {
                    System.out.println("Jumlah harus lebih dari 0!");
                }
            } else if (pilihan == DAFTAR_BARANG.length + 1) {
                lanjutBelanja = false;
                pembelian.tampilkanPembelian();
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }

        scanner.close();
    }
}