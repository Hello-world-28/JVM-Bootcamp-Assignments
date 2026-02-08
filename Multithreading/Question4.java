//Write a code to simulate a deadlock in java
class Thread1 implements Runnable{
    @Override
    public void run(){
        System.out.println("Child Thread Starts");
        try{
            Main.a.join();
        }catch(InterruptedException e){}
    }
}
class Main{
    static Thread a; 
    public static void main(String[] args){
        a = Thread.currentThread();
        System.out.println("Main Thread Starts");
        Thread t = new Thread(new Thread1());
        t.start();
        try{
            Main.a.join();
        }catch(InterruptedException e){}
    }
}