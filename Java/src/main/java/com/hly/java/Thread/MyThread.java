package com.hly.java.Thread;

/**
 * @author :hly
 * @date :2018/5/31
 */
public class MyThread extends Thread {

    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.print(Thread.currentThread().getName() + ":" + i + " ");
            try {
                if (i == 3)
                    //线程停止中断

                    Thread.interrupted();
                //线程睡眠3秒
                Thread.sleep(2000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] arv) {
        System.out.println("Java多线程分析:");
        //实例化类对象
        MyThread myThread = new MyThread();
        //该类对象实例化的线程,第二个参数为线程的名字
        Thread t1 = new Thread(myThread, "t1");
        Thread t2 = new Thread(myThread, "t2");
        Thread t3 = new Thread(myThread, "t3");

        try {
            //t1线程开始
            t1.start();
            //线程等待状态，比如说远程资源你们有传到客户端时，你可以等线程等待一下
            //t1.wait();
            //线程取消等待状态
            //t1.notify();
            //join表示当前线程完成后下一线程才能开始
            t1.join();
            //t2线程开始
            t2.start();
            t3.start();
            //设置线程的优先级，等级分为1-10,t3总会在t2前面先运行
            t2.setPriority(9);
            t3.setPriority(10);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}