package com.guofei.controller;

import cn.hutool.json.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.guofei.domain.TUser;
import com.guofei.domain.dto.UserDTO;
import com.guofei.service.TUserService;
import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/10/04/11:25
 * @Description:
 */

@RestController
public class TUserController {

    @Resource
    private TUserService tUserService;

    @PostMapping(value = "user/add")
    public String addUser(){
        for (int i = 1; i <= 5; i++) {
            TUser user = new TUser();
            user.setUsername("guofei" + i);
            user.setPassword(i+"");
            user.setSex((byte) new Random().nextInt(2));
            tUserService.addUser(user);
        }
        return "Ok";
    }

    @PostMapping("user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        tUserService.deleteUser(id);
        return "Ok";
    }

    @RequestMapping("user/update")
    public String updateUser(@RequestBody UserDTO userDTO){
        TUser user = new TUser();
        BeanUtils.copyProperties(userDTO,user);
        tUserService.updateUser(user);
        return "Ok";
    }

    @GetMapping("user/{id}")
    public String user(@PathVariable("id") Integer id){
        TUser userById = tUserService.getUserById(id);
        return userById.toString();
    }

    @GetMapping("/getUser")
    public String user(){
        TUser user = tUserService.getUser();
        return user.toString();
    }
}
