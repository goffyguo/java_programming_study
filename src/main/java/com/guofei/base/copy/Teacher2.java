package com.guofei.base.copy;

/**
 * @author guofei
 * @date 2022/6/4 11:41 PM
 */
public class Teacher2 implements Cloneable {
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

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

}