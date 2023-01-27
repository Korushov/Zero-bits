package ru.korushov.zero;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Vitaly Korushov
 */
public class Task implements Callable<Integer> {

    int zeroCounter;

    int pointer;

    int size;

    FileInputStream fis;

    int sequence;

    public Task(int pointer, int size, FileInputStream fis, int sequence) {
        this.pointer = pointer;
        this.size = size;
        this.fis = fis;
        this.sequence = sequence;
    }

    @Override
    public Integer call() throws IOException {
        return checkForZeros(pointer, size);
    }


    public int checkForZeros(int pointer, int size) throws IOException {
        int zeroCounter = 0;
        byte[] b = new byte[size];
        System.out.println("Мне нужно проверить " + size + " байт");
        fis.skip(pointer);
        fis.read(b, 0, size);
        for (byte currentByte: b) {
            while (currentByte > 1) {
                if (currentByte%2 == 0) zeroCounter++;
                currentByte = (byte) (currentByte / 2);
            }
        }

        System.out.println("Checking bytes " + Thread.currentThread().getName() + " zeros " + zeroCounter);
        return zeroCounter;
    }



}
