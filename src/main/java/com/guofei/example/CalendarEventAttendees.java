package com.guofei.example;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class CalendarEventAttendees {

  public CalendarEventAttendees() {
  }

  public CalendarEventAttendees(int id, int calendarEventId, String email, String displayName, int resource) {
    this.id = id;
    this.calendarEventId = calendarEventId;
    this.email = email;
    this.displayName = displayName;
    this.resource = resource;
    this.createTime = new Date();
    this.modifiyTime = new Date();
    this.isDel = 0;
  }


  public CalendarEventAttendees(String email) {
    this.email = email;
  }

  /**
   * 主键
   */
  private int id;

  /**
   * 日历id
   */
  private int calendarEventId;

  /**
   * 用户ID
   */
  private int userId;


  /**
   * 收件人邮箱
   */
  private String email;


  /**
   * 同意状态 0默认1同意2已拒绝
   */
  private int acceptStatus;

  /**
   * 昵称
   */
  private String displayName="";

  /**
   * 是否资源0否1是
   */
  @Ignore
  private int resource;

  /**
   * 创建时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Date createTime;

  /**
   * 修改时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Date modifiyTime;

  /**
   * 删除状态0正常其他删除
   */
  @Ignore
  private int isDel;

  /**
   * 签到
   */
  private int checkin;

  /**
   * 翻页标识
   */
  @Ignore
  private String pageId;



  /**
   * 主键
   */
  public int getId() {
    return id;
  }

  /**
   * 主键
   */
  public void setId(int id) {
    this.id = id;
  }


  /**
   * 日历id
   */
  public int getCalendarEventId() {
    return calendarEventId;
  }

  /**
   * 日历id
   */
  public void setCalendarEventId(int calendarEventId) {
    this.calendarEventId = calendarEventId;
  }


  /**
   * 收件人邮箱
   */
  public String getEmail() {
    if (this.email==null){
      this.email = "";
    }
    return email;
  }

  /**
   * 收件人邮箱
   */
  public void setEmail(String email) {
    this.email = email;
  }


  /**
   * 昵称
   */
  public String getDisplayName() {
    if (displayName == null) {
      if (!StringUtils.isEmpty(this.email)) {
        this.displayName = this.email.split("@")[0];
      } else {
        displayName = "";
      }
    }
    return displayName;
  }

  /**
   * 昵称
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  /**
   * 是否资源0否1是
   */
  public int getResource() {
    return resource;
  }

  /**
   * 是否资源0否1是
   */
  public void setResource(int resource) {
    this.resource = resource;
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


  public String getPageId() {
    return pageId;
  }

  public void setPageId(String pageId) {
    this.pageId = pageId;
  }

}
