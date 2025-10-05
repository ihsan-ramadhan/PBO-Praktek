//*******************************************************
// PaintThings.java
//
// Computes the amount of paint needed to paint various
// things. Uses the amount method of the paint class which
// takes any Shape as a parameter.
//*******************************************************
import java.text. DecimalFormat;

public class PaintThings
{
    //------------------------------------------------------------
    // Creates some shapes and a Paint object
    // and prints the amount of paint needed
    // to paint each shape.
    //------------------------------------------------------------
    public static void main (String[] args)
    {
        final double COVERAGE = 350;
        Paint paint = new Paint (COVERAGE);

        Rectangle deck;
        Sphere bigBall;
        Cylinder tank;

        double deckAmt, ballAmt, tankAmt;

        // Instansiasi tiga bentuk untuk dicat
        // deck: persegi panjang 20 kali 35 kaki
        deck = new Rectangle(20, 35);
        // bigBall: bola dengan jari-jari 15
        bigBall = new Sphere(15);
        // tank: silinder dengan jari-jari 10 dan tinggi 30
        tank = new Cylinder(10, 30);

        // hitung jumlah cat yang dibutuhkan untuk setiap bentuk
        deckAmt = paint.amount(deck);
        ballAmt = paint.amount(bigBall);
        tankAmt = paint.amount(tank);

        // Cetak jumlah cat untuk masing-masing.
        DecimalFormat fmt = new DecimalFormat("0.#");
        System.out.println ("\nNumber of gallons of paint needed...");
        System.out.println ("Deck " + fmt.format(deckAmt));
        System.out.println ("Big Ball " + fmt.format(ballAmt));
        System.out.println ("Tank " + fmt.format (tankAmt));
    }
}