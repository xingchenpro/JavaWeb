package com.hly.java.MySynchronized;

/**
 * @author :hly
 * @date :2018/5/30
 */
public class Thread1 implements Runnable {
    @Override
    public void run() {
        synchronized (this){
            for(int i =0;i<3;i++){
                System.out.println();
            }
        }
    }
}
