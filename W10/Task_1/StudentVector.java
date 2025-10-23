import java.util.Vector;

public class StudentVector {
    public static void main(String[] args) {
        Vector<Student<String>> studentVector = new Vector<>();

        studentVector.add(new Student<>("V001", "Fajar", "Ilmu Komputer", "Jl. Asia Afrika 100"));
        studentVector.add(new Student<>("V002", "Gita", "Manajemen", "Jl. Braga 12"));
        studentVector.add(new Student<>("V003", "Hadi", "Ilmu Komputer", "Jl. Setiabudi 45"));
        studentVector.add(new Student<>("V004", "Indah", "Sistem Informasi", "Jl. Cihampelas 50"));
        studentVector.add(new Student<>("V005", "Joko", "Akuntansi", "Jl. Riau 77"));

        System.out.println("--- Menampilkan Student dari Departemen Ilmu Komputer ---");

        for (Student<String> s : studentVector) {
            if (s.getDepartment().equalsIgnoreCase("Ilmu Komputer")) {
                System.out.println(s);
            }
        }
    }
}