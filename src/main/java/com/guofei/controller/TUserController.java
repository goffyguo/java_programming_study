package com.guofei.controller;

import com.guofei.domain.TUser;
import com.guofei.service.TUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @RequestMapping("addUser")
    public String addUser(@RequestBody TUser tUser){
        int i = tUserService.addUser(tUser);
        return i+"";
    }
}
