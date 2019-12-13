package com.example.demo.controller.wp;

import com.example.demo.entity.News;
import com.example.demo.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("wp")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/News/{nId}")
    public String getNews(@PathVariable Integer nId, Model model) {
        News news = newsService.getNews(nId);
        model.addAttribute("news",news);
        return "wp/NewsPage";
    }

    @RequestMapping("NewsListPage")
    public String getNewsList(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<News> newsList = newsService.selectAll2();
        PageInfo<News> pageInfo = new PageInfo<News>(newsList);


        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("news", newsList);
        return "wp/NewsListPage";
    }


}
