package id.ac.polban.model;

// Subclass untuk barang alat tulis
public class BarangAlatTulis extends Barang {
    private String jenisAlat;
    
    public BarangAlatTulis(String namaBarang, int harga, int stok, String jenisAlat) {
        super(namaBarang, harga, stok, "Alat Tulis");
        this.jenisAlat = jenisAlat;
    }
    
    public String getJenisAlat() {
        return jenisAlat;
    }
    
    @Override
    public double hitungDiskon(int jumlah) {
        // Diskon 5% jika beli >= 10 item alat tulis
        if (jumlah >= 10) {
            return 0.05;
        }
        return super.hitungDiskon(jumlah);
    }
    
    @Override
    public String getInfoTambahan() {
        return super.getInfoTambahan() + " | Jenis: " + jenisAlat;
    }
}