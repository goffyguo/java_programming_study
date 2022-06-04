package com.guofei.base.copy;

/**
 * @author guofei
 * @date 2022/6/4 11:40 PM
 */
public class DeepCopy {
  public static void main(String[] args) throws Exception {
    Teacher2 teacher = new Teacher2();
    teacher.setName("Delacey");
    teacher.setAge(29);

    Student2 student1 = new Student2();
    student1.setName("Dream");
    student1.setAge(18);
    student1.setTeacher(teacher);

    Student2 student2 = (Student2) student1.clone();
    System.out.println("拷贝后");
    System.out.println(student2.getName());
    System.out.println(student2.getAge());
    System.out.println(student2.getTeacher().getName());
    System.out.println(student2.getTeacher().getAge());
    System.out.println("修改老师的信息后-------------");

    // 修改老师的信息
    teacher.setName("Jam");
    System.out.println(student1.getTeacher().getName());
    System.out.println(student2.getTeacher().getName());

    /**
     * 拷贝后
     * Dream
     * 18
     * Delacey
     * 29
     * 修改老师的信息后-------------
     * Jam
     * Delacey
     */
  }
}
