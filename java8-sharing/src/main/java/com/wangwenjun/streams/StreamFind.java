package com.wangwenjun.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author Administrator
 * 2020-04-10
 */
public class StreamFind {
    public static void main(String[] args) {
        List<Integer> stream = Arrays.asList(new Integer[]{1, 3, 2, 4, 5, 7, 6, 9, 8});
        Optional<Integer> any = stream.stream().filter(i -> i % 2 == 0).findAny();
        System.out.println(any.get());
        Optional<Integer> first = stream.stream().filter(i -> i % 2 == 0).findFirst();
        System.out.println(first.get());


    }

    private static int find(Integer[] values, int defaultValue, Predicate<Integer> predicate) {

        for (int i : values) {
            if (predicate.test(i)) {
                return i;
            }

        }
        return defaultValue;
    }
}
