package com.wangwenjun.java8;

/**
 * @author Administrator
 */
@FunctionalInterface
public interface ThreeFunction <T,U,K,R>{

    R apply(T t , U u, K k);
}
