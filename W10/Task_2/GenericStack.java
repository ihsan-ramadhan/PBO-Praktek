import java.util.ArrayList;

public class GenericStack<T> {

    private ArrayList<T> items;

    public GenericStack() {
        items = new ArrayList<>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new GenericStackException("Underflow Error");
        }
        return items.remove(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static class GenericStackException extends RuntimeException {
        public GenericStackException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        GenericStack<Integer> stackInt = new GenericStack<>();
        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);
        System.out.println(stackInt.pop());
        System.out.println(stackInt.pop());
        
        GenericStack<String> stackString = new GenericStack<>();
        stackString.push("Java");
        stackString.push("is");
        stackString.push("Fun");
        System.out.println(stackString.pop());
        System.out.println(stackString.pop());
        System.out.println(stackString.pop());
        
        try {
            System.out.println(stackString.pop());
        } catch (GenericStackException e) {
            System.out.println(e.getMessage());
        }
    }
}