public class Main {
    public static void main(String[] args) {
        Food snack = new Food("Potato Chips", 2.5, 300);
        System.out.println("--- Food Details ---");
        snack.display();
        System.out.println();

        Toy car = new Toy("Hot Wheels Car", 5.0, 3);
        System.out.println("--- Toy Details ---");
        car.display();
        System.out.println();

        Book novel = new Book("Java Programming", 50.0, "John Doe");
        System.out.println("--- Book Details ---");
        novel.display();
    }
}