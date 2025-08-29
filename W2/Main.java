import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pembelian pembelian = new Pembelian();

        Barang pulpen = new Barang("Pulpen", 2000, 100);
        Barang pensil = new Barang("Pensil", 1500, 100);
        Barang pengserut = new Barang("Pengserut", 2000, 100);
        Barang penghapus = new Barang("Penghapus", 2000, 100);
        Barang tipex = new Barang("Tipe-X", 5000, 40);
        Barang HVS = new Barang("HVS", 100, 15000);
        Barang buku_tulis = new Barang("Buku Tulis", 4000, 50);

        Barang[] daftarBarang = {pulpen, pensil, pengserut, penghapus, tipex, HVS, buku_tulis};

        boolean lanjutBelanja = true;

        while (lanjutBelanja) {
            System.out.println("\n=== Koperasi ===");
            System.out.println("Pilih barang yang mau dibeli:");
            for (int i = 0; i < daftarBarang.length; i++) {
                System.out.println((i + 1) + ". " + daftarBarang[i].getNamaBarang() + 
                    " - Rp " + daftarBarang[i].getHarga() + 
                    " (Stok: " + daftarBarang[i].getStok() + ")");
            }
            System.out.println((daftarBarang.length + 1) + ". Selesai dan tampilkan total");
            System.out.print("Masukkan pilihan (1-" + (daftarBarang.length + 1) + "): ");

            int pilihan = scanner.nextInt();

            if (pilihan >= 1 && pilihan <= daftarBarang.length) {
                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                int jumlah = scanner.nextInt();

                if (jumlah > 0) {
                    pembelian.tambahBarang(daftarBarang[pilihan - 1], jumlah);
                } else {
                    System.out.println("Jumlah harus lebih dari 0!");
                }
            } else if (pilihan == daftarBarang.length + 1) {
                lanjutBelanja = false;
                pembelian.tampilkanPembelian();
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }

        scanner.close();
    }
}