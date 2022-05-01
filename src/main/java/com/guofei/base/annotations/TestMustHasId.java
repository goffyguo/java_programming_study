package com.guofei.base.annotations;

import java.lang.reflect.Field;
import lombok.val;

/**
 * @author: GuoFei
 * @date: 2022-05-01 16:02
 */
public class TestMustHasId {

  public static void main(String[] args) throws ClassNotFoundException {
    // 获取类
    Class userClass = Class.forName("com.guofei.base.annotations.User");
    // 判断类上是否存在Id注解
    if (userClass.isAnnotationPresent(MustHasIdPropertyAnnotation.class)){
      // 当一个类上面有@MustHasIdPropertyAnnotation注解的时候，要求类中必须存在int类型的id属性
      // 如果没有int类型的id属性则报异常。
      // 获取类的属性
      Field[] fields = userClass.getDeclaredFields();
      // 给一个默认的标记
      boolean isOk = false;
      for(Field field : fields){
        if("id".equals(field.getName()) && "int".equals(field.getType().getSimpleName())){
          // 表示这个类是合法的类。有@Id注解，则这个类中必须有int类型的id
          // 表示合法
          isOk = true;
          break;
        }
      }

      // 判断是否合法
      if(!isOk){
        throw new HasNotIdPropertyException("被@MustHasIdPropertyAnnotation注解标注的类中必须要有一个int类型的id属性！");
      }
    }

  }

}
