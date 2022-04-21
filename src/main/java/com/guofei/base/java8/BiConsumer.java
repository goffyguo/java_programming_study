package com.guofei.base.java8;

/**
 * @author: GuoFei
 * @date: 2022-03-20 21:19
 */
@FunctionalInterface
public interface BiConsumer<T,U> {
  void accept(T t,U u);
}
