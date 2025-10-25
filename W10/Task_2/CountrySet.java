import java.util.HashSet;
import java.util.Set;

public class CountrySet {
    public static void main(String[] args) {
        Set<String> countries = new HashSet<>();

        countries.add("Indonesia");
        countries.add("Malaysia");
        countries.add("Singapura");
        countries.add("Thailand");
        countries.add("Vietnam");
        countries.add("Indonesia");

        System.out.println("Daftar Negara (tanpa duplikat):");
        for (String country : countries) {
            System.out.println(country);
        }

        System.out.println("Jumlah negara dalam Set: " + countries.size());
    }
}
