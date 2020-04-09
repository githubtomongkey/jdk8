package com.wangwenjun.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

/**
 * @author Administrator
 */
public class LambdaUsage {
    public static List<Apple> filter(List<Apple> list, Predicate<Apple> predicate){
        List emptyList = Collections.EMPTY_LIST;
        for (Apple a:list ) {
           if(predicate.test(a)){
               emptyList.add(a);
           }

        }
        return emptyList;
    }

    public static List<Apple> filterByWeight(List<Apple> list, LongPredicate predicate){
        List<Apple> emptyList = new ArrayList();
        for (Apple a:list ) {
            if(predicate.test(a.getWeight())){
                emptyList.add(a);
            }

        }
        return emptyList;
    }
    public static void simpleTestConsumer(List<Apple> list, Consumer<Apple> consumer){
        List<Apple> emptyList = new ArrayList();
        for (Apple a:list ) {

    consumer.accept(a);
        }

    }


    public static void simpleBiConsumer(String color,List<Apple> list, BiConsumer<Apple,String> consumer){
        List<Apple> emptyList = new ArrayList();
        for (Apple a:list ) {

            consumer.accept(a,color);
        }

    }

    public static Apple testBiFunction(String color,Long weight,BiFunction<String,Long,Apple> fun){
        return fun.apply(color,weight);
    }




    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),new Apple("yellow", 120),
                new Apple("green", 170),new Apple("red", 140),
                new Apple("blue", 130),new Apple("gray", 160),
                new Apple("green", 170));

        Apple gray = testBiFunction("gray", 158L, (c, s) -> {
            return new Apple(c, s);


        });
        System.out.println(gray);
//        testConsumer(list);
//        testLongPredicate(list);
//        filterPredicate(list);

//        testLambda();
    }

    private static void testConsumer(List<Apple> list) {
        simpleTestConsumer(list,(apple)-> System.out.println(apple));
        simpleBiConsumer("red",list,(a,s)->{
            if (a.getColor().equals(s)){
                System.out.println(a);
            }
        });
    }

    private static void testLongPredicate(List<Apple> list) {
        List<Apple> apples = filterByWeight(list, b -> b > 130);
        System.out.println(apples);
    }

    private static void filterPredicate(List<Apple> list) {
        List<Apple> filter = filter(list, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equalsIgnoreCase("green");
            }
        });
        System.out.println(filter);
    }

    private static void testLambda() {
        Runnable r1=()->{
            System.out.println("Hello");
        };


        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        process(r1);
        process(r2);
        process(()-> System.out.println("Hello"));
    }

    public static void process(Runnable runnable){
        runnable.run();

    }
}
