//Use Synchronize method and synchronize block 
//to enable synchronization between multiple threads 
//trying to access method at same time.
class Thread1 implements Runnable{
    Main t1m = new Main();
    static boolean unSyncMethod = false;
    @Override
    public void run(){
        this.a1.unSyncMethod();
        unSyncMethod = true;
        while(!Thread2.unSyncMethod){
            try{
                this.wait();
            } catch (InterruptedException e){}
        }
        System.out.println(Thread.currentThread().getName() + " Unsynchronized block ended Synchronized method starts" );
    }
}
class Thread2 implements Runnable{
    Main t2m = new Main();
    static boolean unSyncMethod = false;
    @Override
    public void run(){
        this.a1.unSyncMethod();
        unSyncMethod = true;
        while(!Thread1.unSyncMethod){
            try{
                this.wait();
            } catch (InterruptedException e){}
        }
        System.out.println(Thread.currentThread().getName() + " Unsynchronized block ended Synchronized method starts" );
    }
}
class Main{

    public void unSyncMethod(){
        for(int i = 0; i<10; i++){
            System.out.println("Thread " + Thread.currentThread().getName() + "Running : " +i);
        }
    }

    public synchronized void syncMethod(){
        for(int i = 0; i<10; i++){
            System.out.println(i);
            System.out.println("Thread " + Thread.currentThread().getName() + "Running : " +i);
        }
    }

    public static void main(String[] args){
        Main a1;
        Thread1 m1 = new Thread1();
        a1 = new Main();
        Thread t1 = new Thread(m1);

        Thread2 m2 = new Thread2();
        Thread t2 = new Thread(m2);
        t1.start();
        t2.start();
    }
}