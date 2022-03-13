package com.guofei.compress;

import com.guofei.JsonUtils;
import com.guofei.example.CalendarEvent;
import com.guofei.example.CalendarEventRoom;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author: GuoFei
 * @date: 2022-03-13 19:21
 */
public class CompressMain {

  public static void main(String[] args) throws IOException {
    String map = getMap();
    System.out.println(map);
    final String compress = CompressUtils.compress(map);
    System.out.println(compress);

    final String uncompress = CompressUtils.uncompress(compress);
    System.out.println(uncompress);
  }


  /**
   *
   * @return Map<String, List<CalendarEvent>>
   */
  private static String getMap(){
    List<CalendarEvent> list0 = new ArrayList();
    CalendarEvent event = new CalendarEvent();
    event.setAllDay(1);
    CalendarEventRoom eventRoom = new CalendarEventRoom();
    eventRoom.setRoomId(1);
    CalendarEventRoom eventRoom1 = new CalendarEventRoom();
    eventRoom1.setRoomId(1);
    List list = new ArrayList();
    list.add(eventRoom);
    list.add(eventRoom1);
    event.setCalendarEventRooms(list);
    event.setCalendarEventRooms(list);
    list0.add(event);
    list0.add(event);
    Map<String,List<CalendarEvent>> map =new HashMap();
    map.put("2022-3-17",list0);
    map.put("2022-3-18",list0);
    // System.out.println(map);
    String s = JsonUtils.toString(map);
    return s;

  }

  public static String byteToString(byte [] bytes){
    return new BASE64Encoder().encodeBuffer(bytes);
  }
  public static byte [] stringToBytes(String  string) throws IOException {
    return new BASE64Decoder().decodeBuffer(string);
  }

}
