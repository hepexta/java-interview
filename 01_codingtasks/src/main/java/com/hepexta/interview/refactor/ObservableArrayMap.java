package com.hepexta.interview.refactor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class ObservableArrayMap {

    private Collection<Listener> listeners = new CopyOnWriteArrayList<>();
    private Map<MyClass, byte[]> valueMap = new ConcurrentHashMap<>();


    public void addListener(Listener x) {
        listeners.add(x);
    }

    public void removeListener(Listener x) {
        listeners.remove(x);
    }

    public void put(byte[] key, byte[] value) {
        byte[] oldValue = valueMap.put(new MyClass(key), value);
        if (hasChanges(oldValue, value)) {
            for (Listener x : listeners) {
                x.onChange(key, value);
            }
        }
    }

    protected abstract boolean hasChanges(byte[] oldValue, byte[] newValue);

    @Data
    @AllArgsConstructor
    private class MyClass {
        byte[] key;
    }
}
