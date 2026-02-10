import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Question7 {

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        };

        // Create list of tasks
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tasks.add(task);
        }

        // 1. SingleThreadExecutor
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        for (Runnable t : tasks) {
            singleExecutor.submit(t);
        }
        singleExecutor.shutdown();
        singleExecutor.awaitTermination(5, TimeUnit.SECONDS);

        // 2. CachedThreadPool
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();
        for (Runnable t : tasks) {
            cachedExecutor.submit(t);
        }
        cachedExecutor.shutdown();
        cachedExecutor.awaitTermination(5, TimeUnit.SECONDS);

        // 3. FixedThreadPool
        ExecutorService fixedExecutor = Executors.newFixedThreadPool(3);
        for (Runnable t : tasks) {
            fixedExecutor.submit(t);
        }
        fixedExecutor.shutdown();
        fixedExecutor.awaitTermination(5, TimeUnit.SECONDS);
    }
}
