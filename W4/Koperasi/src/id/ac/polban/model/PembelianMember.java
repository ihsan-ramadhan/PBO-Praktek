package id.ac.polban.model;

// Subclass untuk pembelian member dengan diskon tambahan
public class PembelianMember extends Pembelian {
    private String namaMember;
    private double diskonMember;
    
    public PembelianMember(String namaMember, double diskonMember) {
        super();
        this.namaMember = namaMember;
        this.diskonMember = diskonMember;
    }
    
    @Override
    protected double hitungHargaItem(Barang barang, int jumlah) {
        // Panggil method parent untuk hitung diskon barang
        double hargaSetelahDiskonBarang = super.hitungHargaItem(barang, jumlah);
        
        // Tambah diskon member
        double diskonMemberAmount = hargaSetelahDiskonBarang * diskonMember;
        totalDiskon += diskonMemberAmount;
        
        return hargaSetelahDiskonBarang - diskonMemberAmount;
    }
    
    @Override
    public void tampilkanPembelian() {
        System.out.println("\n=== STRUK PEMBELIAN MEMBER ===");
        System.out.println("Member: " + namaMember);
        System.out.println("Diskon Member: " + String.format("%.0f", diskonMember * 100) + "%");
        System.out.println("===============================");
        
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            int jumlah = jumlahBarang.get(i);
            double hargaDasar = barang.getHarga() * jumlah;
            double diskonBarang = barang.hitungDiskon(jumlah);
            
            System.out.println(barang.getNamaBarang() + " x " + jumlah);
            System.out.println("  Harga: Rp " + String.format("%,d", (int)hargaDasar));
            if (diskonBarang > 0) {
                System.out.println("  Diskon Item: " + String.format("%.0f", diskonBarang * 100) + "%");
            }
            System.out.println("  Diskon Member: " + String.format("%.0f", diskonMember * 100) + "%");
            System.out.println();
        }
        
        System.out.println("Total Diskon: Rp " + String.format("%,d", (int)totalDiskon));
        System.out.println("Total Harga: Rp " + String.format("%,d", (int)totalHarga));
        System.out.println("===============================");
    }
}