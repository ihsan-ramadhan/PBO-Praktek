// Square.java
class Square extends Rectangle {
    
    // No-arg constructor
    public Square() {
        super(); // calls Rectangle()
    }
    
    // Constructor with side
    public Square(double side) {
        super(side, side); // calls Rectangle(double, double)
    }
    
    // Constructor with side, color, and filled
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    
    // Getter for side
    public double getSide() {
        return getWidth(); // or getLength(), since they're the same
    }
    
    // Setter for side
    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }
    
    // Override setWidth to maintain square geometry
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }
    
    // Override setLength to maintain square geometry
    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }
    
    @Override
    public String toString() {
        return "A Square with side=" + getWidth() + ", which is a subclass of " + super.toString();
    }
    
    // Note: getArea() and getPerimeter() are inherited from Rectangle and work correctly
}