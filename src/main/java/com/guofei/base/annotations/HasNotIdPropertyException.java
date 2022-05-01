package com.guofei.base.annotations;

/**
 * @author: GuoFei
 * @date: 2022-05-01 16:00
 * 自定义异常
 */

public class HasNotIdPropertyException extends RuntimeException{
  public HasNotIdPropertyException(){

  }
  public HasNotIdPropertyException(String s){
    super(s);
  }
}
