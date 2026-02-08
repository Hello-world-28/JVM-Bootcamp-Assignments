import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class Cursor {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        //1) Using Enumeration to iterate through the list
        Enumeration<String> enumeration = Collections.enumeration(list);
        System.out.println("Using Enumeration:");
        while(enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
        //2) Using Iterator to iterate through the list
        Iterator<String> itr = list.iterator();
        System.out.println("Using Iterator:");
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        //3) Using ListIterator to iterate through the list
        ListIterator<String> lstItr = list.listIterator();
        System.out.println("Using ListIterator:");
        while(lstItr.hasNext()) {
            System.out.println("Next Element: " + lstItr.next());
            System.out.println("Next Index: " + lstItr.nextIndex());
            lstItr.set("1");
        }
        while(lstItr.hasPrevious()) {
            System.out.println("Previous Element: " + lstItr.previous());
            System.out.println("Previous Index: " + lstItr.previousIndex());
        }

    }
}
import java.util.Queue;
class A{
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        ListIterator<Integer> iterator = queue.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}