package id.ac.polban.model;

import java.util.ArrayList;
import java.util.List;

// Base class untuk pembelian
public class Pembelian {
    protected List<Barang> daftarBarang;
    protected List<Integer> jumlahBarang;
    protected double totalHarga;
    protected double totalDiskon;

    public Pembelian() {
        daftarBarang = new ArrayList<>();
        jumlahBarang = new ArrayList<>();
        totalHarga = 0;
        totalDiskon = 0;
    }

    public void tambahBarang(Barang barang, int jumlah) {
        if (barang.getStok() >= jumlah) {
            // Cek apakah barang sudah ada dalam daftar
            for (int i = 0; i < daftarBarang.size(); i++) {
                if (daftarBarang.get(i) == barang) {
                    // Update jumlah barang yang sudah ada
                    int jumlahBaru = jumlahBarang.get(i) + jumlah;
                    jumlahBarang.set(i, jumlahBaru);
                    
                    // Hitung ulang harga dengan diskon
                    double hargaItem = hitungHargaItem(barang, jumlah);
                    totalHarga += hargaItem;
                    
                    barang.kuranginStok(jumlah);
                    return;
                }
            }
            
            // Tambah barang baru
            daftarBarang.add(barang);
            jumlahBarang.add(jumlah);
            
            double hargaItem = hitungHargaItem(barang, jumlah);
            totalHarga += hargaItem;
            
            barang.kuranginStok(jumlah);
        } else {
            System.out.println("Stok tidak mencukupi! Stok tersedia: " + barang.getStok());
        }
    }
    
    // Method yang dapat di-override untuk menghitung harga item
    protected double hitungHargaItem(Barang barang, int jumlah) {
        double hargaDasar = barang.getHarga() * jumlah;
        double diskon = barang.hitungDiskon(jumlah);
        double potonganHarga = hargaDasar * diskon;
        totalDiskon += potonganHarga;
        return hargaDasar - potonganHarga;
    }

    public double getTotalHarga() {
        return totalHarga;
    }
    
    public double getTotalDiskon() {
        return totalDiskon;
    }

    public void tampilkanPembelian() {
        System.out.println("\n=== STRUK PEMBELIAN ===");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            int jumlah = jumlahBarang.get(i);
            double hargaDasar = barang.getHarga() * jumlah;
            double diskon = barang.hitungDiskon(jumlah);
            double hargaSetelahDiskon = hargaDasar * (1 - diskon);
            
            System.out.println(barang.getNamaBarang() + " x " + jumlah);
            System.out.println("  Harga: Rp " + String.format("%,d", (int)hargaDasar));
            if (diskon > 0) {
                System.out.println("  Diskon: " + String.format("%.0f", diskon * 100) + "% = Rp " + 
                                 String.format("%,d", (int)(hargaDasar * diskon)));
                System.out.println("  Subtotal: Rp " + String.format("%,d", (int)hargaSetelahDiskon));
            } else {
                System.out.println("  Subtotal: Rp " + String.format("%,d", (int)hargaDasar));
            }
            System.out.println();
        }
        
        if (totalDiskon > 0) {
            System.out.println("Total Diskon: Rp " + String.format("%,d", (int)totalDiskon));
        }
        System.out.println("Total Harga: Rp " + String.format("%,d", (int)totalHarga));
        System.out.println("========================");
    }
}