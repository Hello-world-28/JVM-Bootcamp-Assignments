//WAP to show usage of Callable and demonstrate how it is different from Runnable
import java.util.concurrent.*;

// Runnable implementation (cannot return result)
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable task is executing");
    }
}

// Callable implementation (can return result)
class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Callable task is executing");
        return 100;
    }
}

class Question5 {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Runnable execution
        executor.execute(new MyRunnable());

        // Callable execution
        Future<Integer> result = executor.submit(new MyCallable());

        // Fetch result returned by Callable
        System.out.println("Result from Callable: " + result.get());

        executor.shutdown();
    }
}