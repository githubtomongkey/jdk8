package com.wangwenjun.streams;

import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
public class StreamReduce {
    public static void main(String[] args) {
        List<Integer> stream = Arrays.asList(new Integer[]{1,3,2,4,5,7,6,9,8});
        Integer reduce = stream.stream().reduce(0, (i, j) -> i + j);
//        聚合函数
        System.out.println(reduce);
        stream.stream().reduce((i, j) -> i + j).ifPresent(System.out::println);
    }
}
