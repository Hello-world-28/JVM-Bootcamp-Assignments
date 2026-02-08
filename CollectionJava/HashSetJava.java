import java.util.HashSet;
class HashSetJava {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        System.out.println(set.add("Apple"));
        System.out.println(set.add("Apple"));
        set.add("Banana");
        set.add("Orange");
        set.add("Apple"); // Duplicate, will not be added

        System.out.println("HashSet: " + set);
    }
}