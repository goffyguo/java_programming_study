package com.guofei.other.compress.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guofei.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.jackson.dataformat.MessagePackFactory;

/**
 * @author: GuoFei
 * @date: 2022-03-12 13:30
 */
public class MessagePackExample2 {

  public static void main(String[] args) throws IOException {
    /*// map
    ObjectMapper objectMapper = new ObjectMapper(new MessagePackFactory());

    *//*Map<String, Object> map = new HashMap<>();
    map.put("name", "komamitsu");
    Person guofei = new Person("1", "guofei", "25");
    map.put("person", guofei);*//*
    System.out.println("原始长度---------"+getMap().toString().length());
    byte[] bytes = objectMapper.writeValueAsBytes(getMap());
    String s = byteToString(bytes);
    System.out.println("压缩后长度---------"+s.length());
    *//*System.out.print("--------------压缩后------------");
    System.out.print(s);*//*
    //Map<String, Object> deserialized = objectMapper.readValue(bytes, new TypeReference<Map<String, Object>>() {});
    // CalendarEvent deserialized = objectMapper.readValue(bytes, CalendarEvent.class);
    //System.out.println(deserialized);*/


    // Instantiate ObjectMapper for MessagePack
    ObjectMapper objectMapper = new ObjectMapper(new MessagePackFactory());

    MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();


    // Serialize a Java object to byte array
    Person pojo = new Person("1","test","26");
    String s = JsonUtils.toString(pojo);
    System.out.println("原始长度---------"+s.length());
    System.out.println("原始---------"+s);
    final String s1 = packer.packString(s).toString();
    packer.close();
    System.out.println("压缩后的长度---------"+s1.length());
    System.out.println("压缩后---------"+s1);
    /*byte[] bytes = objectMapper.writeValueAsBytes(pojo);
    String s1 = byteToString(bytes);
    System.out.println("压缩后长度---------"+s1.length());
    // Deserialize the byte array to a Java object
    Person deserialized = objectMapper.readValue(bytes, Person.class);
    System.out.println(deserialized.getName()); // => komamitsu*/

  }


  private static Map<String, List<CalendarEvent>> getMap(){
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
    System.out.println(map);
    return map;

  }






  private static CalendarEvent getEvent(){
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
    return event;
  }
}
