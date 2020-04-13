package com.wangwenjun.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Administrator
 */
public class NumericStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1,3,2,4,5,7,6,9,8});
        Integer result = stream.filter(i -> i.intValue() > 3).reduce(Integer::sum).get();
        System.out.println(result);
        stream = Arrays.stream(new Integer[]{1,3,2,4,5,7,6,9,8});
        int sum = stream.mapToInt(Integer::intValue).filter(i -> i > 3).sum();
        System.out.println(sum);


    }
}
