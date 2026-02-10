//Improve the code written in Basics of Multi Threading Part 1 exercise question 4 to handle the deadlock using reentract lock.
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Resource {
    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();
}

class Task1 implements Runnable {
    public void run() {
        try {
            if (Resource.lock1.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println("Task1 acquired lock1");

                Thread.sleep(100);

                if (Resource.lock2.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println("Task1 acquired lock2");
                    Resource.lock2.unlock();
                }
                Resource.lock1.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Task2 implements Runnable {
    public void run() {
        try {
            if (Resource.lock2.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println("Task2 acquired lock2");

                Thread.sleep(100);

                if (Resource.lock1.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println("Task2 acquired lock1");
                    Resource.lock1.unlock();
                }
                Resource.lock2.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Question6 {
    public static void main(String[] args) {
        new Thread(new Task1()).start();
        new Thread(new Task2()).start();
    }
}
