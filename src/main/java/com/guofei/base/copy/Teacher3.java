package com.guofei.base.copy;

import java.io.Serializable;

/**
 * @author guofei
 * @date 2022/6/4 11:43 PM
 */
public class Teacher3 implements Serializable {
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

}
