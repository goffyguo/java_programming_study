package com.guofei.example;


import java.util.Date;

/**
 * @author chenqiang
 * @date  2020-08-05
 */
public class CalendarEventRoom {

  /**
   * id
   */
  private int id;

  /**
   * 事件id
   */
  private int calendarEventId;

  /**
   * 开始时间
   */
  private Date beginTime;

  /**
   * 开始时间戳
   */
  private long beginTimeStamp;

  /**
   * 会议所属日期
   */
  private Date meetingDay;

  /**
   * 结束时间
   */
  private Date endTime;

  /**
   * 结束时间戳
   */
  private long endTimeStamp;

  /**
   * 会议时长分钟
   */
  private int duration;

  /**
   * 会议室id
   */
  private int roomId;

  /**
   * 会议标识
   */
  private String calendarIdentity;

  /**
   * 用户会议标识，exchange专用
   */
  private String userCalendarId;

  /**
   * 第三方会议室邮箱
   */
  private String syncRoomEmail;

  /**
   * 三方会议室标识
   */
  private String syncRoomIdentity;

  /**
   * 公司ID
   */
  private int companyId;

  /**
   * 创建时间
   */
  private Date createTime;

  /**
   * 修改时间
   */
  private Date modifiyTime;

  /**
   * 删除状态0正常其他删除
   */
  private int isDel;

  /**
   * 时区
   */
  private String timeZone;

  /**
   * 是否全部签到1签到0未签到
   */
  private int checkAll;

  /**
   * 循环事件master事件id
   */
  private String recurringEventId;

  /**
   * 会议状态  会议状态 0 默认值  1 已开启  2  已结束  3  未签到被取消  4 确认中 循环事件创建时使用
   */
  private int meetingStatus;



  /**
   * id
   */
  public int getId() {
    return id;
  }

  /**
   * id
   */
  public void setId(int id) {
    this.id = id;
  }


  /**
   * 事件id
   */
  public int getCalendarEventId() {
    return calendarEventId;
  }

  /**
   * 事件id
   */
  public void setCalendarEventId(int calendarEventId) {
    this.calendarEventId = calendarEventId;
  }


  /**
   * 开始时间
   */
  public Date getBeginTime() {
    return beginTime;
  }

  /**
   * 开始时间
   */
  public void setBeginTime(Date beginTime) {
    this.beginTime = beginTime;
  }


  /**
   * 开始时间戳
   */
  public long getBeginTimeStamp() {
    return beginTimeStamp;
  }

  /**
   * 开始时间戳
   */
  public void setBeginTimeStamp(long beginTimeStamp) {
    this.beginTimeStamp = beginTimeStamp;
  }


  /**
   * 会议所属日期
   */
  public Date getMeetingDay() {
    return meetingDay;
  }

  /**
   * 会议所属日期
   */
  public void setMeetingDay(Date meetingDay) {
    this.meetingDay = meetingDay;
  }


  /**
   * 结束时间
   */
  public Date getEndTime() {
    return endTime;
  }

  /**
   * 结束时间
   */
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }


  /**
   * 结束时间戳
   */
  public long getEndTimeStamp() {
    return endTimeStamp;
  }

  /**
   * 结束时间戳
   */
  public void setEndTimeStamp(long endTimeStamp) {
    this.endTimeStamp = endTimeStamp;
  }


  /**
   * 会议时长分钟
   */
  public int getDuration() {
    return duration;
  }

  /**
   * 会议时长分钟
   */
  public void setDuration(int duration) {
    this.duration = duration;
  }


  /**
   * 会议室id
   */
  public int getRoomId() {
    return roomId;
  }

  /**
   * 会议室id
   */
  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }


  /**
   * 会议标识
   */
  public String getCalendarIdentity() {
    return calendarIdentity;
  }

  /**
   * 会议标识
   */
  public void setCalendarIdentity(String calendarIdentity) {
    this.calendarIdentity = calendarIdentity;
  }


  /**
   * 用户会议标识，exchange专用
   */
  public String getUserCalendarId() {
    return userCalendarId;
  }

  /**
   * 用户会议标识，exchange专用
   */
  public void setUserCalendarId(String userCalendarId) {
    this.userCalendarId = userCalendarId;
  }


  /**
   * 第三方会议室邮箱
   */
  public String getSyncRoomEmail() {
    return syncRoomEmail;
  }

  /**
   * 第三方会议室邮箱
   */
  public void setSyncRoomEmail(String syncRoomEmail) {
    this.syncRoomEmail = syncRoomEmail;
  }


  /**
   * 三方会议室标识
   */
  public String getSyncRoomIdentity() {
    return syncRoomIdentity;
  }

  /**
   * 三方会议室标识
   */
  public void setSyncRoomIdentity(String syncRoomIdentity) {
    this.syncRoomIdentity = syncRoomIdentity;
  }


  /**
   * 公司ID
   */
  public int getCompanyId() {
    return companyId;
  }

  /**
   * 公司ID
   */
  public void setCompanyId(int companyId) {
    this.companyId = companyId;
  }


  /**
   * 创建时间
   */
  public Date getCreateTime() {
    return createTime;
  }

  /**
   * 创建时间
   */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  /**
   * 修改时间
   */
  public Date getModifiyTime() {
    return modifiyTime;
  }

  /**
   * 修改时间
   */
  public void setModifiyTime(Date modifiyTime) {
    this.modifiyTime = modifiyTime;
  }


  /**
   * 删除状态0正常其他删除
   */
  public int getIsDel() {
    return isDel;
  }

  /**
   * 删除状态0正常其他删除
   */
  public void setIsDel(int isDel) {
    this.isDel = isDel;
  }


  /**
   * 时区
   */
  public String getTimeZone() {
    return timeZone;
  }

  /**
   * 时区
   */
  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }


  /**
   * 是否全部签到1签到0未签到
   */
  public int getCheckAll() {
    return checkAll;
  }

  /**
   * 是否全部签到1签到0未签到
   */
  public void setCheckAll(int checkAll) {
    this.checkAll = checkAll;
  }


  /**
   * 循环事件master事件id
   */
  public String getRecurringEventId() {
    return recurringEventId;
  }

  /**
   * 循环事件master事件id
   */
  public void setRecurringEventId(String recurringEventId) {
    this.recurringEventId = recurringEventId;
  }



  /**
   * 获取 会议状态  会议状态 0 默认值  1 已开启  2  已结束  3  未签到被取消
   */
  public int getMeetingStatus() {
    return this.meetingStatus;
  }

  /**
   * 设置 会议状态  会议状态 0 默认值  1 已开启  2  已结束  3  未签到被取消
   */
  public void setMeetingStatus(int meetingStatus) {
    this.meetingStatus = meetingStatus;
  }

}
