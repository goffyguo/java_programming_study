package com.guofei.mvc.service;

import com.guofei.mvc.domain.TUser;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/10/04/11:27
 * @Description:
 */
public interface TUserService {

    int addUser(TUser tUser);

    void deleteUser(int id);

    void updateUser(TUser tUser);

    TUser getUserById(int id);

    TUser getUser();


    void register(String userName);
}
