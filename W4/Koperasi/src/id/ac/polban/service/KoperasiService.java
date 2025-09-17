package id.ac.polban.service;

import id.ac.polban.model.*;
import java.util.Scanner;

public class KoperasiService {
    private static final Barang[] DAFTAR_BARANG = {
        new BarangAlatTulis("Pulpen", 2000, 100, "Pena"),
        new BarangAlatTulis("Pensil", 1500, 100, "Pensil"),
        new BarangAlatTulis("Pengserut", 2000, 100, "Alat Serut"),
        new BarangAlatTulis("Penghapus", 2000, 100, "Penghapus"),
        new BarangPremium("Tipe-X", 5000, 40, "Correction Pen", true),
        new BarangKertas("HVS A4", 40000, 150, "A4", 500),
        new BarangAlatTulis("Buku Tulis", 4000, 50, "Buku")
    };

    public static void mulaiBelanja() {
        Scanner scanner = new Scanner(System.in);
        Pembelian pembelian = null;
        boolean isMember = false;
        
        // Tanya apakah customer adalah member
        System.out.println("=== SELAMAT DATANG DI KOPERASI ===");
        System.out.print("Apakah Anda member? (y/n): ");
        String jawaban = scanner.nextLine().toLowerCase();
        
        if (jawaban.equals("y") || jawaban.equals("yes")) {
            System.out.print("Masukkan nama member: ");
            String namaMember = scanner.nextLine();
            pembelian = new PembelianMember(namaMember, 0.05); // Diskon member 5%
            isMember = true;
            System.out.println("Selamat datang, " + namaMember + "! Anda mendapat diskon member 5%");
        } else {
            pembelian = new Pembelian();
        }
        
        boolean lanjutBelanja = true;

        while (lanjutBelanja) {
            tampilkanMenu();
            System.out.print("Masukkan pilihan (1-" + (DAFTAR_BARANG.length + 1) + "): ");

            try {
                int pilihan = scanner.nextInt();

                if (pilihan >= 1 && pilihan <= DAFTAR_BARANG.length) {
                    Barang barangDipilih = DAFTAR_BARANG[pilihan - 1];
                    
                    System.out.println("\nBarang dipilih: " + barangDipilih.toString());
                    System.out.print("Masukkan jumlah yang ingin dibeli: ");
                    int jumlah = scanner.nextInt();

                    if (jumlah > 0) {
                        if (barangDipilih.getStok() >= jumlah) {
                            // Tampilkan info diskon jika ada
                            double diskon = barangDipilih.hitungDiskon(jumlah);
                            if (diskon > 0) {
                                System.out.println(">>> Anda mendapat diskon " + String.format("%.0f", diskon * 100) + 
                                                 "% untuk pembelian ini!");
                            }
                            
                            pembelian.tambahBarang(barangDipilih, jumlah);
                            System.out.println(">>> Berhasil menambahkan " + jumlah + " " + 
                                             barangDipilih.getNamaBarang() + " ke keranjang.");
                        }
                    } else {
                        System.out.println(">>> Jumlah harus lebih dari 0!");
                    }
                } else if (pilihan == DAFTAR_BARANG.length + 1) {
                    lanjutBelanja = false;
                    pembelian.tampilkanPembelian();
                    
                    // Tampilkan ringkasan untuk member
                    if (isMember) {
                        System.out.println("\n>>> Terima kasih atas kunjungan Anda sebagai member!");
                        System.out.println(">>> Total penghematan Anda: Rp " + 
                                         String.format("%,d", (int)pembelian.getTotalDiskon()));
                    }
                } else {
                    System.out.println(">>> Pilihan tidak valid!");
                }
            } catch (Exception e) {
                System.out.println(">>> Input tidak valid! Masukkan angka yang benar.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        scanner.close();
    }
    
    private static void tampilkanMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           DAFTAR BARANG KOPERASI");
        System.out.println("=".repeat(50));
        
        for (int i = 0; i < DAFTAR_BARANG.length; i++) {
            Barang barang = DAFTAR_BARANG[i];
            System.out.println((i + 1) + ". " + barang.toString());
            
            // Tampilkan info diskon dengan karakter yang kompatibel
            String infoDiskon = getInfoDiskon(barang);
            if (!infoDiskon.isEmpty()) {
                System.out.println("   [PROMO] " + infoDiskon);
            }
        }
        System.out.println((DAFTAR_BARANG.length + 1) + ". Selesai dan tampilkan total");
        System.out.println("=".repeat(50));
    }
    
    private static String getInfoDiskon(Barang barang) {
        if (barang instanceof BarangAlatTulis) {
            return "Diskon 5% untuk pembelian >= 10 item";
        } else if (barang instanceof BarangKertas) {
            return "Diskon 10% untuk pembelian >= 2 pack";
        } else if (barang instanceof BarangPremium) {
            return "Diskon 3% untuk pembelian >= 3 item";
        }
        return "";
    }
}