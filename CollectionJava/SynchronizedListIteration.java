import java.util.*;
class SynchronizedListIteration {
    public static void main(String[] args){
        List<String> SyncList = Collections.synchronizedList(new ArrayList<>());
        SyncList.add("Apple");
        SyncList.add("Banana");

        synchronized(SyncList){
            Iterator<String> iterator = SyncList.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }
}