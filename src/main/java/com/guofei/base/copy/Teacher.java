package com.guofei.base.copy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author guofei
 * @date 2022/6/4 11:26 PM
 */
@Getter
@Setter
public class Teacher implements Cloneable {

  private String name;
  private Integer age;

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
