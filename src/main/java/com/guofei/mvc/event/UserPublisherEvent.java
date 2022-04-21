package com.guofei.mvc.event;

import java.time.Clock;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * 注册事件发布者
 * @author guofei
 * @date 2022/4/21 6:27 PM
 */
@Service
@Slf4j
public class UserPublisherEvent implements ApplicationEventPublisherAware {

  @Resource
  private ApplicationEventPublisher eventPublisher;

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.eventPublisher=applicationEventPublisher;
  }
/*
  *//**
   * 发布事件
   * @param userName
   *//*
  public void register(String userName){
    log.info("执行用户[{}]的注册逻辑", userName);
    applicationEventPublisher.publishEvent(new UserRegisterEvent(userName, Clock.systemUTC()));
  }*/
}
