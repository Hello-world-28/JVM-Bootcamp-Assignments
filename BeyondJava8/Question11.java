//Demonstrate the use of 
// firstEntry(), lastEntry(), pollFirstEntry(), pollLastEntry(), 
// putFirst(), putLast(), reversed() with SequencedMap.

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;

public class Question11 {

    public static void main(String[] args) {

        SequencedMap<Integer, String> map = new LinkedHashMap<>();

        // putFirst() and putLast()
        map.putLast(1, "One");
        map.putLast(2, "Two");
        map.putFirst(0, "Zero");

        System.out.println("Map: " + map);

        // firstEntry() and lastEntry()
        Map.Entry<Integer, String> first = map.firstEntry();
        Map.Entry<Integer, String> last = map.lastEntry();

        System.out.println("First Entry: " + first);
        System.out.println("Last Entry: " + last);

        // pollFirstEntry() and pollLastEntry()
        Map.Entry<Integer, String> removedFirst = map.pollFirstEntry();
        Map.Entry<Integer, String> removedLast = map.pollLastEntry();

        System.out.println("Removed First: " + removedFirst);
        System.out.println("Removed Last: " + removedLast);
        System.out.println("After polling: " + map);

        // reversed()
        SequencedMap<Integer, String> reversedMap = map.reversed();
        System.out.println("Reversed Map: " + reversedMap);
    }
}
