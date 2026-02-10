//Use a singleThreadExecutor, newCachedThreadPool() and newFixedThreadPool() to submit a list of tasks and wait for completion of all tasks.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Question7{
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Thread Task starts...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : got Interrupted.");
            }
            System.out.println("Thread Task ends...");
        };

        //Using SingleThreadExecutor
        ExecutorService exS = Executors.newSingleThreadExecutor();
        exS.submit(task);
        exS.shutdown();

        //Using newCachedThreadPool
        
    }
}