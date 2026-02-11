//Demonstrate the use of 
// addFirst(), addLast, removeFirst(), removeLast, getFirst(), getLast(), reversed() 
// in Set and List Sequenced collections

import java.util.*;

class SequencedCollectionsDemo {

    public static void main(String[] args) {

        // LIST (SequencedCollection)
        List<String> list = new ArrayList<>();

        list.addFirst("A");
        list.addLast("B");
        list.addLast("C");

        System.out.println("List: " + list);
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        list.removeFirst();
        list.removeLast();

        System.out.println("After removals: " + list);

        List<String> reversedList = list.reversed();
        System.out.println("Reversed list: " + reversedList);

        // SET (SequencedSet) 
        SequencedSet<Integer> set = new LinkedHashSet<>();

        set.addFirst(10);
        set.addLast(20);
        set.addLast(30);

        System.out.println("\nSet: " + set);
        System.out.println("First: " + set.getFirst());
        System.out.println("Last: " + set.getLast());

        set.removeFirst();
        set.removeLast();

        System.out.println("After removals: " + set);

        SequencedSet<Integer> reversedSet = set.reversed();
        System.out.println("Reversed set: " + reversedSet);
    }
}
