package com.cdsic.front.web;

import com.cdsic.front.entity.NewsEntity;
import com.cdsic.front.entity.ProjectEntity;
import com.cdsic.front.service.NewsService;
import com.cdsic.front.service.ProjectService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class NewsPageController {

    @Autowired
    NewsService newsService;

    @Autowired
    ProjectService projectService;

    @GetMapping({"/news","/news.html"})
    public String newsPage(Model model) {

        // 获取所有新闻
        List<NewsEntity> NewsEntities = newsService.getNewsOrderDescByDate();

        model.addAttribute("news", NewsEntities);

        // 获取一个月前的时间
        Date now = new Date();
        Date startDate = DateUtils.addDays(now, -30);
        model.addAttribute("time", startDate);

        // 获取最近六条Project数据
        List<ProjectEntity> projectEntities = projectService.getRecentProject(6);
        model.addAttribute("project", projectEntities);

        return "news";
    }

//    @GetMapping("/news/")
//    public String singleNewsPage(Model model) {
//
//    }

}
