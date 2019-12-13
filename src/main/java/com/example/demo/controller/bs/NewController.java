package com.example.demo.controller.bs;

import com.example.demo.entity.Logs;
import com.example.demo.entity.News;
import com.example.demo.service.LogsService;
import com.example.demo.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("bs")
public class NewController {
    @Autowired
    private NewsService newsService;

    /**
     * 全选
     */
    @RequestMapping("news")
    public String getNews(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                          @RequestParam(defaultValue = "null", value = "n_title") String n_title, @RequestParam(defaultValue = "0", value = "sortFlag") String sortFlag) {
        PageHelper.startPage(pageNum, 10);
        List<News> newsList = newsService.selectAll(n_title, sortFlag);
        PageInfo<News> pageInfo = new PageInfo<News>(newsList);

//        System.out.println(sortFlag);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("news", newsList);
        return "bs/news";
    }

    /**
     * 按主键选择
     */
    @RequestMapping(value = "/newsSelectByPrimaryKey")
    @RequiresPermissions("10301")
    @ResponseBody
    public News selectByPrimaryKey(int n_id) {
        News news = newsService.selectByPrimaryKey(n_id);
        return news;
    }

    /**
     * 按主键删除
     */
    @RequestMapping(value = "/newsDeleteByPrimaryKey")
    @RequiresPermissions("10302")
    @ResponseBody
    public int deleteByPrimaryKey(int n_id) {
        return newsService.deleteByPrimaryKey(n_id);
    }

    /**
     * 按主键批量删除
     */
    @RequestMapping(value = "/newsDeleteByBatch")
    @RequiresPermissions("10302")
    @ResponseBody
    public int deleteByBatch(String n_ids) {
        String[] n_ids2 = n_ids.split("\\s");
        return newsService.deleteByBatch(n_ids2);
    }

    /**
     * 插入
     */
    @RequestMapping(value = "/newsInsert")
    @RequiresPermissions("10301")
    @ResponseBody
    public int insert(String n_title, String n_date, String n_text, String n_link) throws ParseException {
        /*时间格式处理*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date n_date2 = sdf.parse(n_date);
        News news = new News();
        news.setnTitle(n_title);
        news.setnDate(n_date2);
        news.setnText(n_text);
        return newsService.insert(news);
    }

    /**
     * 按主键更新
     */
    @RequestMapping(value = "/newsUpdate")
    @RequiresPermissions("10301")
    @ResponseBody
    public int update(Integer n_id, String n_title, String n_date, String n_date_modified, String n_text, Integer n_status) throws ParseException {
        /*时间格式处理*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date n_date2 = sdf.parse(n_date);
        Date n_date_modified2 = sdf.parse(n_date_modified);
        News news = new News();
        news.setnId(n_id);
        news.setnTitle(n_title);
        news.setnDate(n_date2);
        news.setnText(n_text);
        news.setnDateModified(n_date_modified2);
        news.setnStatus(n_status);
        return newsService.update(news);
    }
}
