package com.guofei.base.enums;

/**
 * @author guofei
 * @date 2022/5/10 3:48 PM
 */
public class ShrubberyMain {

  public static void main(String[] args) {
    for (Shrubbery value : Shrubbery.values()) {
      System.out.println(value+ " ordinal: " + value.ordinal());
      System.out.println(value.compareTo(Shrubbery.CRAWLING));
      System.out.println(value.equals(Shrubbery.CRAWLING));
      System.out.println(value == Shrubbery.CRAWLING);
      System.out.println(value.getDeclaringClass());
      System.out.println(value.name());
      System.out.println("*********************");
    }


  }

}
