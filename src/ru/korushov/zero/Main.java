package ru.korushov.zero;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * @author Vitaly Korushov
 */

public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String fileName = "src/zero-bits.txt";
        int threadCount = 2;
//        Counter counter = new Counter(new AtomicInteger(0), new AtomicInteger(0));

        FileInputStream fis = new FileInputStream(fileName);
        int fileSize = fis.available();
        System.out.println(fileSize + " всего байт для проверки");
        int threadSize = fileSize/threadCount;

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadCount);


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

//        Future<Integer> future = executor.submit(new Task(startPoint, threadSize, fis, i));
//        zerosOfEachThread.add(future);

        executor.shutdown();

        while (!executor.isTerminated())
        {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        }


        int allZeros = 0;
        for (Future<Integer> zeros: zerosOfEachThread) {
            allZeros += zeros.get();
        }
        System.out.println("Finish all threads");
        System.out.println(allZeros);
    }
}

