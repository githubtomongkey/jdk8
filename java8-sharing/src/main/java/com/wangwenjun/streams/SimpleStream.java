package com.wangwenjun.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
public class SimpleStream {

    private static final int CALORIES = 400;

    public static void main(String[] args) {
//  have a dish List
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
//            menu.stream().forEach(System.out::println);
        List<String> collect = menu.stream().filter(dish -> {
            System.out.println("filtering->" + dish.getName());
            return dish.getCalories() > CALORIES;
        }).map(dish -> {
            System.out.println("map->" + dish.getName());
            return dish.getName();
        }).limit(3).collect(Collectors.toList());
        System.out.println(collect);


//        List<String> dishNamesByCollections = getDishNamesByCollections(menu);
//        System.out.println(dishNamesByCollections);
//        List<String> dishNamesByStream = getDishNamesByStream(menu);
//        System.out.println(dishNamesByStream);


    }
    private static List<String> getDishNamesByStream(List<Dish> menu) {
        return   menu.stream().filter(dish -> dish.getCalories()<CALORIES)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());

    }
    private static List<String> getDishNamesByCollections(List<Dish> menu) {
        List<Dish> lowCalories = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < CALORIES) {
                lowCalories.add(dish);
            }
        }
        Collections.sort(lowCalories, (o1, o2) -> Integer.compare(o1.getCalories(), o2.getCalories()));
        List<String> dishNameList=new ArrayList<>();
        for (Dish d:lowCalories ) {
            dishNameList.add(d.getName());
        }


        return dishNameList;
}
}
