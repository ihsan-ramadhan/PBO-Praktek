class Circle extends Shape {
    private double radius;
    
    // No-arg constructor
    public Circle() {
        super(); // calls Shape()
        radius = 1.0;
    }
    
    // Constructor with radius
    public Circle(double radius) {
        super(); // calls Shape()
        this.radius = radius;
    }
    
    // Constructor with radius, color, and filled
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    
    // Getter and setter for radius
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    // Methods
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public String toString() {
        return "A Circle with radius=" + radius + ", which is a subclass of " + super.toString();
    }
}