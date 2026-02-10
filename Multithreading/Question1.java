//Create and Run a Thread using Runnable Interface and Thread class and show usage of sleep and join methods in the created threads.
class ThreadUsingThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child thread (t1) using Thread class");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class ThreadUsingRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child thread (t2) using Runnable interface");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Question1 {
    public static void main(String[] args) {

        ThreadUsingThread t1 = new ThreadUsingThread();

        ThreadUsingRunnable r = new ThreadUsingRunnable();
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Main thread starts after child threads finish");

        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}