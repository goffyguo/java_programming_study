package com.guofei.service.impl;

import com.guofei.domain.TUser;
import com.guofei.mapper.TUserMapper;
import com.guofei.service.TUserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/10/04/11:27
 * @Description:
 */
@Service
public class TUserServiceImpl implements TUserService {

    public static final String CACHE_KEY_USER = "user:";

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private TUserMapper tUserMapper;

    @Override
    public int addUser(TUser tUser) {

        int insert = tUserMapper.insert(tUser);
        if (insert > 0){
            tUser = tUserMapper.selectById(tUser.getId());
            String key = CACHE_KEY_USER + tUser.getId();
            redisTemplate.opsForValue().set(key, tUser);
        }
        return tUserMapper.insert(tUser);
    }

    @Override
    public void deleteUser(int id){
        int i = tUserMapper.deleteById(id);
        if (i > 0){
            redisTemplate.delete(CACHE_KEY_USER + id);
        }
    }

    @Override
    public  void updateUser(TUser tUser){
        int i = tUserMapper.updateById(tUser);
        if (i > 0){
            tUser = tUserMapper.selectById(tUser.getId());
            String key = CACHE_KEY_USER + tUser.getId();
            redisTemplate.opsForValue().set(key, tUser);
        }
    }

    @Override
    public TUser getUserById(int id){
        TUser tUser = null;
        String key = CACHE_KEY_USER + tUser.getId();
        tUser = (TUser) redisTemplate.opsForValue().get(key);
        if (tUser == null){
            tUser = tUserMapper.selectById(id);
            if (tUser == null){
                return null;
            }else{
                redisTemplate.opsForValue().set(key,tUser);
            }
        }
        return tUser;
    }

    @Override
    public TUser getUser() {
        return tUserMapper.selectOne(null);
    }

    public TUser getUserById2(int id){
        TUser tUser = null;
        String key = CACHE_KEY_USER + tUser.getId();

        // 1、先从 redis 里面查询，如果有直接返回结果，如果没有再去 mysql 里面查询
        tUser = (TUser) redisTemplate.opsForValue().get(key);
        if (tUser == null) {
            // 2、大厂用，对于高 QPS 的优化，进来就就先加锁，保证只有一个请求操作，让外面的 redis 等待一下，避免击穿 mysql
            synchronized (TUserServiceImpl.class){
                tUser = (TUser) redisTemplate.opsForValue().get(key);
                // 3、二次查询 redis 还是 null,可以去 mysql 里面查询了
                if (tUser == null) {
                    // 4、查询 mysql 取数据
                    tUser = tUserMapper.selectById(id);
                    if (tUser == null) {
                        return null;
                    }else{
                        // 5、mysql 里面的数据回写 redis
                        redisTemplate.opsForValue().setIfAbsent(key,tUser,7L, TimeUnit.DAYS);
                    }
                }
            }
        }

        return tUser;
    }
}
