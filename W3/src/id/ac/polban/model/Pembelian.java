package id.ac.polban.model;

import java.util.ArrayList;
import java.util.List;

public class Pembelian {
    private List<Barang> daftarBarang;
    private List<Integer> jumlahBarang;
    private int totalHarga;

    public Pembelian() {
        daftarBarang = new ArrayList<>();
        jumlahBarang = new ArrayList<>();
        totalHarga = 0;
    }

    public void tambahBarang(Barang barang, int jumlah) {
        if (barang.getStok() >= jumlah) {
            for (int i = 0; i < daftarBarang.size(); i++) {
                if (daftarBarang.get(i) == barang) {
                    jumlahBarang.set(i, jumlahBarang.get(i) + jumlah);
                    totalHarga += barang.getHarga() * jumlah;
                    barang.kuranginStok(jumlah);
                    return;
                }
            }
            daftarBarang.add(barang);
            jumlahBarang.add(jumlah);
            totalHarga += barang.getHarga() * jumlah;
            barang.kuranginStok(jumlah);
        }
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void tampilkanPembelian() {
        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println(daftarBarang.get(i).getNamaBarang() + " x " + jumlahBarang.get(i) + 
                " = Rp " + (daftarBarang.get(i).getHarga() * jumlahBarang.get(i)));
        }
        System.out.println("Total Harga: Rp " + totalHarga);
    }
}