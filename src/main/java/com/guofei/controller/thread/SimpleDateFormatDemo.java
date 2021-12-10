package com.guofei.controller.thread;

import net.sf.jsqlparser.expression.StringValue;
import org.springframework.ui.context.Theme;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/08/11:25
 * @Description:
 */
public class SimpleDateFormatDemo {

    /*public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date parseDate(String stringDate) throws ParseException {
        return sdf.parse(stringDate);
    }*/


    public static final ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static Date parseDateTL(String stringDate) throws ParseException {
        return sdf.get().parse(stringDate);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                try {
                    System.out.println(SimpleDateFormatDemo.parseDateTL("2021-11-11 11:11:11"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
