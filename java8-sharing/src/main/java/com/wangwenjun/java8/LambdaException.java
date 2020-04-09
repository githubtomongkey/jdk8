package com.wangwenjun.java8;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Administrator
 */
public class LambdaException {
    public static void main(String[] args) {
        Comparator<Apple> comparator = new Comparator<Apple>() {

            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };
        List emptyList = Collections.emptyList();
        emptyList.sort(comparator);
         Function<String,Integer> flambda = s -> s.length();
        Predicate<Apple> p=(Apple a)->a.getColor().equalsIgnoreCase("green");

    }
}
