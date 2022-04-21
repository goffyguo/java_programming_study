package com.guofei.other.compress.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * 日历事件
 *
 * @author chenqiang
 */
@ToString
@Data
public class CalendarEvent {

    /**
     * id
     */
    private int id;

    /**
     * 标题
     */
    private String caleTitle = "";

    /**
     * 会议描述
     */
    private String caleDes = "";

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String beginTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String endTime;

    @ApiModelProperty(value = "是否是体验数据",hidden = true)
    private boolean demoData=false;
    /**
     * 会议时长分钟
     */
    private int duration;

    /**
     * 会议室id
     */
    private int roomId;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    private String roomName;
    /**
     * 第三方会议室邮箱
     */
    private String syncRoomEmail="";

    /**
     * 三方会议室标识
     */
    private String syncRoomIdentity = "";


    /**
     * 第三方会议室邮箱名称
     */
    private String syncRoomName="";


    /**
     * 公司ID
     */
    private int companyId;

    /**
     * 会议室类型 1 google日历  2 office 365  3 exchange  4 本地会议
     */
    private int meetingType;

    /**
     * 开始时间戳
     */
    private long beginTimeStamp;

    /**
     * 结束时间戳
     */
    private long endTimeStamp;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 开会日期
     */
    private Date meetingDay;

    /**
     * 修改时间
     */
    private Date modifiyTime;

    /**
     * 删除状态0正常其他删除
     */
    private int isDel;

    /**
     * 会议标识 appemId
     */
    private String calendarIdentity;


    /**
     * 用户日历日程ID
     */
    private String userCalendarId="";

    /**
     * 参会人
     */
    private String requiredAttendees = "[]";

    /**
     * 组织者
     */
    private String organizer="";



    /**
     * 创建人ID
     */
    private int userId;

    /**
     * 是否已经签到
     */
    @ApiModelProperty(value = "是否签到  0 未签到  1 已签到")
    private int checkAll;

    /**
     * 会议状态 1 已开启  2  已结束  3  未签到被取消  4 确认中  5  修改中
     */
    private int meetingStatus;

    /**
     * 是否自己的会议
     */
    @ApiModelProperty(value = "是否自己的会议，web端调用")
    private boolean selfCalendarEvent;

    /**
     * 是否允许参会人编辑
     */
    private int enableEdit;

    /**
     * 时区
     */
    private  String timeZone="Asia/Shanghai";

    /**
     * add by 2019-11-20
     * 1 正常   2  占用   3    会议中
     */
    private int roomStatus;
    /**
     * 会议室类型   1 zoom  2  普通  3 电话间  4  前台   5  其他
     */
    private int roomType ;
    /**
     * 本地会议室是否真正绑定zoom房间  0 否， 1 是
     */
    private int isBindZoom ;

    public String getSyncRoomName() {
        return syncRoomName;
    }

    public void setSyncRoomName(String syncRoomName) {
        this.syncRoomName = syncRoomName;
    }

    /**
     *  选择的群组ID逗号分隔
     */
    private String groupIds;
    private String  recurringEventId;

    private String   recurringDate;

    /**
     * 全天事件
     */
    private int allDay;

    private String  monthday;

    /**
     * 循环事件的设置
     */
    private String recurrenceSetting;

    /**
     * 提醒设置
     */
    private String reminders;

    /**
     *  提醒方式的类，无作用
     */

    private List<Integer> reminderList;


    /**
     * 事件来源 会议来源  0  web端  1 邮箱日历  2 设备预定  3 小程序
     */
    private int source;

    /**
     * 签到人姓名
     */
    private String checkInName;

    /**
     * 会议签到删除时间
     */
    private long cancelTime;

    /**
     * 会议开始签到时间
     */
    private long beginCheckInTime;

    /**
     * 日历和房间资源的关联关系
     */

    private List<CalendarEventRoom> calendarEventRooms;

    /**
     * 0 普通事件  1循环事件
     */
    private int eventType;

    /**
     * 1 开启审批  0没有开启
     */
    private  int openApply=0;


    /**
     * 未审批 0 、审批中 1、已通过2、已拒绝3 、已失效4、已取消 5
     */
    private  int applyStatus=1;
    /**
     * 0 没有同步外部rooms资源  1腾讯rooms  2
     * zooms
     */
    private  int  externalRoomsType=0;

    private String externalRoomsEventId;


    private  Integer addTcentMeet=1;

    public Integer getAddTcentMeet() {
        return addTcentMeet;
    }

    public void setAddTcentMeet(Integer addTcentMeet) {
        this.addTcentMeet = addTcentMeet;
    }

