package com.guofei.base.copy;

/**
 * @author guofei
 * @date 2022/6/4 11:13 PM 深拷贝 浅拷贝
 */
public class CopyTest {

  public static void main(String[] args) throws CloneNotSupportedException {
    //referenceCopy();
    objectCopy();
  }


  /**
   * 引用拷贝:由输出结果可以看出，它们的地址值是相同的，那么它们肯定是同一个对象 teacher和otherteacher的只是引用而已，他们都指向了一个相同的对象Teacher(“zhangsan”,55)
   */
  public static void referenceCopy() {
    Teacher teacher = new Teacher();
    teacher.setName("zhangsan");
    teacher.setAge(55);
    Teacher otherTeacher = teacher;
    System.out.println(teacher); //Teacher@5a10411
    System.out.println(otherTeacher); //Teacher@5a10411
  }


  /**
   * 对象拷贝:由输出结果可以看出，它们的地址是不同的，也就是说创建了新的对象， 而不是把原对象的地址赋给了一个新的引用变量,这就叫做对象拷贝。
   */
  public static void objectCopy() throws CloneNotSupportedException {
    Teacher teacher = new Teacher();
    teacher.setName("zhangsan");
    teacher.setAge(55);
    Teacher otherteacher = (Teacher) teacher.clone();
    System.out.println(teacher); //Teacher@5a10411
    System.out.println(otherteacher); //Teacher@2ef1e4fa
  }
}



