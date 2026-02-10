//WAP to showcase the difference between shutdown() and shutdownNow().
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Question9 {
    public static void main(String[] args) {

        Runnable task = ()->{
            try {
                System.out.println(Thread.currentThread().getName() + " : Child thread task starts.");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : Intrrupted");
            }
            System.out.println(Thread.currentThread().getName() + " : task DONE");
        };

        ExecutorService ExServ = Executors.newFixedThreadPool(2);
 
        for (int i = 1; i <= 8; i++) {
            ExServ.submit(task);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted");
        }

        // ExServ.shutdown();
        List<Runnable> unFinished = ExServ.shutdownNow();
        System.out.println("task not done : " + unFinished.size()); 
    }
}
