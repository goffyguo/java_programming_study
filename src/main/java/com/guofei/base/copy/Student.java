package com.guofei.base.copy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author guofei
 * @date 2022/6/4 11:36 PM
 */
@Getter
@Setter
public class Student implements Cloneable{

  private String name;
  private int age;
  private Teacher teacher;

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
