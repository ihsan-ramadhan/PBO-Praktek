// TestShape.java
class TestShape {
    public static void main(String[] args) {
        // Test Shape
        System.out.println("=== Testing Shape ===");
        Shape s1 = new Shape();
        System.out.println(s1);
        Shape s2 = new Shape("blue", false);
        System.out.println(s2);
        System.out.println();
        
        // Test Circle
        System.out.println("=== Testing Circle ===");
        Circle c1 = new Circle();
        System.out.println(c1);
        System.out.println("Area: " + String.format("%.2f", c1.getArea()));
        System.out.println("Perimeter: " + String.format("%.2f", c1.getPerimeter()));
        
        Circle c2 = new Circle(2.0, "yellow", true);
        System.out.println(c2);
        System.out.println("Area: " + String.format("%.2f", c2.getArea()));
        System.out.println("Perimeter: " + String.format("%.2f", c2.getPerimeter()));
        System.out.println();
        
        // Test Rectangle
        System.out.println("=== Testing Rectangle ===");
        Rectangle r1 = new Rectangle();
        System.out.println(r1);
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());
        
        Rectangle r2 = new Rectangle(3.0, 4.0, "purple", false);
        System.out.println(r2);
        System.out.println("Area: " + r2.getArea());
        System.out.println("Perimeter: " + r2.getPerimeter());
        System.out.println();
        
        // Test Square
        System.out.println("=== Testing Square ===");
        Square sq1 = new Square();
        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea());
        System.out.println("Perimeter: " + sq1.getPerimeter());
        
        Square sq2 = new Square(5.0, "orange", true);
        System.out.println(sq2);
        System.out.println("Area: " + sq2.getArea());
        System.out.println("Perimeter: " + sq2.getPerimeter());
        
        // Test square geometry maintenance
        System.out.println("\n=== Testing Square Geometry Maintenance ===");
        sq2.setWidth(6.0);
        System.out.println("After setting width to 6.0: " + sq2);
        System.out.println("Width: " + sq2.getWidth() + ", Length: " + sq2.getLength());
    }
}