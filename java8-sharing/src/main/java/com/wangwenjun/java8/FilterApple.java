package com.wangwenjun.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
public class FilterApple {

    public interface AppleFilter{
        /**
         * 过滤条件
         * @param apple
         * @return
         */
        boolean filter(Apple apple);
    }

    public static List<Apple> findApple(List<Apple> apples,AppleFilter appleFilter){
        List<Apple> list=new ArrayList<>();
        for (Apple apple: apples  ) {
            if(appleFilter.filter(apple)){
                list.add(apple);
            }

        }
        return list;

    }

    public static class GreenAnd150WeightFilter implements AppleFilter{

        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equalsIgnoreCase("green")&&apple.getWeight()>150);
        }
    }

    public static List<Apple> findGreenApple(List<Apple> apples){
        List<Apple> list=new ArrayList<>();
        for (Apple apple: apples  ) {
            if("green".equalsIgnoreCase(apple.getColor())){
                list.add(apple);
            }

        }
        return list;
    }

    public static List<Apple> findApples(List<Apple> apples,String color){
        List<Apple> list=new ArrayList<>();
        for (Apple apple: apples  ) {
            if(color.equalsIgnoreCase(apple.getColor())){
                list.add(apple);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),new Apple("yellow", 120),
                new Apple("green", 170),new Apple("red", 140),
                new Apple("blue", 130),new Apple("gray", 160),
                new Apple("green", 170));

//        List<Apple> greenApples = findGreenApple(list);
//        assert greenApples.size()==3;

//        List<Apple> greenApples = findApples(list, "red");
        List<Apple> apple = findApple(list, new GreenAnd150WeightFilter());

        List<Apple> apple1 = findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {

                return "yellow".equalsIgnoreCase(apple.getColor());
            }
        });

        List<Apple> apple2 = findApple(list, (a) -> {
            return "red".equalsIgnoreCase(a.getColor());
        });

        System.out.println(apple2);
    }
}
