package com.hly.java.Thread;

/**
 * @author :hly
 * @date :2018/5/31
 */
public class ThreadSafe extends Thread {
    int i =10;

    synchronized void mySynchronized(){
        if(i>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+i--);
        }
    }
    public void run(){
       while(true){
           mySynchronized();
       }
    }

    public static void main(String[]arv){
        ThreadSafe threadSafe = new ThreadSafe();
        Thread t1 = new Thread(threadSafe,"t1");
        Thread t2 = new Thread(threadSafe,"t2");
        Thread t3 = new Thread(threadSafe,"t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
