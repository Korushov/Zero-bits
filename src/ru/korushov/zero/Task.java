package ru.korushov.zero;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Callable;

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
        return checkForZeros(threadSize);
    }


    public int checkForZeros(int threadSize) throws IOException {
        int zeroCounter = 0;
        byte[] b = new byte[threadSize];
        fis.read(b, 0, threadSize);
        for (byte currentByte: b) {
            while (currentByte > 1) {
                if (currentByte%2 == 0) zeroCounter++;
                currentByte = (byte) (currentByte / 2);
            }
        }
        return zeroCounter;
    }
}
