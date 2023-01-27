package ru.korushov.zero;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Vitaly Korushov
 */
public class Task implements Callable<Integer> {

    int startPoint;

    int threadSize;

    FileInputStream fis;

    int sequence;

    public Task(int startPoint, int threadSize, FileInputStream fis, int sequence) {
        this.startPoint = startPoint;
        this.threadSize = threadSize;
        this.fis = fis;
        this.sequence = sequence;
    }

    @Override
    public Integer call() throws IOException {
        return checkForZeros(startPoint, threadSize);
    }


    public int checkForZeros(int startPoint, int threadSize) throws IOException {
        int zeroCounter = 0;
        byte[] b = new byte[threadSize];
        System.out.println(Thread.currentThread().getName() + "Мне нужно проверить " + threadSize + " байт");
//        fis.skip(startPoint);
        fis.read(b, 0, threadSize);
        System.out.println(Thread.currentThread().getName() + Arrays.toString(b));
        for (byte currentByte: b) {
            System.out.println(Thread.currentThread().getName() + "Проверяю байт " + currentByte + " на наличие нулей" );
            while (currentByte > 1) {
                if (currentByte%2 == 0) zeroCounter++;
                currentByte = (byte) (currentByte / 2);
                System.out.println(Thread.currentThread().getName() + "Нашел " + zeroCounter + "нулей");
            }
        }

        System.out.println("Checking bytes " + Thread.currentThread().getName() + " zeros " + zeroCounter);
        return zeroCounter;
    }



}
