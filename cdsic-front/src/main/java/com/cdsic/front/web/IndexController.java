package com.cdsic.front.web;

import com.cdsic.front.entity.NewsEntity;
import com.cdsic.front.entity.ProjectEntity;
import com.cdsic.front.service.NewsService;
import com.cdsic.front.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    NewsService newsService;

    @Autowired
    ProjectService projectService;


    @GetMapping({"/", "/index", "/index.html"})
    public String indexPage(Model model) {
        // 查出团队新闻【c_news】日期最晚的5条记录
        List<NewsEntity> NewsEntities = newsService.getRecentNews(5);
        model.addAttribute("news", NewsEntities);
        // 查出轮播图需要展示的项目【c_project】
        List<ProjectEntity> projectEntities = projectService.getCarouselProject();
        model.addAttribute("project", projectEntities);
        return "index";
    }

}
