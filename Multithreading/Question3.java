// WAP to showcase the usage of volatile in Java

class Worker extends Thread {

    // Volatile variable ensures visibility across threads
    static volatile boolean running = true;

    public void run() {
        System.out.println("Worker thread started");

        // Loop continues until main thread updates 'running'
        while (running) {
            // busy wait
        }

        System.out.println("Worker thread stopped");
    }
}

class Question3 {

    public static void main(String[] args) throws InterruptedException {

        Worker t = new Worker();
        t.start();

        // Allow worker thread to start
        Thread.sleep(1000);

        // Updating volatile variable
        Worker.running = false;

        System.out.println("Main thread updated the volatile variable");
    }
}
