package com.guofei.mvc.controller;

import com.guofei.mvc.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/10/15/10:35
 * @Description: 文章喜欢点击数场景实现
 */

@RestController
@Slf4j
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @PostMapping(value = "/view/{articleId}")
    public void likeArticle(@PathVariable(value = "articleId") Integer articleId){
        articleService.likeArticle(articleId);
    }
}
