package com.guofei.base.copy;

/**
 * @author guofei
 * @date 2022/6/4 11:41 PM
 */
public class Student2 implements Cloneable {
  private String name;
  private int age;
  private Teacher2 teacher;

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

  public Teacher2 getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher2 teacher) {
    this.teacher = teacher;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    // 浅复制时：
    // Object object = super.clone();
    // return object;

    // 改为深复制：
    Student2 student = (Student2) super.clone();
    // 本来是浅复制，现在将Teacher对象复制一份并重新set进来
    student.setTeacher((Teacher2) student.getTeacher().clone());
    return student;
  }

}
