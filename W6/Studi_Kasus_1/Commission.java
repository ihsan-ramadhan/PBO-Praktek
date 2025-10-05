//*******************************************************
// Commission.java
//
// Diwarisi dari kelas Hourly, menambahkan total penjualan dan tarif komisi.
//*******************************************************

public class Commission extends Hourly
{
    private double totalSales;
    private double commissionRate;

    //------------------------------------------------------------
    // Konstruktor: Menyiapkan karyawan komisi menggunakan informasi yang ditentukan.
    //------------------------------------------------------------
    public Commission (String eName, String eAddress, String ePhone,
                       String socSecNumber, double rate, double commRate)
    {
        // Panggil konstruktor kelas induk (Hourly) untuk 5 parameter pertama
        super (eName, eAddress, ePhone, socSecNumber, rate);

        // Atur variabel instance unik
        commissionRate = commRate;
        totalSales = 0.0;
    }

    //------------------------------------------------------------
    // Menambahkan jumlah penjualan yang ditentukan ke total penjualan karyawan.
    //------------------------------------------------------------
    public void addSales (double salesAmount)
    {
        totalSales += salesAmount;
    }

    //------------------------------------------------------------
    // Menghitung dan mengembalikan gaji untuk karyawan komisi.
    // Gaji = Gaji Hourly + Komisi. Total penjualan diatur kembali ke 0.
    //------------------------------------------------------------
    @Override
    public double pay()
    {
        // 1. Hitung komisi
        double commissionPayment = totalSales * commissionRate;

        // 2. Hitung gaji dasar dari jam kerja (menggunakan super.pay(), yang juga mengatur hoursWorked ke 0)
        double hourlyPayment = super.pay();

        // 3. Hitung total pembayaran
        double totalPayment = hourlyPayment + commissionPayment;

        // 4. Atur totalSales kembali ke 0
        totalSales = 0.0;

        return totalPayment;
    }

    //------------------------------------------------------------
    // Mengembalikan informasi tentang karyawan komisi ini sebagai string.
    //------------------------------------------------------------
    @Override
    public String toString()
    {
        // Panggil metode toString dari parent (Hourly), yang mencakup jam kerja saat ini
        String result = super.toString();

        // Tambahkan total penjualan saat ini
        result += "\nTotal Sales: " + totalSales;

        return result;
    }
}