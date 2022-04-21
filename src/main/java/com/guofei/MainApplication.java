package com.guofei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/10/04/10:44
 * @Description:
 */
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@MapperScan(basePackages = {"com.guofei.mvc.mapper"})
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
