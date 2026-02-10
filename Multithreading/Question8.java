//WAP to return a random integer value from a thread execution using Future.
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Question8{
    public static void main(String[] args){
        Callable<Integer> task = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : Thread INTERRUPTED.");
            }
            return new Random().nextInt(100);
        };
        
        ExecutorService exs = Executors.newSingleThreadExecutor();
        Future<Integer> future = exs.submit(task);
        System.out.println("Main thread running...");
        System.out.println("Getting Random value from thread...");
        try {
            System.out.println("Random integer returned from the thread : " + future.get());
        } catch (Exception e) {
            System.err.println("Exception Occured " + e.getMessage());
        }
        exs.shutdown();
        
    }
}