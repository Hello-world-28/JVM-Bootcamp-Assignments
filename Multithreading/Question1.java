//Create and Run a Thread using Runnable Interface and Thread class and show usage of sleep and join methods in the created threads.
class ThreadUsingThread extends Thread{
    @Override
    int run(){
        for(int i=0; i<7; i++){
            System.out.println("Child thread task using Thread class");
            System.out.println("Child thread task using Thread class SLEEPS");
        }
    }
}
class ThreadUsingRunnable implements Runnable{
    @Override
    int run(){
        or(int i=0; i<7; i++){
            System.out.println("Child thread task using Runnable interface");
            System.out.println("Child thread task using Runnable interface SLEEPS");
        }
    }
}
class Main {
    public static void main(String[] args){
        ThreadUsingThread t1 = new Thread();
        ThreadUsingRunnable t2 = new Thread();

        System.out.println("main thread started");
        t1.start();
        t2.start();

    }
}