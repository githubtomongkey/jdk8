package com.wangwenjun.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
public class StreamFilter {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,3,2,5,4,6,7,9,34,23,12,46);
        List<Integer> result = list.stream().filter(d -> d % 2 == 0).collect(Collectors.toList());
//        System.out.println(result);
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
//        System.out.println(collect);
        List<Integer> collect1 = list.stream().skip(5).collect(Collectors.toList());
        System.out.println(collect1);


    }


}
