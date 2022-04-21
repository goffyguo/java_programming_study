package com.guofei.mvc.event;

import java.time.Clock;
import org.springframework.context.ApplicationEvent;

/**
 * 定义注册事件
 * @author guofei
 * @date 2022/4/21 6:15 PM
 */
public class UserRegisterEvent extends ApplicationEvent {

  private String username;

  public UserRegisterEvent(Object source) {
    super(source);
  }

  public UserRegisterEvent(String source, Clock clock) {
    super(source, clock);
    this.username = source;
  }

  public String getUsername() {
    return username;
  }
}
