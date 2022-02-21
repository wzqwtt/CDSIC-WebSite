package com.cdsic.front.web;

import com.cdsic.front.entity.NewsEntity;
import com.cdsic.front.entity.ProjectByYearsEntity;
import com.cdsic.front.entity.ProjectEntity;
import com.cdsic.front.service.NewsService;
import com.cdsic.front.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProjectPageController {

    @Autowired
    NewsService newsService;

    @Autowired
    ProjectService projectService;

    @GetMapping({"/project", "/project.html"})
    public String projectPage(Model model) {

        // 查出最近6条news
        List<NewsEntity> newsEntities = newsService.getRecentNews(6);
        model.addAttribute("news", newsEntities);

        // 按照年份查出所有的project
        List<ProjectByYearsEntity> projectByYearsEntities = projectService.getAllProjectByYear();
        model.addAttribute("project", projectByYearsEntities);

        return "project";
    }

    @GetMapping("/project/{pid}")
    public String singleProjectPage(@PathVariable(value = "pid") Integer pid, Model model) {

        // 查出最近6条news
        List<NewsEntity> newsEntities = newsService.getRecentNews(6);
        model.addAttribute("news", newsEntities);

        // 获取id为pid的project
        ProjectEntity projectEntity = projectService.getProjectById(pid);
        model.addAttribute("project", projectEntity);

        return "singleProject";
    }

}
