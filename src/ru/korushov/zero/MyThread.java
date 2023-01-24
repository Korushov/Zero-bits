package ru.korushov.zero;

import java.util.Arrays;

/**
 * @author Vitaly Korushov
 */
public class MyThread extends Thread {

    MyBytes myBytes;

    long countedZeros = 0;

    public MyThread(MyBytes myBytes) {
        this.myBytes = myBytes;
    }

    @Override
    public void run() {
        for (byte b: myBytes.getBytes()) {
                System.out.println("Byte for checking " + Integer.toBinaryString(b));
                while (b > 1) {
                    if (b%2 == 0) countedZeros++;
                    b = (byte) (b / 2);
                    System.out.println("Checked bytes " + myBytes.getCheckedBytes());
                }
                System.out.println("Count of zero-bites " + countedZeros);
                myBytes.setCheckedBytes(myBytes.getCheckedBytes() + 1);
            }
            System.out.println("Bytes Array "+ Arrays.toString(myBytes.getBytes()));
    }

    public long returnCount() {
        return countedZeros;
    }
}
