package com.wangwenjun.streams;

import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
public class StreamMatch {
    public static void main(String[] args) {
        List<Integer> stream = Arrays.asList(new Integer[]{1,3,2,4,5,7,6,9,8});
        boolean b = stream.stream().allMatch(i -> i > 0);
        System.out.println(b);
        assert b:"some elements not mached";
    }
}