    public int getExternalRoomsType() {
        return externalRoomsType;
    }

    public void setExternalRoomsType(int externalRoomsType) {
        this.externalRoomsType = externalRoomsType;
    }

    public String getExternalRoomsEventId() {
        return externalRoomsEventId;
    }

    public void setExternalRoomsEventId(String externalRoomsEventId) {
        this.externalRoomsEventId = externalRoomsEventId;
    }

    public String getRecurringDate() {
        return recurringDate;
    }

    public void setRecurringDate(String recurringDate) {
        this.recurringDate = recurringDate;
    }

    public String getOrganizerNikeName() {
        return organizerNikeName;
    }

    public void setOrganizerNikeName(String organizerNikeName) {
        this.organizerNikeName = organizerNikeName;
    }

    private  String organizerNikeName;
    /**
     * 参会人列表
     */

     List<CalendarEventAttendees> calendarEventAttendees;

    /**
     * 远程的修改时间
     */
    private String remoteUpdated;

    public boolean isNeedCheck() {
        return needCheck;
    }

    public void setNeedCheck(boolean needCheck) {
        this.needCheck = needCheck;
    }

    private boolean needCheck=true;
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

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * 标题
     */
    public String getCaleTitle() {
        if (caleTitle == null) {
            caleTitle = "";
        }
        return caleTitle;
    }

    /**
     * 标题
     */
    public void setCaleTitle(String caleTitle) {
        this.caleTitle = caleTitle;
    }

    public String getMonthday() {
        return monthday;
    }

    public void setMonthday(String monthday) {
        this.monthday = monthday;
    }


    /**
     * 会议描述
     */
    public String getCaleDes() {
        if (caleDes==null){
            caleDes="";
            // return caleDes;
        }
        // //  直接在这里干了，其他地方范围太大
        // if (this.meetingType == 3 && StringUtils.isNotEmpty(this.caleDes) && this.caleDes.contains("<body")) {
        //     Matcher matcher = pattern.matcher(this.caleDes);
        //     if (matcher.find()) {
        //         String group = matcher.group(1);
        //         this.caleDes = group;
        //     }
        // }
        return caleDes;
    }

    public int getCheckAll() {
        return checkAll;
    }

    public void setCheckAll(int checkAll) {
        this.checkAll = checkAll;
    }

    public int getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(int meetingStatus) {
        this.meetingStatus = meetingStatus;
    }

    public boolean isSelfCalendarEvent() {
        return selfCalendarEvent;
    }

