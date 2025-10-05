//*******************************************************
// Shape.java
//
// Kelas abstrak untuk semua bentuk.
//*******************************************************
public abstract class Shape {
    private String shapeName;

    // Konstruktor untuk mengatur nama bentuk
    public Shape(String name) {
        shapeName = name;
    }

    // Metode abstrak untuk menghitung luas (luas permukaan untuk bentuk 3D)
    public abstract double area();

    // Mengembalikan nama bentuk
    public String toString() {
        return shapeName;
    }
}