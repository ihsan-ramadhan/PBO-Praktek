//*******************************************************
// Rectangle.java
//
// Represents a rectangle.
//*******************************************************
public class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor: Sets up the rectangle.
    public Rectangle (double l, double w) {
        super("Rectangle");
        length = l;
        width = w;
    }

    // Mengembalikan luas persegi panjang: panjang * lebar
    @Override
    public double area() {
        return length * width;
    }

    // Mengembalikan persegi panjang sebagai String.
    @Override
    public String toString() {
        return super.toString() + " of length " + length + " and width " + width;
    }
}