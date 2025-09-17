/**
 * Task 1.2: Test program demonstrating method overriding
 * Shows the difference between base area (Circle) and surface area (Cylinder)
 */
public class TestCylinder { // save as "TestCylinder.java"
    public static void main(String[] args) {

        // Test to show method overriding behavior
        Circle circle = new Circle(2.0);
        Cylinder cylinder = new Cylinder(2.0, 10.0);

        System.out.println("Circle with radius 2.0:");
        System.out.println("  getArea() returns: " + String.format("%.2f", circle.getArea()));
        
        System.out.println("\nCylinder with radius 2.0 and height 10.0:");
        System.out.println("  getArea() returns: " + String.format("%.2f", cylinder.getArea()));
        System.out.println("  getVolume() returns: " + String.format("%.2f", cylinder.getVolume()));
        
        System.out.println("\n=== Detailed Test Cases ===");
        
        // Test 1: Default constructor
        Cylinder c1 = new Cylinder();
        System.out.println("\nTest 1: Default Constructor");
        System.out.println("Cylinder: radius=" + c1.getRadius() + " height=" + c1.getHeight());
        System.out.println("  Base area: " + String.format("%.2f", Math.PI * c1.getRadius() * c1.getRadius()));
        System.out.println("  Surface area (getArea()): " + String.format("%.2f", c1.getArea()));
        System.out.println("  Volume (getVolume()): " + String.format("%.2f", c1.getVolume()));

        // Test 2: Constructor with height
        Cylinder c2 = new Cylinder(10.0);
        System.out.println("\nTest 2: Constructor with Height = 10.0");
        System.out.println("Cylinder: radius=" + c2.getRadius() + " height=" + c2.getHeight());
        System.out.println("  Base area: " + String.format("%.2f", Math.PI * c2.getRadius() * c2.getRadius()));
        System.out.println("  Surface area (getArea()): " + String.format("%.2f", c2.getArea()));
        System.out.println("  Volume (getVolume()): " + String.format("%.2f", c2.getVolume()));

        // Test 3: Constructor with radius and height
        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println("\nTest 3: Constructor with Radius = 2.0, Height = 10.0");
        System.out.println("Cylinder: radius=" + c3.getRadius() + " height=" + c3.getHeight());
        System.out.println("  Base area: " + String.format("%.2f", Math.PI * c3.getRadius() * c3.getRadius()));
        System.out.println("  Surface area (getArea()): " + String.format("%.2f", c3.getArea()));
        System.out.println("  Volume (getVolume()): " + String.format("%.2f", c3.getVolume()));
    }
}