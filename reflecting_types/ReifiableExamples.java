package com.bkitsolution.reflecting_types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReifiableExamples {
    public static class StringList extends ArrayList<String> {

    }

    public static void main(String[] args) {
//        List<String> strings = new ArrayList<>();
//        Class<?> arrayList = strings.getClass();
//        final TypeVariable<? extends  Class<?>>[] typeParameters =
//                arrayList.getTypeParameters();
//        System.out.println(arrayList);
//        System.out.println(Arrays.toString(typeParameters));
//        System.out.println(arrayList.toString());
//        System.out.println(arrayList.toGenericString());
        final ParameterizedType arrayListOfString =
                (ParameterizedType) StringList.class.getGenericSuperclass();

        System.out.println(Arrays.toString(arrayListOfString.getActualTypeArguments()));
    }
}
