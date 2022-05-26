package com.guofei.base.java8;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author guofei
 * @date 2022/5/25 10:55 AM
 */
public class DishMain {

  public static void main(String[] args) {

  }



  private List<String> beforeJava7(List<Dish> dishes){
    ArrayList<Dish> list = new ArrayList<>();
    for (Dish dish : dishes) {
      if (dish.getCalories()<400){
        list.add(dish);
      }
    }

    Collections.sort(list, new Comparator<Dish>() {
      @Override
      public int compare(Dish o1, Dish o2) {
        return Integer.compare(o1.getCalories(),o2.getCalories());
      }
    });

    ArrayList<String> objects = new ArrayList<>();
    for (Dish dish : list) {
      objects.add(dish.getName());
    }
    return objects;
  }
  private List<String> afterJava8(List<Dish> dishes){
    return dishes.stream()
        .filter(d->d.getCalories()<4000)
        .sorted(Comparator.comparing(Dish::getCalories))
        .map(Dish::getName)
        .collect(Collectors.toList());
  }



}
