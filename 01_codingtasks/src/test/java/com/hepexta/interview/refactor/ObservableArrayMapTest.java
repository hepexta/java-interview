package com.hepexta.interview.refactor;

import org.junit.Test;

import java.util.Arrays;

public class ObservableArrayMapTest {
    @Test
    public void observableTest() {
        ObservableArrayMap map = new ObservableArrayMap() {
            @Override
            protected boolean hasChanges(byte[] oldValue, byte[] newValue) {
                return Arrays.equals(oldValue, newValue);
            }
        };

        ListenerImpl x = new ListenerImpl(1);
        map.addListener(x);
        map.addListener(new ListenerImpl(2));
        map.addListener(new ListenerImpl(3));

        map.put(new byte[]{1, 2, 3}, new byte[]{1, 2, 3});
        map.put(new byte[]{1, 3, 3}, new byte[]{1, 3, 3});
        map.put(new byte[]{1, 3, 4}, new byte[]{1, 3, 4});
        map.put(new byte[]{1, 3, 4}, new byte[]{1, 3, 4});

        map.removeListener(x);

        map.put(new byte[]{1, 3, 4}, new byte[]{1, 3, 4});
    }
}
