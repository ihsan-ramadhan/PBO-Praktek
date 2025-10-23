import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSorting {
    public static void main(String[] args) {
        ArrayList<Student<String>> studentList = new ArrayList<>();

        studentList.add(new Student<>("S001", "Farid", "Ilmu Komputer", "Jl. Merdeka 10"));
        studentList.add(new Student<>("S002", "Abdur", "Sistem Informasi", "Jl. Sudirman 25"));
        studentList.add(new Student<>("S003", "Nayla", "Ilmu Komputer", "Jl. Kartini 5"));
        studentList.add(new Student<>("S004", "Kayis", "Desain Grafis", "Jl. Diponegoro 1"));
        studentList.add(new Student<>("S005", "Dani", "Manajemen", "Jl. Gajah Mada 30"));

        System.out.println("--- Sebelum di-sorting ---");
        for (Student<String> s : studentList) {
            System.out.println(s);
        }

        Collections.sort(studentList);

        System.out.println("\n--- Setelah di-sorting berdasarkan Nama ---");
        for (Student<String> s : studentList) {
            System.out.println(s);
        }
    }
}