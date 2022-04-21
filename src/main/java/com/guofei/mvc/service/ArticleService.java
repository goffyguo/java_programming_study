package com.guofei.mvc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.StringReader;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/10/15/10:36
 * @Description:
 */
@Service
@Slf4j
public class ArticleService {

    public static final String ARTICLE = "article:";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void likeArticle(Integer articleId) {
        String key = ARTICLE + articleId;
        Long increment = stringRedisTemplate.opsForValue().increment(key);
        log.info("文章编号:{},喜欢数:{}",articleId,increment);
    }
}
