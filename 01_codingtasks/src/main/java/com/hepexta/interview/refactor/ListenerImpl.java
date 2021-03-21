package com.hepexta.interview.refactor;

import java.util.Arrays;

public class ListenerImpl implements Listener {
    private int i = 0;
    public ListenerImpl(int i) {
        this.i = i;
    }

    @Override
    public void onChange(byte[] key, byte[] value) {
        System.out.println(i + " " + Arrays.toString(value));
    }
}
