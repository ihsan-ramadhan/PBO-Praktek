import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= -128 && x <= 127) System.out.println("* byte");
                if (x >= -32768 && x <= 32767) System.out.println("* short");
                if (x >= -2147483648 && x <= 2147483647) System.out.println("* int");
                if (x >= -9223372036854775808L && x <= 9223372036854775807L) System.out.println("* long");
            } catch (Exception e) {
                String s = sc.next();
                System.out.println(s + " can't be fitted anywhere.");
            }
        }
        sc.close();
    }
}
// Komentar: Program menggunakan try-catch untuk menangani angka yang lebih besar dari long, dengan fallback ke String 
// untuk pesan "can't be fitted anywhere". Untuk angka dalam range long, dicek secara manual range masing-masing tipe.