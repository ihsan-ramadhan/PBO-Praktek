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
    // A public method for computing the volume of cylinder
    // use superclass method getArea() to get the base area
  /**
     * TASK 1.2: Override getArea() to compute surface area of cylinder
     * Surface area = 2πrh + 2πr² = 2πr(h + r)
     * 
     * If getArea() is called by a Circle instance, it returns the area.
     * If getArea() is called by a Cylinder instance, it returns the surface area.
     */
    @Override
    public double getArea() {
        return 2 * Math.PI * getRadius() * (height + getRadius());
    }
    /**
     * TASK 1.2: Fix getVolume() method
     * After overriding getArea() in subclass Cylinder, getVolume() no longer works
     * because it uses the overridden getArea() method.
     * 
     * Solution: Use super.getArea() to invoke the getArea() of superclass Circle
     */
    public double getVolume() {
        return super.getArea() * height; // Use Circle's getArea() for base area
    }
}