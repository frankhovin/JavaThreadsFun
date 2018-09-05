package com.frankhovin;

/* In general, implementing Runnable is the preferred way to use threads in Java. */

class Snekker implements Runnable {
    private Thread t1;
    private String threadName;

    Snekker(String name) {
        threadName = name;
        //System.out.println(threadName + " ankommer.");

        start();
    }

    public void run() {
        System.out.println(threadName + " begynner arbeidet.");

        overview();
        basicwork();
        possiblemissingmaterials();

        /*try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }*/


        System.out.println("Thread " +  threadName + " exiting.");
    }

    private void start () {
        System.out.println(threadName + "ankommer.");
        if (t1 == null) {
            t1 = new Thread (this, threadName);
            t1.start ();
        }
    }

    private void overview() {
        System.out.println(threadName + " tar et overblikk over situasjonen...");
        try {
            Thread.sleep((long) (Math.random() * 10000));
        } catch (InterruptedException e) {
            System.out.println(threadName + " ble avbrutt mens han tok et overblikk over situasjonen...");
        }
    }

    private void basicwork() {
        System.out.println(threadName + " gjør grunnarbeidet...");
        try {
            Thread.sleep((long) (5 + Math.random() * 10000));
        } catch (InterruptedException e) {
            System.out.println(threadName + " ble avbrutt under grunnarbeidet...");
        }
    }

    private void possiblemissingmaterials() {
        double d = Math.random();
        System.out.println(d);
        if (d <= 0.20)
            getmaterials();
    }

    private void getmaterials() {
        System.out.println(threadName + " må kjøre til grossisen for å hente materialer...");
        try {
            Thread.sleep((long) (15 + Math.random() * 10000));
        } catch (InterruptedException e) {
            System.out.println(threadName + " ble avbrutt under grunnarbeidet...");
        }
    }
}