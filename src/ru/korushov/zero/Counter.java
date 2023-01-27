package ru.korushov.zero;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Vitaly Korushov
 */
public class Counter {

    //Счетчик битов равных нулю
    AtomicInteger zeroCounter;

    //Указатель с какого места нужно читать байты
    AtomicInteger pointer;

    public Counter(AtomicInteger zeroCounter, AtomicInteger pointer) {
        this.zeroCounter = zeroCounter;
        this.pointer = pointer;
    }
}
