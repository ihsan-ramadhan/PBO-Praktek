package id.ac.polban.model;

// Base class untuk semua barang
public class Barang {
    protected String namaBarang;
    protected int harga;
    protected int stok;
    protected String kategori;

    public Barang(String namaBarang, int harga, int stok) {
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
        this.kategori = "Umum";
    }
    
    public Barang(String namaBarang, int harga, int stok, String kategori) {
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }
    
    public String getKategori() {
        return kategori;
    }

    public void kuranginStok(int jumlah) {
        stok = getStok() - jumlah;
    }
    
    // Method yang bisa di-override oleh subclass
    public double hitungDiskon(int jumlah) {
        return 0.0; // Default: tidak ada diskon
    }
    
    public String getInfoTambahan() {
        return "Kategori: " + kategori;
    }
    
    @Override
    public String toString() {
        return namaBarang + " - Rp " + String.format("%,d", harga) + 
               " (Stok: " + stok + ") - " + getInfoTambahan();
    }
}