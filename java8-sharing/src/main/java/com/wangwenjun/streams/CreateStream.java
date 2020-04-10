package com.wangwenjun.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Administrator
 */
public class CreateStream {
    public static void main(String[] args) {
//        createStreamFromValue().forEach(System.out::println);

        createStreamFromIterator().forEach(System.out::println);
    }
    private static Stream<String> createStreamFromCollection(){
        List<String> strings = Arrays.asList("hello", "alex", "wangwenjun", "world", "stream");
            return strings.stream();
    }

    private static Stream<String> createStreamFromValue(){
        return Stream.of("hello", "alex", "wangwenjun", "world", "stream");

    }

    private static Stream<String> createStreamFromArrays(){
        return Arrays.stream(new String[]{"hello", "alex", "wangwenjun", "world", "stream"});

    }
    private static Stream<Integer> createStreamFromIterator(){
        return Stream.iterate(0,n->n+2).limit(10);

    }
}

