//*******************************************************
// Salesperson.java
//
// Represents a sales person who has a first name, last
// name, and total number of sales.
//*******************************************************
public class Salesperson implements Comparable
{
    private String firstName, lastName;
    private int totalSales;

    //------------------------------------------------------------
    // Constructor: Sets up the sales person object with
    // the given data.
    //------------------------------------------------------------
    public Salesperson (String first, String last, int sales)
    {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    //------------------------------------------------------------
    // Returns the sales person as a string.
    //------------------------------------------------------------
    public String toString()
    {
        return lastName + ", " + firstName + ": \t" + totalSales;
    }

    //--
    // Returns true if the sales people have
    // the same name.
    //--
    public boolean equals (Object other)
    {
        return (lastName.equals(((Salesperson) other).getLastName()) &&
                firstName.equals(((Salesperson) other).getFirstName()));
    }

    //------------------------------------------------------------
    // Order is based on total sales with the name
    // (last, then first) breaking a tie.
    //------------------------------------------------------------
    public int compareTo (Object other)
    {
        Salesperson otherSalesperson = (Salesperson) other;
        int result;

        // Bandingkan berdasarkan totalSales
        if (this.totalSales < otherSalesperson.totalSales)
            result = -1;
        else if (this.totalSales > otherSalesperson.totalSales)
            result = 1;
        else
            // Tie-breaker: Bandingkan berdasarkan nama (alphabetical order)
            // menggunakan compareTo String standar (ascending)
            result = this.lastName.compareTo(otherSalesperson.lastName);

        if (result == 0) {
            // Tie-breaker kedua: nama depan
            result = this.firstName.compareTo(otherSalesperson.firstName);
        }
        
        // Catatan: Karena WeeklySales.java akan menggunakan insertionSort (Descending), 
        // jadi perlu membalikkan hasil ini agar penjualan tertinggi muncul pertama.
        // Penjualan tinggi harus dianggap LEBIH BESAR dari penjualan rendah (sesuai spesifikasi Tugas 5).
        // Karena tugas 6 meminta pengurutan 'most to least', maka balikkan hasil
        // untuk memastikan insertionSort yang dimodifikasi (Tugas 4) bekerja dengan benar.
        // InsertionSort di Tugas 4 menggeser jika elemen saat ini LEBIH BESAR dari elemen sebelumnya.
        // Jadi, tujuannya adalah Penjualan TINGGI menghasilkan nilai compareTo yang TINGGI.
        return result; 
    }

    //------------------------------------------------------------
    // First name accessor.
    //------------------------------------------------------------
    public String getFirstName()
    {
        return firstName;
    }

    //------------------------------------------------------------
    // Last name accessor.
    //------------------------------------------------------------
    public String getLastName()
    {
        return lastName;
    }

    //------------------------------------------------------------
    // Total sales accessor.
    //------------------------------------------------------------
    public int getSales ()
    {
        return totalSales;
    }
}