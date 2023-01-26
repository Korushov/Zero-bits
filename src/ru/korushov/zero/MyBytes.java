package ru.korushov.zero;

/**
 * @author Vitaly Korushov
 */

public class MyBytes {

    private byte[] bytes;
    private long length;

    private long checkedBytes;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBites(byte[] bytes) {
        this.bytes = bytes;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getCheckedBytes() {
        return checkedBytes;
    }

    public void setCheckedBytes(long checkedBytes) {
        this.checkedBytes = checkedBytes;
    }
}
