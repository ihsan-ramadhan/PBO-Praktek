public class Cylinder extends Circle { // Save as "Cylinder.java"
    private double height; // private variable
    
    // Constructor with default color, radius and height
    public Cylinder() {
        super(); // call superclass no-arg constructor Circle()
        height = 1.0;
    }
    // Constructor with default radius, color but given height
    public Cylinder(double height) {
        super(); // call superclass no-arg constructor Circle()
        this.height = height;
    }
    // Constructor with default color, but given radius, height
    public Cylinder(double radius, double height) {
        super(radius); // call superclass constructor Circle(r)
        this.height = height;
    }
    // Constructor with radius, height, and color
    public Cylinder(double radius, double height, String color) {
        super(radius, color); // call superclass constructor Circle(radius, color)
        this.height = height;
    }
    // A public method for retrieving the height
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * getRadius() * (height + getRadius());
    }

    public double getVolume() {
        return super.getArea() * height; // Use Circle's getArea() for base area
    }
    /**
     * TASK 1.3: Override toString() method
     * 
     * @Override annotation asks compiler to check whether there is such a method 
     * in the superclass to be overridden. This helps if you misspell toString().
     * 
     * Use super.toString() to reuse Circle's toString() method
     */
    @Override
    public String toString() { // in Cylinder class
        return "Cylinder: subclass of " + super.toString() // use Circle's toString()
                + " height=" + height;
    }
}