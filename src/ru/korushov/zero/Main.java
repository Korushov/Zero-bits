package ru.korushov.zero;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Vitaly Korushov
 */

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "src/zero-bits.txt";
        MyBytes myBytes = new MyBytes();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            myBytes.setBites(fis.readAllBytes());
        } catch (IOException e) {
            throw new IOException();
        }

        MyThread myThread = new MyThread(myBytes);
        myThread.run();
        System.out.println(myThread.returnCount());
    }
}

