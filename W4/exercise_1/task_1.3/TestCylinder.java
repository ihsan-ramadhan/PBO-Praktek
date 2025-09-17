/**
 * Task 1.3: Test program for toString() method override
 * Demonstrates @Override annotation and super.toString() usage
 */
public class TestCylinder { // save as "TestCylinder.java"
    public static void main(String[] args) {
        // Test 1: Default constructor
        Cylinder c1 = new Cylinder();
        System.out.println("Test 1: Default Constructor");
        System.out.println("toString(): " + c1.toString());
        System.out.println("Direct call: " + c1); // Implicit toString() call
        System.out.println();

        // Test 2: Constructor with height
        Cylinder c2 = new Cylinder(10.0);
        System.out.println("Test 2: Constructor with Height = 10.0");
        System.out.println("toString(): " + c2.toString());
        System.out.println("Direct call: " + c2);
        System.out.println();

        // Test 3: Constructor with radius and height
        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println("Test 3: Constructor with Radius = 2.0, Height = 10.0");
        System.out.println("toString(): " + c3.toString());
        System.out.println("Direct call: " + c3);
        System.out.println();
        
        // Test 4: Constructor with radius, height, and color
        Cylinder c4 = new Cylinder(3.0, 5.0, "blue");
        System.out.println("Test 4: Constructor with Radius = 3.0, Height = 5.0, Color = blue");
        System.out.println("toString(): " + c4.toString());
        System.out.println("Direct call: " + c4);
        System.out.println();
        
        // Test 5: Show comparison with Circle's toString()
        Circle circle = new Circle(3.0, "blue");
        System.out.println("=== Comparison with Circle toString() ===");
        System.out.println("Circle toString(): " + circle.toString());
        System.out.println("Cylinder toString(): " + c4.toString());
        System.out.println();
        
        // Test 6: Complete information display
        System.out.println("=== Complete Information Display ===");
        System.out.println("Cylinder Details:");
        System.out.println("  " + c4.toString());
        System.out.println("  Radius: " + c4.getRadius());
        System.out.println("  Height: " + c4.getHeight());
        System.out.println("  Color: " + c4.getColor());
        System.out.println("  Base Area: " + String.format("%.2f", Math.PI * c4.getRadius() * c4.getRadius()));
        System.out.println("  Surface Area: " + String.format("%.2f", c4.getArea()));
        System.out.println("  Volume: " + String.format("%.2f", c4.getVolume()));
    }
}