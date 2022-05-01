package com.guofei.base.annotations;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.val;

/**
 * @author: GuoFei
 * @date: 2022-05-01 16:09
 *
 * 读取被注解的PasswordUtils，然后利用反射来查找 @usercase 标签，通过给定的id值列表，该注解列出了它找到的所有用例，并报告所有丢失的用例
 */
public class UserCaseTracker {

  public static  void trackUseCases(List<Integer> useCases,Class<?> cl){
    for (Method m : cl.getDeclaredMethods()) {
      final val annotation = m.getAnnotation(UserCase.class);
      if (annotation != null) {
        System.out.println("Found Use Case " +annotation.id() + "\n" + annotation.description());
        useCases.remove(Integer.valueOf(annotation.id()));
      }
    }
    useCases.forEach(i->
            System.out.println("Missing use case "+i)
        );
  }

  public static void main(String[] args) {
    final val collect = IntStream.range(47, 51).boxed().collect(Collectors.toList());
    trackUseCases(collect,PasswordUtils.class);
  }
}
