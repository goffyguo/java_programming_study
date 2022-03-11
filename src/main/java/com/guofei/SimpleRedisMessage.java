package com.guofei;

import lombok.Data;

/**
 * @author: GuoFei
 * @date: 2022-03-10 21:01
 */
@Data
public class SimpleRedisMessage {
  private Object data;

  @Override
  public String toString() {
    return "SimpleRedisMessage{" +
        "data=" + data +
        '}';
  }
}
