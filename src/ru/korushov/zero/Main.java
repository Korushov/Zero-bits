package ru.korushov.zero;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 * @author Vitaly Korushov
 */

public class Main {
    public static void main(String[] args) throws Exception {

        long time = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream(args[0]);
        int fileSize = fis.available();
        int threadSize = fileSize/Integer.parseInt(args[1]);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Integer.parseInt(args[1]);

        //Список для хранения результатов от каждого потока
        List<Future<Integer>> zerosOfEachThread = new ArrayList<>();

        int startPoint = 0;
        int i = 0;
        while (fileSize >= threadSize) {
            Future<Integer> future = executor.submit(new Task(startPoint, threadSize, fis, i));
            zerosOfEachThread.add(future);
            fileSize -= threadSize;
            startPoint += threadSize;
            i++;
        }


        Future<Integer> future = executor.submit(new Task(startPoint, threadSize, fis, i));
        zerosOfEachThread.add(future);

        executor.shutdown();

        while (!executor.isTerminated())
        {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        }

        int allZeros = 0;
        for (Future<Integer> zeros: zerosOfEachThread) {
            allZeros += zeros.get();
        }
        System.out.println("Количество 0 бит в указанном файле: " + allZeros);
        System.out.println("Время выполнения программы: ");
        System.out.println(System.currentTimeMillis() - time);
    }
}

