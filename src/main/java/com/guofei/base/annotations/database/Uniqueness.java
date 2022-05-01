package com.guofei.base.annotations.database;

/**
 * @author: GuoFei
 * @date: 2022-05-01 16:36
 */
public @interface Uniqueness {
  Constraints constraints() default @Constraints(unique = true);
}