    public void setSelfCalendarEvent(boolean selfCalendarEvent) {
        this.selfCalendarEvent = selfCalendarEvent;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public int getIsBindZoom() {
        return isBindZoom;
    }

    public void setIsBindZoom(int isBindZoom) {
        this.isBindZoom = isBindZoom;
    }

    public String getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(String groupIds) {
        this.groupIds = groupIds;
    }

    public String getRecurringEventId() {
        return recurringEventId;
    }

    public void setRecurringEventId(String recurringEventId) {
        this.recurringEventId = recurringEventId;
    }

    /**
     * 会议描述
     */
    public void setCaleDes(String caleDes) {
        this.caleDes = caleDes;
    }


    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 会议时长分钟
     */
    public int getDuration() {
        if (this.beginTimeStamp > 0 && this.endTimeStamp > 0) {
            duration = (int) Math.ceil((this.endTimeStamp - this.beginTimeStamp) / (60 * 1000.0));
        }
        // if (duration <= 0) {
        //     duration = (int) Math.ceil((this.beginTimeStamp - this.endTimeStamp) / 60 * 1000.0);
        // }
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
     * 获取 会议标识 appemId
     */
    public String getCalendarIdentity() {
        return this.calendarIdentity;
    }

    /**
     * 设置 会议标识 appemId
     */
    public void setCalendarIdentity(String calendarIdentity) {
        this.calendarIdentity = calendarIdentity;
    }

    /**
     * 获取 参会人
     */
    public String getRequiredAttendees() {
        if (this.requiredAttendees == null || this.requiredAttendees.length() > 60000) {
            requiredAttendees = "[]";
        }
        return this.requiredAttendees;
    }

    /**
     * 设置 参会人
     */
    public void setRequiredAttendees(String requiredAttendees) {
        this.requiredAttendees = requiredAttendees;
    }

    /**
     * 获取 组织者
     */
    public String getOrganizer() {
        return this.organizer;
    }

    /**
     * 设置 组织者
     */
    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    /**
     * 获取 开会日期
     */
    public Date getMeetingDay() {
        return this.meetingDay;
    }

    /**
     * 设置 开会日期
     */
    public void setMeetingDay(Date meetingDay) {
        this.meetingDay = meetingDay;
    }

    /**
     * 获取 会议室类型 1 google日历  2 office 365  3 exchange  4 本地会议
     */
    public int getMeetingType() {
        return this.meetingType;
    }

    /**
     * 设置 会议室类型 1 google日历  2 office 365  3 exchange  4 本地会议
     */
    public void setMeetingType(int meetingType) {
        this.meetingType = meetingType;
    }

    /**
     * 获取 参会人列表
     */
    public List<CalendarEventAttendees> getCalendarEventAttendees() {
        if (this.calendarEventAttendees == null) {
            // if (StringUtils.isNotEmpty(this.requiredAttendees)) {
            //     try {
            //         List<CalendarEventAttendees> calendarEventAttendees = JsonUtils.toObjectList(this.requiredAttendees, CalendarEventAttendees.class);
            //         this.calendarEventAttendees = calendarEventAttendees;
            //     } catch (Exception e) {
            //
            //     }
            // } else {
            //     this.calendarEventAttendees = new ArrayList<>();
            // }
            this.calendarEventAttendees = new ArrayList<>();
        }
        return this.calendarEventAttendees;
    }

    /**
     * 设置 参会人列表
     */
    public void setCalendarEventAttendees(List<CalendarEventAttendees> calendarEventAttendees) {
        this.calendarEventAttendees = calendarEventAttendees;
    }

    /**
     * 获取 开始时间戳
     */
    public long getBeginTimeStamp() {
        return this.beginTimeStamp;
    }

    /**
     * 设置 开始时间戳
     */
    public void setBeginTimeStamp(long beginTimeStamp) {
        this.beginTimeStamp = beginTimeStamp;
    }

    /**
     * 获取 结束时间戳
     */
    public long getEndTimeStamp() {
        return this.endTimeStamp;
    }

    /**
     * 设置 结束时间戳
     */
    public void setEndTimeStamp(long endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

    /**
     * 获取 创建人ID
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * 设置 创建人ID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 获取 用户日历日程ID
     */
    public String getUserCalendarId() {
        if (userCalendarId == null) {
            this.userCalendarId = "";
        }
        return this.userCalendarId;
    }

    /**
     * 设置 用户日历日程ID
     */
    public void setUserCalendarId(String userCalendarId) {
        this.userCalendarId = userCalendarId;
    }

    public int getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(int roomStatus) {
        this.roomStatus = roomStatus;
    }


    /**
     * 获取 日历和房间资源的关联关系
     */
    public List<CalendarEventRoom> getCalendarEventRooms() {
        return this.calendarEventRooms;
    }

    /**
     * 设置 日历和房间资源的关联关系
     */
    public void setCalendarEventRooms(List<CalendarEventRoom> calendarEventRooms) {
        this.calendarEventRooms = calendarEventRooms;
    }

    /**
     * 获取 是否允许参会人编辑
     */
    public int getEnableEdit() {
        return this.enableEdit;
    }

    /**
     * 设置 是否允许参会人编辑
     */
    public void setEnableEdit(int enableEdit) {
        this.enableEdit = enableEdit;
    }

    /**
     * 获取 循环事件的设置
     */
    public String getRecurrenceSetting() {
        return this.recurrenceSetting;
    }

    /**
     * 设置 循环事件的设置
     */
    public void setRecurrenceSetting(String recurrenceSetting) {
        this.recurrenceSetting = recurrenceSetting;
    }

    /**
     * 获取 提醒设置
     */
    public String getReminders() {
        return this.reminders;
    }

    /**
     * 设置 提醒设置
     */
    public void setReminders(String reminders) {
        this.reminders = reminders;
    }

    /**
     * 获取 全天事件
     */
    public int getAllDay() {
        if (this.getDuration() > 23 * 60) {
            this.allDay = 1;
        } else {
            this.allDay = 0;
        }
        return this.allDay;
    }

    /**
     * 设置 全天事件
     */
    public void setAllDay(int allDay) {
        this.allDay = allDay;
    }


    public void resetBeginTime() {
        /*if (this.beginTimeStamp > 0) {
            this.beginTime = DateUtils.dateTimeToStr(this.beginTimeStamp);
        }

        if (this.endTimeStamp > 0) {
            this.endTime = DateUtils.dateTimeToStr(this.endTimeStamp);
        }*/
    }

    /**
     * 获取  事件来源 0 本地创建  1 外部同步
     */
    public int getSource() {
        return this.source;
    }

    @Override
    public String toString() {
        return "CalendarEvent{" +
            "id=" + id +
            ", caleTitle='" + caleTitle + '\'' +
            ", caleDes='" + caleDes + '\'' +
            ", beginTime='" + beginTime + '\'' +
            ", endTime='" + endTime + '\'' +
            ", duration=" + duration +
            ", roomId=" + roomId +
            ", syncRoomEmail='" + syncRoomEmail + '\'' +
            ", syncRoomIdentity='" + syncRoomIdentity + '\'' +
            ", companyId=" + companyId +
            ", meetingType=" + meetingType +
            ", beginTimeStamp=" + beginTimeStamp +
            ", endTimeStamp=" + endTimeStamp +
            ", createTime=" + createTime +
            ", meetingDay=" + meetingDay +
            ", modifiyTime=" + modifiyTime +
            ", isDel=" + isDel +
            ", calendarIdentity='" + calendarIdentity + '\'' +
            ", userCalendarId='" + userCalendarId + '\'' +
            ", requiredAttendees='" + requiredAttendees + '\'' +
            ", organizer='" + organizer + '\'' +
            ", userId=" + userId +
            ", checkAll=" + checkAll +
            ", meetingStatus=" + meetingStatus +
            ", selfCalendarEvent=" + selfCalendarEvent +
            ", enableEdit=" + enableEdit +
            ", timeZone='" + timeZone + '\'' +
            ", roomStatus=" + roomStatus +
            ", roomType=" + roomType +
            ", isBindZoom=" + isBindZoom +
            ", groupIds='" + groupIds + '\'' +
            ", recurringEventId='" + recurringEventId + '\'' +
            ", recurringDate='" + recurringDate + '\'' +
            ", allDay=" + allDay +
            ", monthday='" + monthday + '\'' +
            ", recurrenceSetting='" + recurrenceSetting + '\'' +
            ", reminders='" + reminders + '\'' +
            ", source=" + source +
            ", checkInName='" + checkInName + '\'' +
            ", calendarEventRooms=" + calendarEventRooms +
            ", organizerNikeName='" + organizerNikeName + '\'' +
            ", calendarEventAttendees=" + calendarEventAttendees +
            ", addTcentMeet=" + addTcentMeet +

            '}';
    }

    /**
     * 设置  事件来源 0 本地创建  1 外部同步
     */
    public void setSource(int source) {
        this.source = source;
    }

    public String getCheckInName() {
        return checkInName;
    }

    public void setCheckInName(String checkInName) {
        this.checkInName = checkInName;
    }

    /**
     * 获取 远程的修改时间
     */
    public String getRemoteUpdated() {
        return this.remoteUpdated;
    }

    /**
     * 设置 远程的修改时间
     */
    public void setRemoteUpdated(String remoteUpdated) {
        this.remoteUpdated = remoteUpdated;
    }

    /**
     *  获取变更时间戳
     */
    public long getUpdateTimeStamp(){
        if (this.modifiyTime==null){
            return System.currentTimeMillis();
        }
        return this.modifiyTime.getTime();
    }


    /**
     * 获取 会议签到删除时间
     */
    public long getCancelTime() {
        return this.cancelTime;
    }

    /**
     * 设置 会议签到删除时间
     */
    public void setCancelTime(long cancelTime) {
        this.cancelTime = cancelTime;
    }

    /**
     * 获取 会议开始签到时间
     */
    public long getBeginCheckInTime() {
        return this.beginCheckInTime;
    }

    /**
     * 设置 会议开始签到时间
     */
    public void setBeginCheckInTime(long beginCheckInTime) {
        this.beginCheckInTime = beginCheckInTime;
    }

    /**
     * 获取  0 普通事件  1循环事件
     */
    public int getEventType() {
        if (!StringUtils.isEmpty(this.getRecurringEventId())) {
            this.eventType = 1;
        } else {
            this.eventType = 0;
        }
        return this.eventType;
    }

    /**
     * 设置  0 普通事件  1循环事件
     */
    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getOpenApply() {
        return openApply;
    }

    public void setOpenApply(int openApply) {
        this.openApply = openApply;
    }

    public int getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(int applyStatus) {
        this.applyStatus = applyStatus;
    }

    public List<Integer> getReminderList(){
        //  提醒方式设置
        if (!StringUtils.isEmpty(this.reminders)) {
            List<Integer> integerList = Arrays.stream(this.getReminders().split(","))
                    .map(Integer::parseInt).collect(Collectors.toList());
            return integerList;
        }
        return null;
    }

    public void setReminderList(List<Integer> reminderList) {
        this.reminderList = reminderList;
    }
}
