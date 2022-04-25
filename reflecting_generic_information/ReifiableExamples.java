package com.bkitsolution.reflecting_generic_information;

import java.util.ArrayList;
import java.util.List;

public class ReifiableExamples {
    public static void main(String[] args) {
        System.out.println(int.class);

        System.out.println(String.class);

        List<?> wildcards = new ArrayList<>();
        System.out.println(wildcards.getClass());

        List raw = new ArrayList();
        System.out.println(raw.getClass());
        System.out.println(raw.getClass() == wildcards.getClass());

        System.out.println(int[].class);
        System.out.println(List[].class);
    }
}
