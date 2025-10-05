//*******************************************************
// Cylinder.java
//
// Represents a cylinder.
//*******************************************************
public class Cylinder extends Shape {
    private double radius;
    private double height;

    // Constructor: Sets up the cylinder.
    public Cylinder (double r, double h) {
        super("Cylinder");
        radius = r;
        height = h;
    }

    // Mengembalikan luas (luas permukaan) silinder.
    // Menggunakan rumus yang diberikan: PI*radius^2*height 
    @Override
    public double area() {
        return Math.PI * radius * radius * height;
    }

    // Mengembalikan silinder sebagai String.
    @Override
    public String toString() {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}