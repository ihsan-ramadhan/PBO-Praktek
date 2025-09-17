package id.ac.polban.model;

// Subclass untuk barang premium
public class BarangPremium extends Barang {
    private String brand;
    private boolean bergaransi;
    
    public BarangPremium(String namaBarang, int harga, int stok, String brand, boolean bergaransi) {
        super(namaBarang, harga, stok, "Premium");
        this.brand = brand;
        this.bergaransi = bergaransi;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public boolean isBergaransi() {
        return bergaransi;
    }
    
    @Override
    public double hitungDiskon(int jumlah) {
        // Diskon 3% untuk barang premium jika beli >= 3 item
        if (jumlah >= 3) {
            return 0.03;
        }
        return super.hitungDiskon(jumlah);
    }
    
    @Override
    public String getInfoTambahan() {
        return super.getInfoTambahan() + " | Brand: " + brand + 
               (bergaransi ? " | Bergaransi" : " | Tanpa Garansi");
    }
}