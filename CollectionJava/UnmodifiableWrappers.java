import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class UnmodifiableWrappers {
    public static void main(String[] args) {
        List<String> modifiableList = new ArrayList<>();
        modifiableList.add("One");
        modifiableList.add("Two");
        modifiableList.add("Three");
        System.out.println(modifiableList.add("Four"));
        System.out.println(modifiableList.add("Four"));
        List<String> unmodifiableList = Collections.unmodifiableList(modifiableList);
        System.out.println("Unmodifiable List: " + unmodifiableList);
        System.out.println("Second element: " + unmodifiableList.get(1));
        modifiableList.add("Five");
        System.out.println("After modifying original list: " + unmodifiableList);
        try {
            System.out.println(unmodifiableList.add("Five"));
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify unmodifiable list: " + e.getMessage());
        }
    }
}