package com.guofei.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: GuoFei
 * @date: 2022-05-01 15:58
 *  这个注解id用来标识类，被标识的类中必须有一个int类型的id属性，没有就报错
 */
// 表示这个注解只能出现在类上面
@Target({ElementType.TYPE})
// 可以被反射机制读取到
@Retention(RetentionPolicy.RUNTIME)
public @interface MustHasIdPropertyAnnotation {

}
