package com.wangwenjun.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
public class StreamMap {
    public static void main(String[] args) {
//        List<Integer> list= Arrays.asList(1,3,2,5,4,6,7,9,34,23,12,46);
//        List<Integer> collect = list.stream().map(d -> d * 2).collect(Collectors.toList());
//        System.out.println(collect);
//        listDish().stream().map(dish -> dish.getName()).forEach(System.out::println);

//        flatMap map( 扁平化)

        String[] strings = {"Hello", "World"};
//        此处返回的是集合中是数组,其实我们想要的是一个集合中返回String 这样与我们的预期不符合
        List<String[]> collect = Arrays.stream(strings).map(w -> w.split("")).distinct().collect(Collectors.toList());

        List<String> collect1 = Arrays.stream(strings).map(w -> w.split("")).flatMap(d -> Arrays.stream(d)).distinct().collect(Collectors.toList());
        System.out.println(collect1);

    }

    public static List<Dish> listDish(){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", false, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        return menu;
    }
}
