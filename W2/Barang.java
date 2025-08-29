public class Barang {
    private String namaBarang;
    private int harga;
    private int stok;

    public Barang(String namaBarang, int harga, int stok) {
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
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

    public void kuranginStok(int jumlah) {
        stok = getStok() - jumlah;
    }
}