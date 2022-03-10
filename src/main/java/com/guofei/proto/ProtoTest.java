package com.guofei.proto;



import com.google.protobuf.InvalidProtocolBufferException;
import domain.PersonEntity;
import java.util.Arrays;

/**
 * @author: GuoFei
 * @date: 2022-03-10 10:27
 */
public class ProtoTest {
  public static void main(String[] args) throws InvalidProtocolBufferException {


    //通过PersonEntity的内部类Builder来构建builder
    PersonEntity.Person.Builder personBuilder = PersonEntity.Person.newBuilder();
    //通过PersonEntity的内部类builder提供了构建Person相关属性的set方法
    personBuilder.setId(1);
    personBuilder.setName("张三");
    personBuilder.setEmail("123456@qq.com");

    //序列化
    PersonEntity.Person personEntity = personBuilder.build();
    System.out.println("protobuf数据bytes[]:" + Arrays.toString(personEntity.toByteArray()));
    System.out.println("protobuf数据大小: " + personEntity.toByteString().size());

    //再将封装有数据的对象实例，转换为字节数组，用于数据传输、存储等
    byte[] bytes = personEntity.toByteArray();
    /**
     * 这里得到了bytes字节数组后，我们可以将该数据进行数据传输或存储，这里至于用什么技术传输就根据具体情况而定
     * 通常我们进行rpc通信传输数据类型会用protobuf
     * 假如这里bytes通过传输，另一个项目获取到改bytes数据后进行反序列化操作
     *
     */
    //将字节数据反序列化为对应的对象实例
    PersonEntity.Person person = null;
    try {

      person = PersonEntity.Person.parseFrom(bytes);
      //这里得到了Person实例了，可以根据需要来操作里面的数据了
      System.out.println("学生ID:" + person.getId());
      System.out.println("姓名：" + person.getName());
      System.out.println("邮箱：" + person.getEmail());
    } catch (InvalidProtocolBufferException e) {

      e.printStackTrace();
    }
    /*进行json格式化*/
    /*String jsonObject = JsonFormat.printer().print(person);// 此处有异常需要处理
    System.out.println("格式化结果:\n" + jsonObject);
    System.out.println("Json格式化数据大小: " + jsonObject.getBytes().length);*/
  }
}
