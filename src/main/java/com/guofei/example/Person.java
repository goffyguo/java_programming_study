package com.guofei.example;

import java.io.Serializable;
import lombok.Data;

/**
 * @author: GuoFei
 * @date: 2022-03-09 20:40
 */
// @Message
@Data
public class Person implements Serializable {

  private String id;
  private String name;
  private String age;

  public Person(){

  }

  public Person(String id, String name, String age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

}
