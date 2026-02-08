//Create and Run a Thread using Runnable Interface and Thread class and show usage of sleep and join methods in the created threads.
class ThreadUsingThread extends Thread{
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("Child thread(t1) task using Thread class");
            System.out.println(i);
            System.out.println("Child thread(t1) task using Thread class SLEEPS");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
            
        }
    }
}
class ThreadUsingRunnable implements Runnable{
    Thread t1 = null;
    @Override
    public void run(){
        try{
            t1.join();
        }catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
        for(int i=10; i<20; i++){
            System.out.println("Child thread(t2) task using Runnable interface");
            System.out.println(i);
            System.out.println("Child thread(t2) task using Runnable interface SLEEPS");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}
class Main {
    public static void main(String[] args){
        System.out.println("main thread started");

        ThreadUsingRunnable a2 = new ThreadUsingRunnable();
        Thread t2 = new Thread(a2);

        ThreadUsingThread a1 = new ThreadUsingThread();
        a2.t1 = new Thread(a1);

        a2.t1.start();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        }
        
        for(int i = 20; i<=30; i++){
            System.err.println("Main Thread running");
            System.err.println(i);
            System.out.println("Main thread task SLEEPS");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
}