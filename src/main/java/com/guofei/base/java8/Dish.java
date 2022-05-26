package com.guofei.base.java8;

import java.lang.reflect.Type;
import lombok.Getter;
import lombok.Setter;

/**
 * @author guofei
 * @date 2022/5/25 10:54 AM
 */
@Getter
@Setter
public class Dish {

  private String name;
  private boolean vegetarian;
  private int calories;
  private Type type;
}
