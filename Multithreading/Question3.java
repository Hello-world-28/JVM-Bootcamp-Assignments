// //WAP to showcase the usage of volatile in java.
// class Thread1 implements Runnable{
//     public void run(){
//         //2) print non volatile var
//         System.out.println("Printing the current value of non volatile var : " + Main.x);
//         Thread.currentThread().yield();
//         //4) print mofified non volatile var
//         System.out.println("Printing the value of non volatile var after modification : " + Main.x);
//         System.out.println("Printing the value of volatile var before modification : " + Main.y);
//         Thread.currentThread().yield();
//         System.out.println("Printing the value of volatile var after modification : " + Main.y);
//     }
// }
// class Main{
//     static int x = 10;
//     static volatile int y = 20;
//     public static void main(String[] args){
//         //1) Create a Thread and and start thread
//         synchronized(Thread.currentThread()){
//             Thread t = new Thread(new Thread1());
//             t.start();
//             Thread.currentThread().yield();
//         }
//         //3) modify non volatile var
//         synchronized(Thread.currentThread()){
//             x=x+1;
//             Thread.currentThread().yield();
//         }
//         synchronized(Thread.currentThread()){
//             y=y+1;
//             Thread.currentThread().yield();
//         }
//     }
// }