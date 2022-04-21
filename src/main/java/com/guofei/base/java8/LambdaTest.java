package com.guofei.base.java8;

import com.guofei.mvc.domain.TUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author: GuoFei
 * @date: 2022-03-20 21:15
 */
public class LambdaTest {

  public static void main(String[] args) {

    new Thread(()-> System.out.println("I am running")).start();

    BiConsumer<Random,Integer> biConsumer = (random,integer)->{
      for (int i = 0; i < integer; i++) {
        System.out.println("next random= "+random.nextInt());
      }
    };

    /**
     * 有一个 Student 的 list，把它转换成一个 map，
     * key 是 student 对象的 id，value 就是 student 对象本身
     */
    List<TUser> list = new ArrayList<>();
    Map<Integer, TUser> collect = list.stream()
        .collect(Collectors.toMap(TUser::getId, a -> a, (a, b) -> a));

    final Comparable<Integer> integerComparable = new Comparable() {
      @Override
      public int compareTo(Object o) {
        return 0;
      }
    };

  }

}
