//Use Synchronize method and synchronize block 
//to enable synchronization between multiple threads 
//trying to access method at same time.
class SharedResource {

    // Unsynchronized method
    void unSyncMethod() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " executing UNSYNC method: " + i);
        }
    }

    // Synchronized method
    synchronized void syncMethod() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " executing SYNC METHOD: " + i);
        }
    }

    // Method using synchronized block
    void syncBlockMethod() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()
                        + " executing SYNC BLOCK: " + i);
            }
        }
    }
}
class MyThread implements Runnable {

    SharedResource resource;

    MyThread(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.unSyncMethod();     // race condition possible
        resource.syncMethod();       // synchronized method
        resource.syncBlockMethod();  // synchronized block
    }
}
class Main {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(new MyThread(resource), "Thread-1");
        Thread t2 = new Thread(new MyThread(resource), "Thread-2");

        t1.start();
        t2.start();
    }
}
