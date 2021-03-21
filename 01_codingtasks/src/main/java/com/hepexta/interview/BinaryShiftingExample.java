package com.hepexta.interview;

import java.util.HashSet;
import java.util.Set;

public class BinaryShiftingExample {

    public static void main(String[] args) {
        int size = 1024;

        System.out.println(size);
        System.out.println(size/2);
        System.out.println(size >> 1);
        System.out.println(size/4);
        System.out.println(size >> 2);

        Set set = new HashSet();
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();
        sb.append("as");
        set.add(sb);
        set.add(sb1);
        sb.hashCode();

        System.out.println(set.contains(sb));
        System.out.println(set.contains(sb1));

        sb.append("sa");

        set.iterator().forEachRemaining(e -> {
            sb.append(" asd ");
            System.out.println(e);
        });

        System.out.println(set.contains(sb));
        System.out.println(set.contains(sb1));

    }
}
