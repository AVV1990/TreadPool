package ru.geekbrains.lesson4;

import java.util.TreeMap;
import java.util.concurrent.*;

public class Temp {
    public static void main(String[] args) throws InterruptedException {
        // ниже стандартный запуск треда
//        Thread t = new Thread(() -> {
//            System.out.println(1);
//        });
//        t.start();

        // создаем пул  на 4 потока, больше чем 4 задачи паралелльно он несможет выполнять
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future <String> future = executorService.submit(new Callable<String>() { // future   это инфморация о синхронной выполняемой задаче
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Java";
            }
        });

        try {
            String s = future.get();
            System.out.println(s);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();


////        ExecutorService executorService2  = Executors.newSingleThreadExecutor(); //  один поток
//
//
//        for (int i = 0; i <5 ; i++) {
//            executorService.execute(() -> { // .execute  -это команда запуска
//                System.out.println("START TASK");
//                try {
//                    Thread.sleep(5000); // поспим 2 сек
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("START END");
//            });
//        }
//        executorService.shutdown(); //  приостанавливаем поток
//        executorService.awaitTermination(10, TimeUnit.MINUTES); // ждем когда все потоки завершаться в течение 10 минут, это  некий таймаут на опр время
//        System.out.println("END");

//
//        ExecutorService executorService2  = Executors.newFixedThreadPool(4,new ThreadFactory() { // ThreadFactory - фабрика потоков
//            @Override
//            public Thread newThread(Runnable r) {
//                System.out.println("Tread created");
//                return new Thread(r);
//            }
//        });
//        executorService2.execute(() -> System.out.println(1));
//
//        Thread.sleep(2000);
//        executorService2.execute(() -> System.out.println(1));
//        executorService2.execute(() -> System.out.println(1));
//        executorService2.execute(() -> System.out.println(1));
//        executorService2.execute(() -> System.out.println(1));
//        executorService2.execute(() -> System.out.println(2));
//        executorService2.execute(() -> System.out.println(2));
//        executorService2.shutdown();

    }


}