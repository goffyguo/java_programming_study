package com.guofei.java8;

/**
 * @author: GuoFei
 * @date: 2022-03-20 21:21
 */
@FunctionalInterface
public interface BiFunction<T,U,R> {
  R accept(T t,U u);

}
