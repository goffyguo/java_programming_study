package com.guofei.base.copy;

/**
 * @author guofei
 * @date 2022/6/4 11:45 PM
 */
public class DeepCopyServiceable {

  public static void main(String[] args) throws Exception {
    Teacher3 t = new Teacher3();
    t.setName("Taylor");
    t.setAge(28);

    Student3 s1 = new Student3();
    s1.setAge(20);
    s1.setName("blank space");
    s1.setTeacher(t);

    Student3 s2 = (Student3) s1.deepClone();

    System.out.println("拷贝后:");
    System.out.println(s2.getName());
    System.out.println(s2.getAge());
    System.out.println(s2.getTeacher().getName());
    System.out.println(s2.getTeacher().getAge());
    System.out.println("---------------------------");

    t.setName("swift");

    System.out.println("修改后：");
    System.out.println(s1.getTeacher().getName());
    System.out.println(s2.getTeacher().getName());

    /**
     * 拷贝后:
     * blank space
     * 20
     * Taylor
     * 28
     * ---------------------------
     * 修改后：
     * swift
     * Taylor
     */
  }

}
