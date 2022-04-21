package com.guofei.base.dateTest;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: GuoFei
 * @date: 2022-03-22 14:19
 */
public class CurrentTimeMillisClock {
  private volatile long now;

  private CurrentTimeMillisClock() {
    this.now = System.currentTimeMillis();
    scheduleTick();
  }

  private void scheduleTick() {
    new ScheduledThreadPoolExecutor(1, runnable -> {
      Thread thread = new Thread(runnable, "current-time-millis");
      thread.setDaemon(true);
      return thread;
    }).scheduleAtFixedRate(() -> {
      now = System.currentTimeMillis();
    }, 1, 1, TimeUnit.MILLISECONDS);
  }

  public long now() {
    return now;
  }

  public static CurrentTimeMillisClock getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {
    private static final CurrentTimeMillisClock INSTANCE = new CurrentTimeMillisClock();
  }
}
