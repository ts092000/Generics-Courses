package com.bkitsolution.raw_types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LegacyCode {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("abc");
        list.add(1);
        list.add(new Object());

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        legacyMethod(integers);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            final Object element = iterator.next();
            System.out.println(element);
        }
    }

    public static void legacyMethod(List list) {

    }
}
