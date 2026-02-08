import java.util.ArrayList;
import java.util.List;
class ArrayListJava {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("ArrayList: " + list);
        list.remove(2);
        System.out.println("After removing 2: " + list);
        list.remove(2);
        System.out.println("After removing element at index 2: " + list);

        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.addAll(list);
        System.out.println("After adding another list: " + ls);
        ls.remove(Integer.valueOf(2));
        System.out.println("After removing 2 from second list: " + ls);
        ls.remove(2);
        System.out.println("After removing element at index 2 from second list: " + ls);
    }
}