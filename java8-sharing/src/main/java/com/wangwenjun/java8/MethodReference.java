package com.wangwenjun.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Administrator
 * 2020年04月08日
 */
public class MethodReference {
    public static void main(String[] args) {
    useConsumer((s)-> System.out.println(s),"Hello Wangwenjun");

        List<Apple> list = Arrays.asList(
                new Apple("green", 150),new Apple("yellow", 120),
                new Apple("green", 170),new Apple("red", 140),
                new Apple("blue", 130),new Apple("gray", 160),
                new Apple("green", 170));

        list.sort(Comparator.comparing(Apple::getColor));
        System.out.println(list);



//    ThreeFunction<String,Long,String,ComplexApple> t=(s,l,a)-> new ComplexApple(s,l,a);
//        ThreeFunction<String,Long,String,ComplexApple> t= ComplexApple::new;
//        ComplexApple apply = t.apply("red", 345L, "香花");
//        System.out.println(apply);

    }

    public static <T> void useConsumer(Consumer<T> consumer,T t){
        consumer.accept(t);
    }
}
