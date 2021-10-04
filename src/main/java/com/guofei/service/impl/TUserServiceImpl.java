package com.guofei.service.impl;

import com.guofei.domain.TUser;
import com.guofei.mapper.TUserMapper;
import com.guofei.service.TUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/10/04/11:27
 * @Description:
 */
@Service
public class TUserServiceImpl implements TUserService {

    @Resource
    private TUserMapper tUserMapper;

    @Override
    public int addUser(TUser tUser) {
        return tUserMapper.insert(tUser);
    }
}
