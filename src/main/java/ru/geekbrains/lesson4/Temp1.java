package ru.geekbrains.lesson4;

import java.util.TreeMap;

public class Temp1 {

    private final Object mon = new Object(); // создаем монитор
    private char currentLetter = 'A'; // созадем переменную

    public static void main(String[] args) {


        Temp1 temp1 = new Temp1();
        new Thread(() -> {
            temp1.printA();
        }).start();
        new Thread(() -> {
            temp1.printB();
        }).start();
        new Thread(() -> {
            temp1.printC();
        }).start();
    }


     public  void printA () {
         //  включили экран
         synchronized (mon) { // включили экран
             try {
                 for (int i = 0; i < 5; i++) {
                     while (currentLetter != 'A') {
                         mon.wait(); // монитор отключается, ждет
                     }
                     System.out.print("A");
                     currentLetter = 'B';
                     mon.notifyAll(); //  разбудть всех потоки
                     Thread.sleep(2500);
                 }
             }  catch (InterruptedException e) {
                     e.printStackTrace();
             }
         }
     }

    public  void printB () {
        //  включили экран
        synchronized (mon) { // включили экран
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        mon.wait(); // монитор отключается
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    mon.notifyAll(); //  разбудть всех или уведомить
                    Thread.sleep(1);
                }
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public  void printC () {
        //  включили экран
        synchronized (mon) { // включили экран
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        mon.wait(); // монитор  в этом состоянии освобождается
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    mon.notifyAll(); //  разбудть всех потоки
                    Thread.sleep(10);
                }
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
