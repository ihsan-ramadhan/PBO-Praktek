package id.ac.polban.model;

// Subclass untuk barang kertas
public class BarangKertas extends Barang {
    private String ukuran;
    private int lembarPerPack;
    
    public BarangKertas(String namaBarang, int harga, int stok, String ukuran, int lembarPerPack) {
        super(namaBarang, harga, stok, "Kertas");
        this.ukuran = ukuran;
        this.lembarPerPack = lembarPerPack;
    }
    
    public String getUkuran() {
        return ukuran;
    }
    
    public int getLembarPerPack() {
        return lembarPerPack;
    }
    
    @Override
    public double hitungDiskon(int jumlah) {
        // Diskon 10% jika beli >= 2 pack kertas
        if (jumlah >= 2) {
            return 0.10;
        }
        return super.hitungDiskon(jumlah);
    }
    
    @Override
    public String getInfoTambahan() {
        return super.getInfoTambahan() + " | Ukuran: " + ukuran + " | " + lembarPerPack + " lembar/pack";
    }
}